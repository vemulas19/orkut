package com.orkut.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.orkut.pojo.Student;

@Aspect
public class ValidationAspect {

	@Before("execution(* com.orkut..*(..)) and args(name,..)")
	public void validateRequest(JoinPoint joinPoint, String name){
		if (name == null) {
			System.out.println("name is null this is sop");
			throw new ArithmeticException("name is null");
		}
		System.out.println("Name is : " + name);
		System.out.println("validation logic starts");
	}
}
