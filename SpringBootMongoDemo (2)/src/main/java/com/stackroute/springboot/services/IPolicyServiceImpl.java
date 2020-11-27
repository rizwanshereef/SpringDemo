package com.stackroute.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springboot.exceptions.IPolicyAlreadyExistsException;
import com.stackroute.springboot.exceptions.IPolicyNotFoundException;
import com.stackroute.springboot.model.IPolicy;
import com.stackroute.springboot.repositories.IPolicyRepository;

@Service
public class IPolicyServiceImpl implements IPolicyService {

	@Autowired
	private IPolicyRepository ipRepository;

	@Override
	public IPolicy savePolicy(IPolicy ipData) throws IPolicyAlreadyExistsException {

		IPolicy ipDataadded;

		Optional<IPolicy> optional = this.ipRepository.findById(ipData.getIpId());

		if (optional.isPresent()) {
			throw new IPolicyAlreadyExistsException();
		} else {
			ipDataadded = this.ipRepository.save(ipData);
		}

		return ipDataadded;
	}

	@Override
	public IPolicy updatePolicy(IPolicy ipData) throws IPolicyNotFoundException {

		IPolicy ipDataupdated;

		Optional<IPolicy> optional = this.ipRepository.findById(ipData.getIpId());

		if (optional.isPresent()) {
			ipDataupdated = this.ipRepository.save(ipData);
		} else {
			throw new IPolicyNotFoundException();
		}

		return ipDataupdated;
	}

	@Override
	public boolean deletePolicy(int ipId) throws IPolicyNotFoundException {

		boolean ipDatadeletestatus;

		Optional<IPolicy> optional = this.ipRepository.findById(ipId);

		if (optional.isPresent()) {
			this.ipRepository.delete(optional.get());
			ipDatadeletestatus = true;
		} else {
			ipDatadeletestatus = false;
			throw new IPolicyNotFoundException();
		}

		return ipDatadeletestatus;
	}

	@Override
	public List<IPolicy> getAllPolicies() {
		return this.ipRepository.findAll();
	}

	@Override
	public IPolicy getPolicyById(int ipId) throws IPolicyNotFoundException {
		IPolicy ipDatabyId;

		Optional<IPolicy> optional = this.ipRepository.findById(ipId);

		if (optional.isPresent()) {
			ipDatabyId = optional.get();
		} else {
			throw new IPolicyNotFoundException();
		}

		return ipDatabyId;

	}

}
