package com.stackroute.ms.services;

import java.util.List;

import com.stackroute.ms.exceptions.IPolicyAlreadyExistsException;
import com.stackroute.ms.exceptions.IPolicyNotFoundException;
import com.stackroute.ms.model.IPolicy;

public interface IPolicyService 
{
	public IPolicy savePolicy(IPolicy ipData) throws IPolicyAlreadyExistsException;

	public IPolicy updatePolicy(IPolicy ipData) throws IPolicyNotFoundException;

	public boolean deletePolicy(String ipId) throws IPolicyNotFoundException;

	public List<IPolicy> getAllPolicies();

	public IPolicy getPolicyById(String ipId) throws IPolicyNotFoundException;

}
