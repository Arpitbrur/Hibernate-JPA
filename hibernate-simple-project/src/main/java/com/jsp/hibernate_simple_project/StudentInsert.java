package com.jsp.hibernate_simple_project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentInsert {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Student student=new Student();
	
	student.setId(113);
	student.setName("Sumit");
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
	
	System.out.println("sucessfull");
}
}
