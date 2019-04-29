package com.ewell.esb.rest;

import com.ewell.esb.bean.EMRSEventInfo;
import com.ewell.esb.dao.EMRSEventInfoDao;
import com.ewell.esb.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping
public class IndexController {
    @Autowired
    private TestDao t;
    @RequestMapping(method = RequestMethod.GET,value = "/test02",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String test02(){
        String a =t.findSum();
        System.out.println(a);
        return  "123123";
    }

}
