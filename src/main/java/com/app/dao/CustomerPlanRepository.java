package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.PlanEntity;

public interface CustomerPlanRepository extends JpaRepository<PlanEntity, Long> {
	
	Optional<PlanEntity> findById(Long id);
}
