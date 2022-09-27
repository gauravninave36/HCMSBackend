package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class summarydto {
	private Long club_id;
	private String clubName;
	private String location;
	private Long sum;
	private Long NumberofCustomerInfranchise;

	
}
