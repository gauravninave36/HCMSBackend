package com.app.dto;


import com.app.entity.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"password"})
public class Employeedto {
	
	private String firstName;
	private String lastName;
	private String address;
	private Long empContact;
	private String email;
	private String password;
	private RoleEnum role;
	private Long club_id;
	public Employeedto(String firstName, String lastName, String address, Long empContact, String email, String password,
			RoleEnum role,Long club_id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.empContact = empContact;
		this.email = email;
		this.password = password;
		this.role = role;
		this.club_id = club_id;
	}
	
		
}
