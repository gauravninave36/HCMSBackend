package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.ClubEntity;

public interface CustomerClubRepository extends JpaRepository<ClubEntity, Long> {
	
	Optional<ClubEntity> findById(Long id);
}
