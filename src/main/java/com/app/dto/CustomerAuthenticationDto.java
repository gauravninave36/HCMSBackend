package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerAuthenticationDto {
	private String email;
	private String password;
	public CustomerAuthenticationDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
}
