package com.ewell.esb.common.config;

import com.ewell.esb.common.config.properties.HttpClientProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.Resource;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@EnableScheduling
public class HttpClientConfig {


    @Resource
    private HttpClientProperties p;

    /**
     * 配置支持HTTP、HTTPS连接
     * @return
     */
    @Bean
    public PoolingHttpClientConnectionManager poolingConnectionManager() {
        SSLContextBuilder builder = new SSLContextBuilder();
        try {
            builder.loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] arg0, String arg1) {
                    return true;
                }
            });
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            log.error("HTTPS连接池初始化异常，原因是-->" + e.getMessage(), e);
        }

        SSLConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(builder.build());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            log.error("HTTPS连接池初始化异常，原因是-->" + e.getMessage(), e);
        }

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                .<ConnectionSocketFactory>create()
                .register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();

        PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        //最大连接数
        poolingConnectionManager.setMaxTotal(p.getMaxTotalConnections());
        //同路由并发数
        poolingConnectionManager.setDefaultMaxPerRoute(p.getDefaultMaxPerRoute());
        return poolingConnectionManager;
    }
    /**
     * 获取连接保持时间
     * @return
     */
    @Bean
    public ConnectionKeepAliveStrategy connectionKeepAliveStrategy() {
        return new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext httpContext) {
                HeaderElementIterator it = new BasicHeaderElementIterator
                        (response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()) {
                    HeaderElement he = it.nextElement();
                    String param = he.getName();
                    String value = he.getValue();
                    if (value != null && param.equalsIgnoreCase("timeout")) {
                        return Long.parseLong(value) * 1000;
                    }
                }
                return p.getDefaultKeepAliveTimeMillis();
            }
        };
    }

    @Bean
    public CloseableHttpClient httpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(p.getRequestTimeout())
                .setConnectTimeout(p.getConnectTimeout())
                .setSocketTimeout(p.getSocketTimeout()).build();

        return HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(poolingConnectionManager())
                .setKeepAliveStrategy(connectionKeepAliveStrategy())
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true))  // 重试次数
                .build();
    }
    @Bean
    public Runnable idleConnectionMonitor(final PoolingHttpClientConnectionManager connectionManager) {

        return new Runnable() {
            @Override
            @Scheduled(fixedDelay = 10000)
            public void run() {
                try {
                    if (connectionManager != null) {
                        log.trace("run IdleConnectionMonitor - Closing expired and idle connections...");
                        connectionManager.closeExpiredConnections();
                        connectionManager.closeIdleConnections(p.getCloseIdleConnectionWaitTimeSecs(), TimeUnit.SECONDS);
                    } else {
                        log.trace("run IdleConnectionMonitor - Http Client Connection manager is not initialised");
                    }
                } catch (Exception e) {
                    log.error("run IdleConnectionMonitor - Exception occurred. msg={}, e={}", e.getMessage(), e);
                }
            }
        };
    }
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("httpClientPool");
        scheduler.setPoolSize(50);
        return scheduler;
    }
}
