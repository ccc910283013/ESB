package com.ewell.esb.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//暂不用
//@Aspect
//@Component
public class DynamicDataSourceAspect {

    @Around("execution(* com.ewell.esb.dao..*.*(..))")
    public Object  around(ProceedingJoinPoint pjp) throws Throwable {
        return null;
    }

}
