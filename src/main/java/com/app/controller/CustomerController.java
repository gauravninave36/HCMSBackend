package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerAuthenticationDto;
import com.app.dto.CustomerCreateDto;
import com.app.dto.CustomerReadDto;
import com.app.dto.CustomerServicePurchaseDto;
import com.app.dto.CustomerUpdateDto;
import com.app.dto.TestCust;
import com.app.entity.ClubEntity;
import com.app.entity.CustomerEntity;
import com.app.service.ICustomerService;


@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins="https://health-club-management.herokuapp.com")
public class CustomerController {
	@Autowired
	private ICustomerService custService;
	
	//for testing purpose
	@GetMapping("/test")
	public TestCust test(@RequestBody TestCust test) {
		return new TestCust(test.getName(),test.getSalary());
	}
	
//	@GetMapping("/testt")
//	public CustomerServicePurchaseDto test1(@RequestBody CustomerServicePurchaseDto test) {
//		return new CustomerServicePurchaseDto(test.getCustomerId(),test.getPlanId(),test.getClubId());
//	}
	
	//======================================================
	
	//Login customer based on its pack opted
		@PostMapping("/login")
		public CustomerEntity autCustomer(@RequestBody CustomerAuthenticationDto loginUser) {
			
			CustomerEntity loginCustomer = custService.authenticateCustomer(loginUser.getEmail(), loginUser.getPassword());
//			if(loginCustomer.getPlanId().getId()==4) {
//				System.out.println("plan: no package alloted");
//				return "no package alloted";
//			}
//			else if(loginCustomer.getPlanId().getId()==1) {
//				System.out.println("plan: 1");
//				return "1";
//			}else if(loginCustomer.getPlanId().getId()==2) {
//				System.out.println("plan: 2");
//				return "2";
//			}else {
//				System.out.println("plan: 3");
//				return "3";
//			}
			
			return loginCustomer;
		}
		
		//=================================================================================
	
	//================================================================
	
	//get all customer details--- this is not aim of a customer...it is extra method added
	@GetMapping
	public List<CustomerEntity> getAllCustomer(){
		System.out.println("Inside get customer controller method");
		return custService.getCustomers();
	}
	
	//================================================================
	
	//Get customer details by id
	@GetMapping("/{custid}")
	public CustomerEntity getCustomerDetails(@PathVariable long custid) {
		
		System.out.println("inside get customer details");
		CustomerEntity customerData = custService.getCustomerData(custid);
		//String firstName, String lastName, String address, Long custContact, String email,
		//String password, LocalDate dateOfPurchase, LocalDate dateOfExpiry, int clubid, int planid
//		CustomerReadDto customerDataRepre = new CustomerReadDto(customerData.getFirstName(), 
//															    customerData.getLastName(), 
//															    customerData.getAddress(), 
//															    customerData.getCustContact(), 
//															    customerData.getEmail(), 
//															    customerData.getPassword(), 
//															    customerData.getDateOfPurchase(), 
//															    customerData.getDateOfExpiry(), 
//															    customerData.getClubId().getId(), 
//															    customerData.getPlanId().getId());
//		return customerDataRepre;
		return customerData;
	}
	
	//==========================================================================
	
	//add customer (rev 0)
//	@PostMapping
//	public CustomerEntity addNewCustomer(@RequestBody CustomerDto cust) {
//		System.out.println("in add customer controller method"+ cust);
//		return custService.addCustomer(cust);
//	}
	
	//===============================================================================
	
	//add customer (latest)
	@PostMapping
	public CustomerEntity addNewCustomer(@RequestBody CustomerCreateDto cust) {
		System.out.println("in add customer controller method");
		return custService.addCustomer(cust);
	}
	
	//=================================================================================
	
	//update Customer details
//	@PutMapping
//	public CustomerEntity updateCustomer(@RequestBody CustomerEntity cust) {
//		System.out.println("in update customer controller method"+cust);
//		return custService.updateCustomer(cust);
//	}
	
	@PutMapping("/{cid}")
	public CustomerEntity updateCustomer(@RequestBody CustomerUpdateDto cust, @PathVariable long cid) {
		System.out.println("in update customer controller method"+cust);
		return custService.updateCustomer(cust,cid);
	}
	
	//==============================================================================
	
	//delete Customer details
	@DeleteMapping("/{cid}")
	public String deleteCustDetails(@PathVariable long cid) {
		System.out.println("in delete customer controller method");
		return custService.deleteCust(cid);
	}
	
	//====================================================================================
	
	//Add service/pack details to user
	@PostMapping("/purchase/{cid}")
	public CustomerEntity customerDetailsAfterServicePurchase(@RequestBody CustomerServicePurchaseDto custPur, @PathVariable long cid) {
	
		return custService.custAfterPurchase(custPur,cid);
	}
	
	//====================================================================================
	
	//Get All Club Details
	@GetMapping("/clubs")
	public List<ClubEntity> getAllClubs(){
		System.out.println("Inside get customer controller method");
		return custService.getClubs();
	}
	
	

	
}
