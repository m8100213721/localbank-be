package com.example.payment_gateway_app.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.payment_gateway_app.controller.*.*(..)) || execution(* com.example.payment_gateway_app.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("Entering method: {} with arguments: {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    @After("execution(* com.example.payment_gateway_app.controller.*.*(..)) || execution(* com.example.payment_gateway_app.service.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        logger.info("Exiting method: {}", joinPoint.getSignature().toShortString());
    }
}
