package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.EmployeeEntity;

public interface AdminRepository extends JpaRepository<EmployeeEntity, Long> {
	//sign in by admin
	Optional<EmployeeEntity> findByEmailAndPassword(String em,String pass);
	//getallEmployees
	List<EmployeeEntity> findAll();
	//delete by id
	void deleteById(Long id);
	//see if id exsists
	boolean existsById(Long id) ;
	//getbyid
	Optional<EmployeeEntity> findById(Long id);
	
	@Query("select c.clubId.location from CustomerEntity c join c.planId pt join c.clubId group by c.clubId.id order by c.clubId.id")
	  List<String> findList();
	
}
