package com.ewell.esb.common.aop;

import com.ewell.esb.common.config.handler.DatabaseContextHolder;
import com.ewell.esb.common.util.DBSourceConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源切换的aop
 */
@Slf4j
@Component
@Aspect
@Order(1)
@ConditionalOnProperty(name = "muti-datasource-open", havingValue = "true")
public class MultiSourceAspect{
    @Pointcut(value = "@annotation(com.ewell.esb.common.aop.MultiSource)")
    private void MultiSourceCut() {
    }

    @Around("MultiSourceCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Signature signature = point.getSignature();
        MethodSignature methodSignature = null;
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        methodSignature = (MethodSignature) signature;

        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

        MultiSource datasource = currentMethod.getAnnotation(MultiSource.class);
        if (datasource != null) {
            DatabaseContextHolder.setDataSourceType(datasource.name());
            log.debug("设置数据源为：" + datasource.name());
        } else {
            DatabaseContextHolder.setDataSourceType(DBSourceConstant.DATA_SOURCE_MASTER);
            log.debug("设置数据源为：dataSourceCore");
        }
        try {
            return point.proceed();
        } finally {
            log.debug("清空数据源信息！");
            DatabaseContextHolder.clearDataSourceType();
        }
    }

}
