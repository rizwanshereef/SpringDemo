package com.stackroute.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springboot.exception.IPolicyAlreadyExistsException;
import com.stackroute.springboot.exception.IPolicyNotFoundException;
import com.stackroute.springboot.model.IPolicy;
import com.stackroute.springboot.repository.IPolicyRepository;


@Service
public class IPolicyServiceImpl implements IPolicyService 
{
	
	@Autowired
	private IPolicyRepository ipRepository;
	

	@Override
	public IPolicy savePolicy(IPolicy ipData) throws IPolicyAlreadyExistsException 
	{
		Optional<IPolicy> optional = this.ipRepository.findById(ipData.getIpId());
		
		if(optional.isPresent())
		{
			throw new IPolicyAlreadyExistsException();
		}
		
		IPolicy ipDataadded = this.ipRepository.save(ipData);
		
		return ipDataadded;
	}

	@Override
	public IPolicy updatePolicy(IPolicy ipData) throws IPolicyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePolicy(int ipId) throws IPolicyNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IPolicy> getAllPolicies() 
	{
		return this.ipRepository.findAll();
	}

	@Override
	public IPolicy getPolicyById(int ipId) throws IPolicyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
