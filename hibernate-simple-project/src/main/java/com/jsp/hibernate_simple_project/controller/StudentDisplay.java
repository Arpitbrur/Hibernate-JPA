package com.jsp.hibernate_simple_project.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_simple_project.dto.Student;

public class StudentDisplay {

	public static void main(String[] args) {
		
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	String select= "SELECT s FROM Student s";
	Query query = entityManager.createQuery(select);
	
	List<Student> student = query.getResultList();
	
	for (Student student2 : student) {
		System.out.println("id:"+student2.getId());
		System.out.println("name: "+student2.getName());
		System.out.println("email: "+student2.getEmail());
		
		System.out.println("  ");
	}
	}	
}
