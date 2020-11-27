package com.stackroute.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.ms.exceptions.CustomerAlreadyExistsException;
import com.stackroute.ms.exceptions.CustomerNotFoundException;
import com.stackroute.ms.model.Customer;
import com.stackroute.ms.services.ICustomerService;

@Controller
@RequestMapping("api/v1")
public class CustomerController {

	@Autowired
	private ICustomerService custservice;

	private ResponseEntity<?> responseentity;

	@PostMapping("/addcust")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer custData) throws CustomerAlreadyExistsException {
		try {
			Customer custDataCreated = custservice.saveCustomer(custData);
			responseentity = new ResponseEntity<>(custDataCreated, HttpStatus.CREATED);
		} catch (CustomerAlreadyExistsException ipe) {
			responseentity = new ResponseEntity<>("Some Internal Error Occured ..", HttpStatus.INTERNAL_SERVER_ERROR);
			throw new CustomerAlreadyExistsException();
		}

		return responseentity;
	}

	@GetMapping("/getcust")
	public ResponseEntity<?> getAllCustomer() {
		try {
			responseentity = new ResponseEntity<>(this.custservice.getAllCustomers(), HttpStatus.OK);
		} catch (Exception e) {
			responseentity = new ResponseEntity<>("Some Internal Error ....", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return responseentity;
	}

	@PutMapping("/updatecust")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer custData) throws CustomerNotFoundException {
		try {
			Customer custDataupdated = custservice.updateCustomer(custData);

			responseentity = new ResponseEntity<>(custDataupdated, HttpStatus.CREATED);
		} catch (CustomerNotFoundException ipe) {
			responseentity = new ResponseEntity<>("Some Internal Error Occured ..", HttpStatus.INTERNAL_SERVER_ERROR);
			throw new CustomerNotFoundException();
		}

		return responseentity;
	}

	@GetMapping("/getcust/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") String custId) throws CustomerNotFoundException {
		try {

			Customer custData = this.custservice.getCustomerById(custId);
			responseentity = new ResponseEntity<>(custData, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			responseentity = new ResponseEntity<>("Some Internal Error ....", HttpStatus.INTERNAL_SERVER_ERROR);
			throw new CustomerNotFoundException();
		}

		return responseentity;
	}

	@DeleteMapping("/delcust/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") String custId) throws CustomerNotFoundException {
		try {

			boolean deleteStatus = this.custservice.deleteCustomer(custId);
			responseentity = new ResponseEntity<>("Policy Deleted ...", HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			responseentity = new ResponseEntity<>("Some Internal Error ....", HttpStatus.INTERNAL_SERVER_ERROR);
			throw new CustomerNotFoundException();
		}

		return responseentity;
	}

}
