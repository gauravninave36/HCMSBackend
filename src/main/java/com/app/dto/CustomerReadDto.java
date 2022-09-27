package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerReadDto {
	
	private String firstName;
	private String lastName;
	private String address;	
	private Long custContact;	
	private String email;	
	private String password;	
	private LocalDate dateOfPurchase;
	private LocalDate dateOfExpiry;
	private Long clubid;
	private Long planid;
	public CustomerReadDto(String firstName, String lastName, String address, Long custContact, String email,
			String password, LocalDate dateOfPurchase, LocalDate dateOfExpiry, long i, long j) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.custContact = custContact;
		this.email = email;
		this.password = password;
		this.dateOfPurchase = dateOfPurchase;
		this.dateOfExpiry = dateOfExpiry;
		this.clubid = i;
		this.planid = j;
	}
	
	
}
