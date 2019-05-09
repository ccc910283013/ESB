package com.ewell.esb.common.aop;

import com.ewell.esb.bean.ESBEventInfo;
import com.ewell.esb.common.util.ThrowableUtil;
import com.ewell.esb.service.ESBEventLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EventDealAspect {
    private static final Logger logger = LoggerFactory.getLogger(EventDealAspect.class);
    @Autowired
    ESBEventLogService esbImpl;
    /**
     * 配置切入点
     */
    @Pointcut("@annotation(com.ewell.esb.common.aop.EventDeal)")
    public void EventPointcut() {
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Around("EventPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Exception{
        Object result = null;
        try {
            //执行目标方法
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
        esbImpl.esbEventTransDeal(joinPoint,"0");
        return result;
    }
    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(pointcut = "EventPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        esbImpl.esbEventTransDeal(joinPoint,"2");
    }
}
