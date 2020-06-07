package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.beans.AllServices;

public interface AllServiceRepository extends JpaRepository<AllServices, Integer> {
	List<AllServices> findByServiceURI(String serviceURI);
}
