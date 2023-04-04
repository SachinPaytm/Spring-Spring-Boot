package com.udemy.learnaop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.udemy.learnaop.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.udemy.learnaop.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.udemy.learnaop.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.udemy.learnaop.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}