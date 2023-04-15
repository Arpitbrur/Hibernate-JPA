package com.jsp.hibernate_simple_project.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate_simple_project.dto.Student;

public class StudentDelete {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("arpit");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student =entityManager.find(Student.class, 112);
		if(student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			
			System.out.println("Data deleted");
		}
		
		
	}
}
