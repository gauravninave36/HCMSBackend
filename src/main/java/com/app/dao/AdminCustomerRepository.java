package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.CustomerEntity;

public interface AdminCustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	@Query("select c.clubId.id from CustomerEntity c join c.planId pt join c.clubId group by c.clubId.id order by c.clubId.id")
	  List<Long> findList();
	
	
}
