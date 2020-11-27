package com.stackroute.springboot.services;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.springboot.exception.IPolicyAlreadyExistsException;
import com.stackroute.springboot.model.IPolicy;
import com.stackroute.springboot.repository.IPolicyRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class IPolicyServiceTest 
{
	@Autowired
	private IPolicyRepository policyRepository;

	@InjectMocks
	private IPolicyServiceImpl policyService;

	private IPolicy policyObj;

	
	@Before
	public void setup() {
		policyObj = new IPolicy();

		policyObj.setIpId(1);
		policyObj.setIpTitle("Health");
		policyObj.setIpDesc("Life Term Plan");
		policyObj.setIpPremium(2000);
	}

	@After
	public void tearDown() {
		policyObj = null;
	}


	@SuppressWarnings("deprecation")
	@Test
	public void testSaveNoteSuccess() throws IPolicyAlreadyExistsException
	{
		Mockito.when(policyRepository.save(policyObj)).thenReturn(policyObj);
		
		IPolicy createdPolicy = policyService.savePolicy(policyObj);
		
		Assert.assertEquals(policyObj.getIpTitle(), createdPolicy.getIpTitle());
	}
}
