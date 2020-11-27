package com.stackroute.ms.services;

import java.util.List;

import com.stackroute.ms.exceptions.CustomerAlreadyExistsException;
import com.stackroute.ms.exceptions.CustomerNotFoundException;
import com.stackroute.ms.model.Customer;

public interface ICustomerService 
{
	
	public Customer saveCustomer(Customer custData) throws CustomerAlreadyExistsException;

	public Customer updateCustomer(Customer custData) throws CustomerNotFoundException;

	public boolean deleteCustomer(String custId) throws CustomerNotFoundException;

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(String custId) throws CustomerNotFoundException;
	
}
