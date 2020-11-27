package com.stackroute.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.stackroute.springboot.exceptions.IPolicyAlreadyExistsException;
import com.stackroute.springboot.model.IPolicy;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before(value = "execution(* com.stackroute.springboot.controller.IPolicyController.*(..)) && args(ipData)")
	public void beforeAdvice(JoinPoint joinpoint, IPolicy ipData) {
		System.out.println("Before Method  :: " + joinpoint.getSignature());
		System.out.println("Creating the Policy with following Details ::" + ipData.toString());
		logger.info("Logger -- before method :: " + joinpoint.getSignature());
	}

	@After(value = "execution(* com.stackroute.springboot.controller.IPolicyController.*(..)) && args(ipData)")
	public void afterAdvice(JoinPoint joinpoint, IPolicy ipData) {
		System.out.println("After Method  :: " + joinpoint.getSignature());
		System.out.println("Creating the Policy with following Details ::" + ipData.toString());
		logger.info("Logger -- after method :: " + joinpoint.getSignature());
	}

	@AfterReturning(pointcut = "within(com.stackroute.springboot.controller.IPolicyController..*)", returning = "result")
	public void afterReturningAdvice(JoinPoint joinpoint, Object result) {
		System.out.println("After Method  :: " + joinpoint.getSignature());
		System.out.println("Creating the Policy with following Details ::" + result.toString());
		logger.info("Logger -- after method :: " + joinpoint.getSignature());
	}

	@AfterThrowing(pointcut = "within(com.stackroute.springboot.controller.IPolicyController..*)", throwing = "exception")
	public void afterThrowingAdvice(JoinPoint joinpoint, IPolicyAlreadyExistsException exception) {
		System.out.println("After Method  :: " + joinpoint.getSignature());
		System.out.println("Creating the Policy with following Details ::" + exception.toString());
		logger.info("Logger -- after method :: " + joinpoint.getSignature());
	}
}
