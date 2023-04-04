package com.udemy.learnaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//@Configuration
@Aspect
public class AspectLogger {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.udemy.learnaop.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
    public void logBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - {} is called with arguments: {}",  joinPoint, joinPoint.getArgs());
    }

    @After("com.udemy.learnaop.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed",  joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.udemy.learnaop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}",  joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "com.udemy.learnaop.aspects.CommonPointcutConfig.dataPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}",  joinPoint, resultValue);
    }
}
