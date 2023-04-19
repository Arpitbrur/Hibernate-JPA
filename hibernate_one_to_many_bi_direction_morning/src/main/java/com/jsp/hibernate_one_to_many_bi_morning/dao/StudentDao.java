package com.jsp.hibernate_one_to_many_bi_morning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_one_to_many_bi_morning.dto.Student;

public class StudentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	// insert method
	public void insertStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		
		System.out.println("Data Inserted");
	}
	
	// Search by id
	public Student searchStudent(int studentId) {
		return entityManager.find(Student.class, studentId);
		
		
	}  
	
	//update method
	public void updateStudent(Student student) {
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		
		System.out.println("Data updated");
	}
	
	// delete method
	public void deleteStudent(int studentId) {
		Student student = entityManager.find(Student.class, studentId);
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		
		System.out.println("Data Deleted");
	}
	
	//display method
	public List<Student> displayStudent(){
		String select = "SELECT s FROM Student s";
		Query query = entityManager.createQuery(select);
		return query.getResultList();
	}
			
}
