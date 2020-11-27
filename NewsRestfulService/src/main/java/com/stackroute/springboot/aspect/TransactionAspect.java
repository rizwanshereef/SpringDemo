//package com.stackroute.springboot.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.TransactionManager;
//
//import com.stackroute.springboot.model.News;
//
//public class TransactionAspect 
//{
//
//	private TransactionManager tx;
//	
//	@Before(value = "execution(* com.stackroute.springboot.controller.NewsController.*(..)) and args(news)")
//	public void beforeAdviceMethod(JoinPoint joinpoint, News news)
//	{
//		
//	}
//
//}
