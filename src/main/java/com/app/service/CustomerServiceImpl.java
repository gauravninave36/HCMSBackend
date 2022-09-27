package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customeException.ResourceNotFoundException;
import com.app.dao.CustomerClubRepository;
import com.app.dao.CustomerPlanRepository;
import com.app.dao.CustomerRepository;
import com.app.dto.CustomerCreateDto;
import com.app.dto.CustomerServicePurchaseDto;
import com.app.dto.CustomerUpdateDto;
import com.app.entity.ClubEntity;
import com.app.entity.CustomerEntity;
import com.app.entity.PlanEntity;

@Service
@Transactional

public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private CustomerClubRepository clubRepo;
	@Autowired
	private CustomerPlanRepository planRepo;
	
	
//	@Override
//	public CustomerEntity addCustomer(CustomerDto transientCust) {
//	ClubEntity clubdetails = clubRepo.findById(transientCust.getClubId()).orElseThrow(()->new RuntimeException("not found "));
//	
//	PlanEntity plandetails = planRepo.findById(transientCust.getActivePlan()).orElseThrow(()->new RuntimeException("not found "));
//
////	String firstName, String lastName, String address, Long custContact, String email, String password,
////	LocalDate dateOfPurchase, LocalDate dateOfExpiry, ClubEntity clubId, PlanEntity activePlan
//	CustomerEntity transientCustomer= new CustomerEntity(transientCust.getFirstName(),transientCust.getLastName(),transientCust.getAddress(),
//			transientCust.getCustContact(),transientCust.getEmail(),transientCust.getPassword(),transientCust.getDateOfPurchase(),
//			transientCust.getDateOfExpiry(),clubdetails,plandetails);
//	CustomerEntity persistentEntity = custRepo.save(transientCustomer);
//	System.out.println("Inside servce impl add customer");
//	return persistentEntity;
//	}
	
	
	//======================================================================================
	//======================================================================================

	
	@Override
	public CustomerEntity addCustomer(CustomerCreateDto transientCust) {
//String firstName, String lastName, String address, Long custContact, String email, String password,
//LocalDate dateOfPurchase, LocalDate dateOfExpiry, ClubEntity clubId, PlanEntity planId
		ClubEntity clubdetails = clubRepo.findById(1L).orElseThrow(()->new RuntimeException("not found "));
		
		PlanEntity plandetails = planRepo.findById(4L).orElseThrow(()->new RuntimeException("not found "));
	
		CustomerEntity transientEntity = new CustomerEntity(transientCust.getFirstName(),
				transientCust.getLastName(), 
				transientCust.getAddress(), 
				transientCust.getCustContact(), 
				transientCust.getEmail(), 
				transientCust.getPassword(), 
				null, null,clubdetails, plandetails);
		
		return custRepo.save(transientEntity);
	}
	
	//======================================================================================
	//======================================================================================

	
	@Override
	public List<CustomerEntity> getCustomers() {
		
		return custRepo.findAll();
	}

	//======================================================================================
	//======================================================================================


	@Override
	public CustomerEntity updateCustomer(CustomerUpdateDto updateCust, long cid) {
		
		CustomerEntity detachedCust = custRepo.findById(cid).orElseThrow(()->new RuntimeException("Customer with "+cid+" not found"));
		detachedCust.setFirstName(updateCust.getFirstName());
		detachedCust.setLastName(updateCust.getLastName());
		detachedCust.setAddress(updateCust.getAddress());
		detachedCust.setCustContact(updateCust.getCustContact());
		detachedCust.setEmail(updateCust.getEmail());
		detachedCust.setPassword(updateCust.getPassword());
//		custRepo.findById(detachedCust.getId()).
//		orElseThrow(()->new RuntimeException("Customer with"+detachedCust.getId()+"not found"));
		
		return custRepo.save(detachedCust);
	}

	//======================================================================================
	//======================================================================================

	@Override
	public String deleteCust(long id) {
		String mesg = "Deleting customer details failed !!!!!";
		if(custRepo.existsById(id))
		{
			custRepo.deleteById(id);
			mesg = "Deleted customer successful";
		}
		return mesg	;
	}

	//======================================================================================
	//======================================================================================

	@Override
	public CustomerEntity authenticateCustomer(String email, String password) {
		
		Optional<CustomerEntity> optional = custRepo.findByEmailAndPassword(email, password);
		System.out.println(optional);
		LocalDate exp = optional.get().getDateOfExpiry();
		if(exp!=null) {
			System.out.println("Inside impl expiry logic method******************");
			if(exp.isBefore(LocalDate.now())) {
				System.out.println("pack is expired");
				updateCustomerBasedOnExpiry(optional);		
			}else {
				System.out.println("pack is active");
			}
		}
		
		return optional.orElseThrow(()->new ResourceNotFoundException("Email or Password is incorrect"));
	}
	
	public void updateCustomerBasedOnExpiry(Optional<CustomerEntity> optional) {
		PlanEntity plan= planRepo.findById(4L).
				orElseThrow(()->new ResourceNotFoundException("planid not found"));
		
		optional.get().setPlanId(plan);
		optional.get().setDateOfPurchase(null);
		optional.get().setDateOfExpiry(null);
		System.out.println(optional.get().getPlanId().getId());	
	}
	
	//===============================================================
	//==================================================================
	@Override
	public CustomerEntity getCustomerData(Long cId) {
		//ClubEntity clubdetails = clubRepo.findById(4L).orElseThrow(()->new RuntimeException("not found "));
		
		return custRepo.findById(cId).orElseThrow(()-> new RuntimeException("not found"));
	}

	//======================================================================================
	//========================================================================================
	
	@Override
	public CustomerEntity custAfterPurchase(CustomerServicePurchaseDto custPurchase,long cid) {
		System.out.println("inside service method 	");
		CustomerEntity customerPersist = custRepo.findById(cid).orElseThrow(()-> new RuntimeException("error in cust serv purc service method 1"));
		ClubEntity clubEntity = clubRepo.findById(custPurchase.getClubId()).orElseThrow(()-> new RuntimeException("error in cust serv purc service method 2"));
		PlanEntity planEntity = planRepo.findById(custPurchase.getPlanId()).orElseThrow(()-> new RuntimeException("error in cust serv purc service method 3"));
		
		System.out.println(LocalDate.now());
		customerPersist.setDateOfPurchase(LocalDate.now());
		
		LocalDate currentDate = LocalDate.now();
		LocalDate afterOneYear = currentDate.plusYears(1);
		System.out.println("purchase date "+ currentDate+ "  Expiry date : "+afterOneYear);
		System.out.println(afterOneYear);
		
		customerPersist.setDateOfExpiry(afterOneYear);
		
		customerPersist.setClubId(clubEntity);
		customerPersist.setPlanId(planEntity);
		return customerPersist;
	}
	
	//======================================================================================
	//======================================================================================
	
	@Override
	public List<ClubEntity> getClubs() {
		
		return clubRepo.findAll();
	}

	
	

	
	
	
	
	
	
	
	

}
