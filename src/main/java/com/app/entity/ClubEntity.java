package com.app.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "club_details")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClubEntity extends BaseEntity {
	@Column(length=100,nullable = false)
	private String location;
	@Column(nullable = false)
	private Long clubContact;
	@Column(length=50,nullable = false)
	private String clubName;
	
	public ClubEntity(String location, Long clubContact, String clubName) {
		super();
		this.location = location;
		this.clubContact = clubContact;
		this.clubName = clubName;
	}

	
		
}
