package com.stackroute.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.springboot.model.News;

@Repository
public interface INewsRepository extends MongoRepository<News, String> 
{
	
	
}
