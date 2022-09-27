package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerUpdateDto {
	
	private String firstName;
	private String lastName;
	private String address;	
	private Long custContact;	
	private String email;	
	private String password;
	public CustomerUpdateDto(String firstName, String lastName, String address, Long custContact, String email,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.custContact = custContact;
		this.email = email;
		this.password = password;
	}	
	
	
	
}
