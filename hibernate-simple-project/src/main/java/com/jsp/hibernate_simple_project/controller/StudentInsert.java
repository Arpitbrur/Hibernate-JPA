package com.jsp.hibernate_simple_project.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate_simple_project.dto.Student;

public class StudentInsert {
public static void main(String[] args) {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Student student=new Student();
	
//	student.setId(111);
//	student.setName("Arpit");
//	student.setEmail("Arpit@gmail.com");
	
	student.setId(112);
	student.setName("Ram");
	student.setEmail("Ram@gmail.com");
	
//	student.setId(113);
//	student.setName("Sumit");
//	student.setEmail("Sumit@gmail.com");

	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
	
	System.out.println("Data Inserted");
}
}
