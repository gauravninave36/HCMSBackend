package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.Employeedto;
import com.app.dto.LoginRequestDTO;
import com.app.entity.ClubEntity;
import com.app.entity.EmployeeEntity;
import com.app.service.AdminServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "https://health-club-management.herokuapp.com")
@Slf4j
public class AdminController {
	@Autowired
	private AdminServiceImpl adminImpl;
	
	
	
	public AdminController() {
		log.info("inside the Admin Controller");
	}
	
	@PostConstruct
	public void init() {
		log.info("in init {}",getClass());
	}
	
	//signin
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateAdmin(@RequestBody LoginRequestDTO admin) {
		System.out.println("in auth Admin"+admin);
		return ResponseEntity.ok().body(adminImpl.authenticateAdmin(admin));
	}
	
	//getbyid
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> employeeByid(@PathVariable Long id) {
		System.out.println("in update details"+id);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.getbyid(id));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));

		}
	}
	
	
	//addemployee
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employeedto emp) {
		System.out.println(emp);
		
		try{
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.addEmployee(emp));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	//updateemployee
	@PutMapping("/updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeEntity emp){
		System.out.println(emp);
		try{
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.updateEmployee(emp));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	//Get all employee
	@GetMapping("/getAllEmployee")
	public  ResponseEntity<?> getAllEmployee(){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.getAllemployees());
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));

		}
	}
	
	//addemployeefake
	@PostMapping("/addEmployeefake")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeEntity emp) {
		System.out.println(emp);
		
		try{
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.updateEmployee(emp));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	//deleteemployee
	@DeleteMapping("/employee/{emp_id}")
	public ResponseEntity<?> delEmployee(@PathVariable long emp_id) {
		System.out.println("in del details"+emp_id);
		try {
			return ResponseEntity.status(HttpStatus.FOUND).body(adminImpl.deleteEmpdetails(emp_id));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));

		}
	}
	
	@GetMapping("/getAllClub")
	public ResponseEntity<?> getAllclub() {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.getAllclub());
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/getAdminSummary")
	public ResponseEntity<?> getAdminSummary(){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.getAdminsummary());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
		
	}
	@GetMapping("/getAllCustomer")
	public ResponseEntity<?> getALlcustomer(){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.AllCustomer());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/getplanSummary")
	public ResponseEntity<?> planAndCustomerSummary(){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.PlanSummary());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PostMapping("/addclub")
	public ResponseEntity<?> AddClub(@RequestBody ClubEntity club){
		try {
			System.out.println(club);
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.addClub(club));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PutMapping("/Updateclub")
	public ResponseEntity<?> UpdateClub(@RequestBody ClubEntity club){
		try {
			System.out.println(club);
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.addClub(club));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	@GetMapping("/club/{id}")
	public ResponseEntity<?> clubByid(@PathVariable Long id) {
		System.out.println("in update details"+id);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.clubByid(id));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));

		}
	}
	
	@DeleteMapping("/deleteClubByid/{id}")
	public ResponseEntity<?> delClubbyid(@PathVariable Long id){
		System.out.println("in delte maping of club");
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.deleteClubbyid(id));
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));

		}
		
	}
	@PostMapping("/getCustomerbyPidCid")
	public ResponseEntity<?> getCustomerbyPidCid(@RequestBody AdminPidCidCustDto cust){
		System.out.println(cust);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.customCustomerdetails(cust.getCid(),cust.getPid()));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/getAllPlan")
	public ResponseEntity<?> getAllPlan(){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adminImpl.getAllplan());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
}
