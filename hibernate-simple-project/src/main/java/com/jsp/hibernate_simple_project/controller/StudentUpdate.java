package com.jsp.hibernate_simple_project.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate_simple_project.dto.Student;

public class StudentUpdate {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student = new Student();
		
		student.setId(111);
		student.setName("Arpitbrur");
		student.setEmail("Arpitbrur@gmail.com");
		
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		
		System.out.println("Data Updated");
	}
	
	
}
