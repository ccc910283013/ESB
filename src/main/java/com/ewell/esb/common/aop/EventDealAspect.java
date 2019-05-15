package com.ewell.esb.common.aop;

import com.ewell.esb.common.exception.EventFilterException;
import com.ewell.esb.common.util.DealStatusConstant;
import com.ewell.esb.mq.service.ESBEventLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
@Aspect
public class EventDealAspect {
    @Resource
    private ESBEventLogService esbImpl;
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
        } catch (Throwable e2){
            throw new Exception(e2);
        }
        esbImpl.esbEventTransDeal(joinPoint,DealStatusConstant.SUCCESS);
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
        esbImpl.esbEventTransDeal(joinPoint,DealStatusConstant.FAILED);
    }
}
