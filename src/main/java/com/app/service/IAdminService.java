package com.app.service;

import java.util.List;

import com.app.dto.AdminPlanCustomerSummary;
import com.app.dto.Employeedto;
import com.app.dto.LoginRequestDTO;
import com.app.dto.summarydto;
import com.app.entity.ClubEntity;
import com.app.entity.CustomerEntity;
import com.app.entity.EmployeeEntity;

public interface IAdminService {
	//authentication method 
	EmployeeEntity authenticateAdmin(LoginRequestDTO admin);
	//add employee method
	EmployeeEntity addEmployee(Employeedto transEmployee);
	//get all employees 
	List<EmployeeEntity> getAllemployees();
	//update Employee
	EmployeeEntity updateEmployee(EmployeeEntity emp);
	//delete Employee
	String deleteEmpdetails(Long emp_id);
	//get frachise details
	List<ClubEntity> getAllclub();
	//getEmployeebyid
	EmployeeEntity getbyid(Long id);
	//clubsummary
	List<summarydto> getAdminsummary();
	//getAllcustomer
	List<CustomerEntity> AllCustomer();
	//planSummary
	List<AdminPlanCustomerSummary> PlanSummary();
	//clubadd
	ClubEntity addClub(ClubEntity club);
	//clubbyid
	ClubEntity clubByid(Long id);
	//Delclubbyid
	String deleteClubbyid(Long id);
}
