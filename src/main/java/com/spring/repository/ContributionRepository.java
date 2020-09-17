package com.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.spring.beans.Contribution;

@Component
public interface ContributionRepository extends MongoRepository<Contribution, Integer> {

	List<Contribution> findByUserUniqueName(String uniqueName);

	List<Contribution> findByEmailId(String emailId);

	List<Contribution> findByContriDomain(String contriDomain);

	List<Contribution> findByContriTopic(String contriTopic);

}
