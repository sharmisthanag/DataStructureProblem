package com.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect1 {
	
	@Around("args(..)")
	public Object checkWhenThisMethodGetsCalled(ProceedingJoinPoint pjp){
		System.out.println("checkWhenThisMethodGetsCalled gets called= "+pjp.toShortString());
		Object o=null;
		try {
			o=pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("checkWhenThisMethodGetsCalled gets finishes="+pjp.toShortString());
		return o;
	}

}
