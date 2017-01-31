package com.salahatwa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class ReadLogic {
	
	@Before("execution(* com.mkyong.customer.bo.CustomerBo.addCustomer(..))")
	public void beforeReadFile(JoinPoint joinPoint)
	{
		
	}
	

}
