package com.ewell.esb.common.config;

import com.ewell.esb.common.webservice.service.HelloWorldService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {
    @Autowired
    Bus bus;
    @Autowired
    HelloWorldService hwService;
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, hwService);
        endpoint.publish("/HelloWorldService");
        return endpoint;
    }
}

