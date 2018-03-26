package com.orkut.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	final static Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.orkut1..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Entered into : " + joinPoint.getSignature().getDeclaringTypeName() + " :: " + joinPoint.getSignature().getName());
	}
	
	/*@After("execution(* com.orkut..*(..))")
	public void logAfter(JoinPoint joinPoint){
	
		logger.info("Exit from : " + joinPoint.getSignature().getDeclaringTypeName() + " :: " + joinPoint.getSignature().getName());
	}*/
	
}
