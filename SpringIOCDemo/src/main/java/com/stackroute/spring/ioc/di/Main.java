package com.stackroute.spring.ioc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main 
{

	
	
	public static void main(String[] aa)
	{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		newsLocation newsLocation1 = ctx.getBean("nlObj1",newsLocation.class);
		newsLocation newsLocation2 = ctx.getBean("nlObj2",newsLocation.class);
		newsLocation newsLocation3 = ctx.getBean("nlObj3",newsLocation.class);
		newsLocation newsLocation4 = ctx.getBean("nlObj4",newsLocation.class);
		
		
		News nObj1 = ctx.getBean("nObj1",News.class);
		News nObj2 = ctx.getBean("nObj2",News.class);

		System.out.println(nObj2);
		System.out.println(nObj1);
		System.out.println(newsLocation1);
		System.out.println(newsLocation2);
		System.out.println(newsLocation3);
		System.out.println(newsLocation4);
		
	}
}
