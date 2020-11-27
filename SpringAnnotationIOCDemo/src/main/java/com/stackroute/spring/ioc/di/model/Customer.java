package com.stackroute.spring.ioc.di.model;

import java.util.List;

public class Customer {
	private int custId;
	private String custName;
	private String custAge;
	private String custEmail;

	private List<IPolicy> ipDetails;

	public Customer(int custId, String custName, String custAge, String custEmail, List<IPolicy> ipDetails) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAge = custAge;
		this.custEmail = custEmail;
		this.ipDetails = ipDetails;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAge=" + custAge + ", custEmail="
				+ custEmail + ", ipDetails=" + ipDetails + "]";
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAge() {
		return custAge;
	}

	public void setCustAge(String custAge) {
		this.custAge = custAge;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public List<IPolicy> getIpDetails() {
		return ipDetails;
	}

	public void setIpDetails(List<IPolicy> ipDetails) {
		this.ipDetails = ipDetails;
	}
}
