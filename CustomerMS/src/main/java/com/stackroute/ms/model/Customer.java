package com.stackroute.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
	@Id
	private String custId;
	private String custName;
	private String custCity;
	private String custCountry;
	private int custAge;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustCountry() {
		return custCountry;
	}

	public void setCustCountry(String custCountry) {
		this.custCountry = custCountry;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custCity=" + custCity + ", custCountry="
				+ custCountry + ", custAge=" + custAge + "]";
	}

}
