package com.ewell.esb;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.common.util.DateUtil;
import com.ewell.esb.common.webservice.FYClient.Mchis;
import com.ewell.esb.common.webservice.FYClient.MchisPortType;

import com.ewell.esb.dao.TestDao;
import com.ewell.esb.mq.service.ESBEventLogService;
import com.ewell.esb.mq.service.TestService;
import com.ewell.esb.mq.util.MQFactoryUtil;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsbApplicationTests {
    @Autowired
    private TestService testService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ESBEventLogService service;
    @Test
    public void contextLoads() throws Exception{
        //Boolean b = service.esbEventDeal(DateUtil.getCurrentTime());
        try {
        }catch (Exception e){
            e.printStackTrace();

        }
            testService.test01();

        /*
        try {
            testService.test02();
        }catch (Exception e){
            e.printStackTrace();
        }
        */
    }

    //@Test
    public  void testPost() throws Exception{
        URI url = new URI(
                "https://api.jisuapi.com/area/province?appkey=700ee5c34d4863d5");
        RequestEntity requestEntity = RequestEntity
                .get(url)
                .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity responseEntity = restTemplate.exchange(requestEntity, String.class);
        System.out.println(responseEntity.getBody());
    }
}
