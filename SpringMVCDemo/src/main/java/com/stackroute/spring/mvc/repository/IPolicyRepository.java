package com.stackroute.spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import com.stackroute.spring.mvc.model.IPolicy;

public class IPolicyRepository {

	public List<IPolicy> ipDetails;

	public IPolicyRepository() {
		this.ipDetails = new ArrayList();
	}

	public List<IPolicy> getPolicy() {
		return ipDetails;
	}

	public void setPolicy(List<IPolicy> ipDetails) {
		this.ipDetails = ipDetails;
	}

	public void addPolicy(IPolicy ipData) {
		this.ipDetails.add(ipData);
	}

	public void deletePolicy(int ipId) {
		this.ipDetails.remove(ipId);
	}
}
