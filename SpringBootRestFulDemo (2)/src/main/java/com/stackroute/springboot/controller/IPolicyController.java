package com.stackroute.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.springboot.exception.IPolicyAlreadyExistsException;
import com.stackroute.springboot.model.IPolicy;
import com.stackroute.springboot.services.IPolicyService;

@Controller
@RequestMapping("/api/v1")
public class IPolicyController 
{
	
//	http://localhost:8080/api/v1/addpolicy  -- POST  --- Body (JSON)
//	http://localhost:8080/api/v1/getpolicy  -- GET  --- return (JSON) data
//	http://localhost:8080/api/v1/updatepolicy  -- PUT  --- Body (JSON) return JSON data	
//	http://localhost:8080/api/v1/delpolicy  -- DELETE  --- return boolean
	
	
	@Autowired
	private IPolicyService ipservice;
	
	
	private ResponseEntity<?> responseentity;
	
	@PostMapping("/addpolicy")
	public ResponseEntity<?> savePolicy(@RequestBody IPolicy ipData) throws IPolicyAlreadyExistsException
	{
		try
		{
			IPolicy ipDataCreated = ipservice.savePolicy(ipData);
			responseentity = new ResponseEntity<>(ipDataCreated,HttpStatus.CREATED);
		}
		catch(IPolicyAlreadyExistsException ipe)
		{
			throw new IPolicyAlreadyExistsException();
		}
		
		return responseentity;
	}
	
	@GetMapping("/getpolicy")
	public ResponseEntity<?> getAllPolicy()
	{
		try
		{
			responseentity = new ResponseEntity<>(this.ipservice.getAllPolicies(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			responseentity = new ResponseEntity<>("Some Internal Error ....",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseentity;

	}
}
