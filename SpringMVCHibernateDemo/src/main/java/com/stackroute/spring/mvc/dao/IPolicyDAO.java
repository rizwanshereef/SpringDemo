package com.stackroute.spring.mvc.dao;

import java.util.List;

import com.stackroute.spring.mvc.model.IPolicy;

public interface IPolicyDAO {

	public boolean savePolicy(IPolicy ipData);

//	public boolean updatePolicy(IPolicy ipData);

	public boolean deletePolicy(int ipId);

	public List<IPolicy> getPolicy();

//	public IPolicy getPolicyById(int ipId);

}
