package com.stackroute.springboot.controller;

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

import com.stackroute.springboot.exceptions.IPolicyAlreadyExistsException;
import com.stackroute.springboot.exceptions.IPolicyNotFoundException;
import com.stackroute.springboot.model.IPolicy;
import com.stackroute.springboot.services.IPolicyService;

@Controller
@RequestMapping("api/v1")
public class IPolicyController {

	@Autowired
	private IPolicyService ipservice;

	private ResponseEntity<?> responseentity;

	@PostMapping("/addpolicy")
	public ResponseEntity<?> savePolicyC(@RequestBody IPolicy ipData) throws IPolicyAlreadyExistsException {
		try {
			IPolicy ipDataCreated = ipservice.savePolicy(ipData);
			responseentity = new ResponseEntity<>(ipDataCreated, HttpStatus.CREATED);
		} catch (IPolicyAlreadyExistsException ipe) {
			responseentity = new ResponseEntity<>("Some Internal Error Occured ..", HttpStatus.INTERNAL_SERVER_ERROR);
			throw new IPolicyAlreadyExistsException();
		}

		return responseentity;
	}

	@GetMapping("/getpolicy")
	public ResponseEntity<?> getAllPolicy() {
		try {
			responseentity = new ResponseEntity<>(this.ipservice.getAllPolicies(), HttpStatus.OK);
		} catch (Exception e) {
			responseentity = new ResponseEntity<>("Some Internal Error ....", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseentity;
	}

	@PutMapping("/updatepolicy")
	public ResponseEntity<?> updatePolicy(@RequestBody IPolicy ipData) throws IPolicyNotFoundException {
		try {
			IPolicy ipDataupdated = ipservice.updatePolicy(ipData);

			responseentity = new ResponseEntity<>(ipDataupdated, HttpStatus.CREATED);
		} catch (IPolicyNotFoundException ipe) {
			responseentity = new ResponseEntity<>("Some Internal Error Occured ..", HttpStatus.INTERNAL_SERVER_ERROR);
			throw new IPolicyNotFoundException();
		}

		return responseentity;
	}

	@GetMapping("/getpolicy/{id}")
	public ResponseEntity<?> getPolicyById(@PathVariable("id") Integer ipId) throws IPolicyNotFoundException {
		try {

			IPolicy ipData = this.ipservice.getPolicyById(ipId);
			responseentity = new ResponseEntity<>(ipData, HttpStatus.OK);
		} catch (IPolicyNotFoundException e) {
			responseentity = new ResponseEntity<>("Some Internal Error ....", HttpStatus.INTERNAL_SERVER_ERROR);
			throw new IPolicyNotFoundException();
		}

		return responseentity;
	}

	@DeleteMapping("/getpolicy/{id}")
	public ResponseEntity<?> deletePolicyById(@PathVariable("id") Integer ipId) throws IPolicyNotFoundException {
		try {

			boolean deleteStatus = this.ipservice.deletePolicy(ipId);
			responseentity = new ResponseEntity<>("Policy Deleted ...", HttpStatus.OK);
		} catch (IPolicyNotFoundException e) {
			responseentity = new ResponseEntity<>("Some Internal Error ....", HttpStatus.INTERNAL_SERVER_ERROR);
			throw new IPolicyNotFoundException();
		}

		return responseentity;
	}

}
