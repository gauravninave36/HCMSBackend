package com.app.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TestCust {
	private long name;
	private long salary;
	public TestCust(long name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
}
