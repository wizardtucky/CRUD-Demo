package com.example.demo.aop.delete.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class PreformanceMonitoringAspect {

    @Around("@annotation(com.example.demo.aop.delete.annotation.MonitorPreformance)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + " ms");

        return proceed;
    }

    @Before("@annotation(com.example.demo.aop.delete.annotation.MonitorPreformance)")
    public void before(){
        System.out.println("Executed Before aspect");
    }

    @After("execution(* com.example.demo.aop.delete.service.BussnessLogic.processSmth())")
    public void after(){
        System.out.println("Executed After aspect");
    }
}
