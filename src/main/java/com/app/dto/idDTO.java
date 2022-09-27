package com.app.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class idDTO {
	private Long id;
	public idDTO(Long id) {
		super();
		this.id = id;
	}	
}
