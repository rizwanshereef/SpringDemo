package com.stackroute.ms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.ms.model.Customer;

@Repository
public interface ICustomerRepository extends MongoRepository<Customer, String> {

}
