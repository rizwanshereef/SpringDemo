package com.stackroute.ms.controller;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController 
{
	
	@GetMapping("/policy")
	public ResponseEntity<?> getPolicyDetails() throws IOException, RestClientException
	{
		System.out.println("Inside Get Policy Details Method ....");
		
		String policyUrl = "http://localhost:8081/api/v1/getpolicy";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = null;
		
		try
		{
			response = restTemplate.exchange(policyUrl, HttpMethod.GET, getHeaders(), String.class);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println(response);
		return response;
	}

	@GetMapping("/cust")
	public ResponseEntity<?> getCustomerDetails() throws IOException, RestClientException
	{
		System.out.println("Inside Get Customer Details Method ....");
		
		String custUrl = "http://localhost:8082/api/v1/getcust";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = null;
		
		try
		{
			response = restTemplate.exchange(custUrl, HttpMethod.GET, getHeaders(), String.class);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println(response);
		return response;
	}
	
	
	private static HttpEntity<?> getHeaders() throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		return new HttpEntity(headers);
	}
}
