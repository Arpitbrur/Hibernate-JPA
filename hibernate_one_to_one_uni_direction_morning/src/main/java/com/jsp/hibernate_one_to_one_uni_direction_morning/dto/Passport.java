package com.jsp.hibernate_one_to_one_uni_direction_morning.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Passport {
	
	@Id
	private int passportId;
	private String passportColor;
	private String passportType;
	
	@UpdateTimestamp
	private LocalDateTime dateTime;
	
	
}
