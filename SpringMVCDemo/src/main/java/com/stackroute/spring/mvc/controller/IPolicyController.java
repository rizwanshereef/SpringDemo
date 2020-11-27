package com.stackroute.spring.mvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stackroute.spring.mvc.model.IPolicy;
import com.stackroute.spring.mvc.repository.IPolicyRepository;

@Controller
public class IPolicyController 
{

	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

	IPolicy ipDetails = ctx.getBean("ipDetails", IPolicy.class);

	IPolicyRepository ipRepository = ctx.getBean("ipRepository", IPolicyRepository.class);

	public IPolicyController()
	{
		
	}
	
	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}

	@PostMapping("/savePolicy")
	public String savePolicyDetails(@ModelAttribute("ipData") IPolicy ipData, ModelMap model) {
		this.ipRepository.addPolicy(ipData);
		model.addAttribute("ipList", this.ipRepository.getPolicy());
		return "index";
	}
}
