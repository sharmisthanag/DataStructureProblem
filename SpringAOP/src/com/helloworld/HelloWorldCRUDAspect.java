package com.helloworld;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class HelloWorldCRUDAspect {
     
    @Before("execution(* HelloWorldCRUD.getHelloWorldByCount(..))")
    public void logBeforeV1(JoinPoint joinPoint) 
    {
        System.out.println("HelloWorldCRUD.logBeforeV1() : " + joinPoint.getSignature().getName());
    }
     
    @Before("execution(* HelloWorldCRUD.*(..))")
    public void logBeforeV2(JoinPoint joinPoint) 
    {
        System.out.println("HelloWorldCRUD.logBeforeV2() : " + joinPoint.getSignature().getName());
        System.out.println("HelloWorldCRUD.logBeforeV2() : " + joinPoint.getStaticPart());
    }
     
    @After("execution(* HelloWorldCRUD.getHelloWorldByCount(..))")
    public void logAfterV1(JoinPoint joinPoint) 
    {
        System.out.println("HelloWorldCRUD.logAfterV1() : " + joinPoint.getSignature().getName());
    }
     
    @After("execution(* HelloWorldCRUD.*(..))")
    public void logAfterV2(JoinPoint joinPoint) 
    {
        System.out.println("HelloWorldCRUD.logAfterV2() : " + joinPoint.getSignature().getName());
    }
}