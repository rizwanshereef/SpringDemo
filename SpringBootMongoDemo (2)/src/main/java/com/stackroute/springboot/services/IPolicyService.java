package com.stackroute.springboot.services;

import java.util.List;

import com.stackroute.springboot.exceptions.IPolicyAlreadyExistsException;
import com.stackroute.springboot.exceptions.IPolicyNotFoundException;
import com.stackroute.springboot.model.IPolicy;

public interface IPolicyService 
{
	public IPolicy savePolicy(IPolicy ipData) throws IPolicyAlreadyExistsException;

	public IPolicy updatePolicy(IPolicy ipData) throws IPolicyNotFoundException;

	public boolean deletePolicy(int ipId) throws IPolicyNotFoundException;

	public List<IPolicy> getAllPolicies();

	public IPolicy getPolicyById(int ipId) throws IPolicyNotFoundException;

}
