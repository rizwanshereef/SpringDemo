package com.stackroute.spring.ioc.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.spring.ioc.di.config.AppConfig;
import com.stackroute.spring.ioc.di.model.Customer;
import com.stackroute.spring.ioc.di.model.IPolicy;

public class Main {

	public static void main(String[] args) 
	{
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class); 
		
		Customer cObj1 = ctx.getBean("Tim",Customer.class);
		Customer cObj2 = ctx.getBean("Rim",Customer.class);
		Customer cObj3 = ctx.getBean("Jim",Customer.class);
		
//		IPolicy ipObj = ctx.getBean(IPolicy.class);
//		ipObj.setIpId(1);
//		ipObj.setIpTitle("Health");
//		ipObj.setIpDesc("Linfe Term");
//		ipObj.setIpPremium(2000);
		
//		Builder pattern
//		IPolicy ipObj1 = ctx.getBean(IPolicy.class);
//		ipObj1.setIpId(1).setIpTitle("Health").setIpDesc("Linfe Term").setIpPremium(2000);
//		
//		IPolicy ipObj2 = ctx.getBean(IPolicy.class);
//		ipObj2.setIpId(2).setIpTitle("Child Health").setIpDesc("Up to 15 Years").setIpPremium(1000);

		
		System.out.println(cObj1);
		System.out.println(cObj2);
		System.out.println(cObj3);
		
//		System.out.println(ipObj1);
//		System.out.println(ipObj2);
		
	}
}
