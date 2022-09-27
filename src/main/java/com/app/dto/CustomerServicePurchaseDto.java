package com.app.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerServicePurchaseDto {
	
	
	private long planId;
	private long clubId;
	
	public CustomerServicePurchaseDto( long planId, long clubId) {
		super();
		
		this.planId = planId;
		this.clubId = clubId;
	}
	
	
	
	
}
