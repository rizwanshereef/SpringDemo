package com.stackroute.ms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.ms.exceptions.CustomerAlreadyExistsException;
import com.stackroute.ms.exceptions.CustomerNotFoundException;
import com.stackroute.ms.model.Customer;
import com.stackroute.ms.repositories.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository custRepository;

	@Override
	public Customer saveCustomer(Customer custData) throws CustomerAlreadyExistsException {

		Customer custDataadded;

		Optional<Customer> optional = this.custRepository.findById(custData.getCustId());

		if (optional.isPresent()) {
			throw new CustomerAlreadyExistsException();
		} else {
			custDataadded = this.custRepository.save(custData);
		}

		return custDataadded;

	}

	@Override
	public Customer updateCustomer(Customer custData) throws CustomerNotFoundException {
		Customer custDataupdated;

		Optional<Customer> optional = this.custRepository.findById(custData.getCustId());

		if (optional.isPresent()) {

			custDataupdated = this.custRepository.save(custData);

		} else {
			throw new CustomerNotFoundException();
		}

		return custDataupdated;

	}

	@Override
	public boolean deleteCustomer(String custId) throws CustomerNotFoundException {
		boolean custDatadeletestatus;

		Optional<Customer> optional = this.custRepository.findById(custId);

		if (optional.isPresent()) {
			this.custRepository.delete(optional.get());
			custDatadeletestatus = true;
		} else {
			custDatadeletestatus = false;
			throw new CustomerNotFoundException();
		}

		return custDatadeletestatus;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.custRepository.findAll();
	}

	@Override
	public Customer getCustomerById(String custId) throws CustomerNotFoundException {

		Customer ipDatabyId;

		Optional<Customer> optional = this.custRepository.findById(custId);

		if (optional.isPresent()) {
			ipDatabyId = optional.get();
		} else {
			throw new CustomerNotFoundException();
		}

		return ipDatabyId;

	}
}
