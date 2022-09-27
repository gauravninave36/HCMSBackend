package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee_details")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"password"})
public class EmployeeEntity extends BaseEntity {
	
	@Column(name="first_name", nullable=false,length=20)
	private String firstName;
	@Column(name="last_name", nullable=false,length=20)
	private String lastName;
	@Column(nullable=false,length=50)
	private String address;
	@Column(name="emp_contact",nullable = false,unique=true)
	private Long empContact;
	@Column(nullable = false,unique=true,length=200)
	private String email;
	@Column(nullable = false,length=20)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "club_id",nullable=false)
	private ClubEntity clubdetails;

	public EmployeeEntity(String firstName, String lastName, String address, Long empContact, String email, String password,
			RoleEnum role,ClubEntity club) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.empContact = empContact;
		this.email = email;
		this.password = password;
		this.role = role;
		this.clubdetails=club;
	}
	
		
}
