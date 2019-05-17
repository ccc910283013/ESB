package com.ewell.esb.common.aop;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MultiSource {

    String name() default "";
}
