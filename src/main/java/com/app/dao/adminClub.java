package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.ClubEntity;

public interface adminClub extends JpaRepository<ClubEntity,Long> {
	
	//Get club by id 
	 Optional<ClubEntity> findById(Long id);
	 
	 //GetAllclub
	 List<ClubEntity> findAll();
	 
	 @Query("select sum(c.planId.planPrice) from CustomerEntity c join c.planId pt join c.clubId group by c.clubId.id order by c.clubId.id")
	  List<Long> findList();
	 
	 //DeleteByid
	 @Override
	 void deleteById(Long id) ;
}
