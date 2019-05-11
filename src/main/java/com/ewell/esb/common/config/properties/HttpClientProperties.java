package com.ewell.esb.common.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HttpClientProperties {
    /**
     * 建立连接的超时时间
     */
    @Value("${httpclient.connectTimeout}")
    private int connectTimeout;
    /**
     * 连接不够用的等待时间
     */
    @Value("${httpclient.requestTimeout}")
    private int requestTimeout;
    /**
     * 每次请求等待返回的超时时间
     */
    @Value("${httpclient.socketTimeout}")
    private int socketTimeout;
    /**
     * 每个主机最大连接数
     */
    @Value("${httpclient.defaultMaxPerRoute}")
    private int defaultMaxPerRoute;
    /**
     * 最大连接数
     */
    @Value("${httpclient.maxTotalConnections}")
    private int maxTotalConnections;
    /**
     * 默认连接保持活跃的时间
     */
    @Value("${httpclient.defaultKeepAliveTimeMillis}")
    private int defaultKeepAliveTimeMillis;
    /**
     * 空闲连接生的存时间
     */
    @Value("${httpclient.closeIdleConnectionWaitTimeSecs}")
    private int closeIdleConnectionWaitTimeSecs;

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(int requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getDefaultMaxPerRoute() {
        return defaultMaxPerRoute;
    }

    public void setDefaultMaxPerRoute(int defaultMaxPerRoute) {
        this.defaultMaxPerRoute = defaultMaxPerRoute;
    }

    public int getMaxTotalConnections() {
        return maxTotalConnections;
    }

    public void setMaxTotalConnections(int maxTotalConnections) {
        this.maxTotalConnections = maxTotalConnections;
    }

    public int getDefaultKeepAliveTimeMillis() {
        return defaultKeepAliveTimeMillis;
    }

    public void setDefaultKeepAliveTimeMillis(int defaultKeepAliveTimeMillis) {
        this.defaultKeepAliveTimeMillis = defaultKeepAliveTimeMillis;
    }

    public int getCloseIdleConnectionWaitTimeSecs() {
        return closeIdleConnectionWaitTimeSecs;
    }

    public void setCloseIdleConnectionWaitTimeSecs(int closeIdleConnectionWaitTimeSecs) {
        this.closeIdleConnectionWaitTimeSecs = closeIdleConnectionWaitTimeSecs;
    }
}
