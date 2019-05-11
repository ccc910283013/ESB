package com.ewell.esb.common.webservice.service.impl;

import com.ewell.esb.common.dto.User;
import com.ewell.esb.common.webservice.service.HelloWorldService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;


@WebService(name = "HelloWorldService",
        targetNamespace = "http://common.esb.ewell.com/",
        endpointInterface = "com.ewell.esb.common.webservice.service.HelloWorldService"
)
@Component
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }

    @Override
    public User getUser(String name) {
        return new User("爸爸");
    }

    @Override
    public int test() {
        return 1/0;
    }
}
