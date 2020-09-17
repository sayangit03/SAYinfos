package com.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.beans.AllServices;

public interface AllServiceRepository extends MongoRepository<AllServices, Integer> {
	List<AllServices> findByServiceURI(String serviceURI);
}
