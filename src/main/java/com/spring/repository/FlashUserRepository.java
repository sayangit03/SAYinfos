package com.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.beans.FlashUser;

public interface FlashUserRepository extends MongoRepository<FlashUser, Integer> {

	List<FlashUser> findByUserUniqueName(String userUniqueName);
}
