package com.app.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "service_details")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ServiceEntity {
	@Id
	@Column(name="service_id",nullable = false)
	private Integer serviceId;
	@Column(name="service_name",length=20,nullable = false)
	private String serviceName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_id",nullable=false)
	private PlanEntity planId;

	public ServiceEntity(Integer serviceId, String serviceName, PlanEntity planId) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.planId = planId;
	}
}
