package com.app.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "plan_details")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PlanEntity extends BaseEntity {
	@Column(name="name", length=30,unique = true,nullable = false)
	private String planName;
	@Column(name="price",nullable = false)
	private Long planPrice;
	@Column(name="status", length=30,nullable = false)
	private String planStatus;
	
	public PlanEntity(String planName, Long planPrice, String planStatus) {
		super();
		this.planName = planName;
		this.planPrice = planPrice;
		this.planStatus = planStatus;
	}
	
	
}
