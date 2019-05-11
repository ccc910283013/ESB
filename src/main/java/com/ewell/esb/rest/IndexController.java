package com.ewell.esb.rest;

import com.ewell.esb.bean.PatVisitInfo;
import com.ewell.esb.common.dto.BaseResponse;
import com.ewell.esb.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET,value = "/test03",produces = "application/json;charset=utf-8")
    public BaseResponse<PatVisitInfo> test03(){
        PatVisitInfo info = new PatVisitInfo();
        info.setPatId("1");
        info.setVisitId("2");
        info.setBodyWeight("3");
        info.setBodyHeight("4");

        return new BaseResponse<>("0", "更新成功", info);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/test04",produces = "application/json;charset=utf-8")
    public BaseResponse<List<String>> test04(){
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        return new BaseResponse<>("0", "更新成功", a);
    }
}
