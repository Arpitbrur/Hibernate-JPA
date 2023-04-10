package com.jsp.hibernate_one_to_one_bi_direction_morning.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "laptopId")
	private Laptop laptop;

	public Employee(int employeeId, String employeeName, String employeeEmail) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
	}
	
	
	
	
	
	
	//Mapped BY:- mapped by is a attribute of hibernate JPA which is used to mapping concept
		// Used of mapped by:- once the programmer used bi direction mapping then foreign key will
		// be create in both table, but when we required forgein key only in one table, so we have 
		//to write mapped by at the top of independent object.
		
		
		// cascade:- cascade is the attribute of hibernate JPA. it is used to persist the independent 
		// object automatic.
		// where to write the cascade:- we have to cascade attribute at the top of dependent object. 
		// BUt it is an option. we can write the at the top of independent object.
		
}
