package com.stackroute.ms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.ms.model.IPolicy;

public interface IPolicyRepository extends MongoRepository<IPolicy, String> 
{

}
