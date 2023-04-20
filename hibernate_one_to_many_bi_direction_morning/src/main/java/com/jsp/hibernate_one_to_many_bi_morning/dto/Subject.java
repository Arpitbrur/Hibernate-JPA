package com.jsp.hibernate_one_to_many_bi_morning.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	private String subjectName;
	private String subjectAuthor;
	private double subjectPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;

	public Subject(int subjectId, String subjectName, String subjectAuthor, double subjectPrice) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectAuthor = subjectAuthor;
		this.subjectPrice = subjectPrice;
	}
	
}
