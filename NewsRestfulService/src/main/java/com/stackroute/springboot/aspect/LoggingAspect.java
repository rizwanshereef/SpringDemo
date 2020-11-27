package com.stackroute.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.stackroute.springboot.exception.NewsAlreadyExistsException;
import com.stackroute.springboot.model.News;

@Aspect
@Component
public class LoggingAspect 
{
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	
	
	@Before(value = "execution(* com.stackroute.springboot.controller.NewsController.*(..)) and args(news)")
	public void beforeAdviceMethod(JoinPoint joinpoint, News news)
	{
		System.out.println("From Before Advice ....");
		logger.info("Inside Before Advice ......");
		logger.info("Target Object MethodName  ::"+joinpoint.getSignature().getName());
		logger.info("Creating News object with following details ::"+news);
	}
	
	@After(value = "execution(* com.stackroute.springboot.controller.NewsController.*(..)) and args(news)")
	public void afterAdviceMethod(JoinPoint joinpoint, News news)
	{
		System.out.println("From After Advice ....");
		logger.info("Inside After Advice ......");
		logger.info("Target Object MethodName  ::"+joinpoint.getSignature().getName());
		logger.info("Creating News object with following details ::"+news);
	}
	
	@AfterReturning(value = "execution(* com.stackroute.springboot.controller.NewsController.*(..)) and args(news)")
	public void afterReturningAdviceMethod(JoinPoint joinpoint, News news)
	{
		System.out.println("From After return Advice ....");
		logger.info("Inside After Returning Advice ......");
		logger.info("Target Object MethodName  ::"+joinpoint.getSignature().getName());
		logger.info("Creating News object with following details ::"+news);
	}
	
	
	@AfterThrowing(pointcut="within(com.stackroute.springboot.controller.NewsController..*)",throwing="newsexception")
	public void afterThrowingAdviceMethod(JoinPoint joinpoint, NewsAlreadyExistsException newsexception)
	{
		logger.info("Inside After Throwing Advice ......");
		logger.info("Target Object MethodName  ::"+joinpoint.getSignature().getName());
		logger.info("Creating News object with following details ::"+newsexception);
	}
	
	
	@Around("execution(* com.stackroute.springboot.controller.NewsController.*(..)) and args(news)")
	public void aroundAdviceMethod(ProceedingJoinPoint pjoinpoint, News news) throws Throwable
	{
		logger.info("Inside Around Advice ......");
		logger.info("Target Object MethodName  ::"+pjoinpoint.getSignature().getName());
		logger.info("Creating News object with following details ::"+news);
		
		try
		{
			pjoinpoint.proceed();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			logger.info("Some recovery action taken ....");
		}
	}
}