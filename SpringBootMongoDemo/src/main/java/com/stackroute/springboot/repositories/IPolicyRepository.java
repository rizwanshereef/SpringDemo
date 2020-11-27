package com.stackroute.springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.springboot.model.IPolicy;

@Repository
public interface IPolicyRepository extends MongoRepository<IPolicy, Integer> 
{
	
	

}
