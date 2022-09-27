package com.app.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.ClubEntity;
import com.app.entity.CustomerEntity;
import com.app.entity.PlanEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	Optional<CustomerEntity> findByEmailAndPassword(String email,String password);
	
	@Query("update CustomerEntity c set c.clubId=?1, c.planId=?2 where c.id=?3")
	CustomerEntity updateBasedOnExpiry(ClubEntity clubRef, PlanEntity planRef, Long id);
	
}
