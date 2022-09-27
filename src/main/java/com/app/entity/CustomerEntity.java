package com.app.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_details")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"password"})
public class CustomerEntity extends BaseEntity {
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	@Column(name="last_name",nullable = false)
	private String lastName;
	@Column(nullable=false,length=50)
	private String address;
	@Column(name="cust_contact",unique=true,nullable = false)
	private Long custContact;
	@Column(unique=true,length=20,nullable = false)
	private String email;
	@Column(length=20,nullable = false)
	private String password;
	@Column(name="date_of_purchase")
	private LocalDate dateOfPurchase;
	@Column(name="date_of_expiry")
	private LocalDate dateOfExpiry;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "club_id",nullable = false)
	private ClubEntity clubId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="plan_id",nullable = false)
	private PlanEntity planId;
	
	public CustomerEntity(String firstName, String lastName, String address, Long custContact, String email, String password,
			LocalDate dateOfPurchase, LocalDate dateOfExpiry, ClubEntity clubId, PlanEntity planId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.custContact = custContact;
		this.email = email;
		this.password = password;
		this.dateOfPurchase = dateOfPurchase;
		this.dateOfExpiry = dateOfExpiry;
		this.clubId = clubId;
		this.planId = planId;
	}
	
	
	
	
	
	
	
	
}
