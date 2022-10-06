package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.CustomerEntity;
import com.app.entity.PlanEntity;

public interface AdminPlanRepository extends JpaRepository<PlanEntity, Long> {
	
@Override
 List<PlanEntity> findAll();	
}
