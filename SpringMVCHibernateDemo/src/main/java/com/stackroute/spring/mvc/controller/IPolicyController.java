package com.stackroute.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.spring.mvc.dao.IPolicyDAO;
import com.stackroute.spring.mvc.model.IPolicy;

@Controller
@RequestMapping("/")
public class IPolicyController {

	@Autowired
	private com.stackroute.spring.mvc.dao.IPolicyDAO ipDAO;

//	public IPolicyController(com.stackroute.spring.mvc.dao.IPolicyDAOImpl ipDAO)
//	{
//		this.ipDAO = ipDAO;
//	}
	
	@GetMapping("/")
	public ModelAndView getHomePage() {
		ModelAndView modelAndview = new ModelAndView("index");

		modelAndview.addObject("ipList", ipDAO.getPolicy());

		return modelAndview;
	}

	@PostMapping("/savePolicy")
	public String savePolicyDetails(@ModelAttribute("ipData") IPolicy ipData, ModelMap model) {
		
		boolean status = ipDAO.savePolicy(ipData);
		
		model.addAttribute("ipList", this.ipDAO.getPolicy());
		return "index";
	}
}

// web.xml
// beans.xml dispatcher servlet
// Hibernate Configuration