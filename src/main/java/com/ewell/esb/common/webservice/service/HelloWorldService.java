package com.ewell.esb.common.webservice.service;

import com.ewell.esb.common.dto.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "HelloWorldService",targetNamespace = "http://common.esb.ewell.com/")
public interface HelloWorldService {
    @WebMethod
    public String sayHello(@WebParam(name = "userName") String name);
    @WebMethod
    public User getUser(@WebParam(name = "userName")String name);
    @WebMethod
    public int test();
}
