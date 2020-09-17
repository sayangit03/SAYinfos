package com.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.beans.FlashUser;

public interface FlashUserRepository extends MongoRepository<FlashUser, Integer> {

}
