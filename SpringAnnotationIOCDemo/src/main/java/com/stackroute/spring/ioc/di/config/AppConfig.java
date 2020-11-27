package com.stackroute.spring.ioc.di.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.stackroute.spring.ioc.di.model.Customer;
import com.stackroute.spring.ioc.di.model.IPolicy;

public class AppConfig 
{
	
	@Bean("Tim")
	public Customer getCustomer1()
	{
		return new Customer(101,"Tim","23","tim@gmail.com",new ArrayList(Arrays.asList(getIPolicy1(),getIPolicy2())));
	}
	
	@Bean("Rim")
	public Customer getCustomer2()
	{
		return new Customer(102,"Rim","24","rim@gmail.com",new ArrayList(Arrays.asList(getIPolicy1())));
	}
	
	@Bean("Jim")
	public Customer getCustomer3()
	{
		return new Customer(103,"Jim","25","jim@gmail.com",new ArrayList(Arrays.asList(getIPolicy1(),getIPolicy2())));
	}
	
	@Bean
	public IPolicy getIPolicy1()
	{
		return new IPolicy(1,"Health","For Life Term",2000);
	}
	
	@Bean
	public IPolicy getIPolicy2()
	{
		return new IPolicy(2,"Child Health","Up To 14 Years",1000);
	}
	
//	@Bean
//	@Scope("prototype")
//	public IPolicy getIPolicy()
//	{
//		return new IPolicy();
//	}
}