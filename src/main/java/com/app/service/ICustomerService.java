package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.*;
import com.app.entity.ClubEntity;
import com.app.entity.CustomerEntity;

public interface ICustomerService {
	//CustomerEntity addCustomer(CustomerDto transientCust);
	CustomerEntity addCustomer(CustomerCreateDto transientCust);
	List<CustomerEntity> getCustomers();
	CustomerEntity updateCustomer(CustomerUpdateDto updateCust,long cid);
	String deleteCust(long id);
	CustomerEntity authenticateCustomer(String email, String password);	
	CustomerEntity getCustomerData(Long cId);
	CustomerEntity custAfterPurchase(CustomerServicePurchaseDto custPurchase,long cid);
	List<ClubEntity> getClubs();

	
}
