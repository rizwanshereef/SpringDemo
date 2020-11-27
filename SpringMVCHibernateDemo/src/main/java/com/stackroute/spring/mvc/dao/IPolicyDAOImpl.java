package com.stackroute.spring.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.spring.mvc.model.IPolicy;

@Repository
@Transactional
public class IPolicyDAOImpl implements IPolicyDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public boolean savePolicy(IPolicy ipData) {
		try {
			this.sessionfactory.getCurrentSession().save(ipData);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deletePolicy(int ipId) {
		try {
			
			IPolicy ipData = this.sessionfactory.getCurrentSession().load(IPolicy.class, ipId);
						
			this.sessionfactory.getCurrentSession().delete(ipData);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<IPolicy> getPolicy() {
		return this.sessionfactory.getCurrentSession().createQuery("from IPolicy").list();
	}

	
//    HQL						SQL
//	from IPolicy == Select * from IPOlicy
//	
	
}
