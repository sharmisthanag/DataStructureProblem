package com.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/*
 * 
 * precision
 * around->before->around->after->afterReturing
 * around->before->around catch block if exception->after->afterReturing(not after throwing as exception is already catched)
 * before-> after->after throwing->any catch block or else throws exception
 * once returned string is received by around ,that return string is no longer visible in AfterReturning method
 * http://docs.spring.io/spring/docs/3.1.x/spring-framework-reference/html/aop.html#aop-understanding-aop-proxies
 * http://stackoverflow.com/questions/13564627/spring-aop-not-working-for-method-call-inside-another-method
 */

@Aspect
public class LoggingAspect {
	
	/*@Before("loggingAdvice3() && loggingAdvice4()")
	public void loggingAdvice(JoinPoint jointpoint){
		System.out.println("logging for => "+jointpoint.toShortString());
	}
	
	@Pointcut("execution(* get*())")
	public void loggingAdvice1(){
		System.out.println("loggingAdvice1");
	}
	
	@Pointcut("execution(* com.spring.aop.model.Circle.*(..))")
	public void loggingAdvice2(){
	}
	
	@Pointcut("within(com.spring.aop.model.Circle)")
	public void loggingAdvice3(){
		System.out.println("sysout inside pointcut doesnot get printed");
	}
	
	@Pointcut("args(*)")
	public void loggingAdvice4(){
	}
	
	@Before("args(name1)")
	public void loggingAdvice5(String name1){
		System.out.println("logging5 for => "+name1);
	}
	

	@AfterReturning(pointcut="args(i)",returning="returnString")
	public void loggingAdvice6(JoinPoint jp,int i,String returnString){
		System.out.println("in loggingAdvice6 call "+jp.toShortString()+"input=>"+i+" return"+returnString);
	}
	*/
	/*
	@AfterThrowing(pointcut="args(..)",throwing="ex")
	public void afterThrowing(JoinPoint jp,RuntimeException ex){
		System.err.println("in afterThrowing call "+jp.toShortString()+" throwing"+ex.getClass());
	}
	
	@AfterReturning(pointcut="args(..)",returning="returnString")
	public void afterReturning(JoinPoint jp,String returnString){
		System.out.println("in afterReturning call "+jp.toShortString()+" return"+returnString);
	}
	
	@After("args(..)")
	public void after(JoinPoint jp){
		System.out.println("in after call "+jp.toShortString());
	}
	@Before("args(..)")
	public void before(JoinPoint jp){
		System.out.println("\nbefore for => "+jp.toShortString());
	}
	
	@Around("args(..)")
	public void around(ProceedingJoinPoint pjp){
		System.out.println("in around before methodcall "+pjp.toShortString());
		try {
			String o=(String) pjp.proceed();
			System.out.println(o);
		} catch (Throwable e) {
			System.err.println("in catch of around after methodcall "+pjp.toShortString());
		}
		System.out.println("method finishes of around "+pjp.toShortString());

	}
	*/
	@Around("@annotation(com.spring.aop.aspects.CustomLogging)")
	public void aroundForCustomLogging(ProceedingJoinPoint pjp){
		System.out.println("@aroundForCustomLogging:in around before methodcall "+pjp.toShortString());
		try {
			String o=(String) pjp.proceed();
			System.out.println(o);
		} catch (Throwable e) {
			System.err.println("@aroundForCustomLogging:in catch of around after methodcall "+pjp.toShortString());
		}
		System.out.println("@aroundForCustomLogging:in method finishes of around "+pjp.toShortString());

	}
	
	

}
