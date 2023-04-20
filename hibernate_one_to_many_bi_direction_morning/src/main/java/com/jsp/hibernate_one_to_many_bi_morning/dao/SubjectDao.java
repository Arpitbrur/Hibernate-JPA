package com.jsp.hibernate_one_to_many_bi_morning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_one_to_many_bi_morning.dto.Subject;

public class SubjectDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	// insert method
	public void insertSubject(List<Subject> list) {
		for(Subject subject :list) {
			entityTransaction.begin();
			entityManager.persist(subject);
			entityTransaction.commit();
			
		}
		
		System.out.println("Data Inserted");
	}
	
	// search by id
	public Subject searchSubject(int subjectId) {
		return entityManager.find(Subject.class, subjectId);
	}
	
	// update method
	public void updateSubject(Subject subject) {
		entityTransaction.begin();
		entityManager.merge(subject);
		entityTransaction.commit();
		
		System.out.println("Data updated");
	}
	
	//delete method
	public void deleteSubject(int subjectId) {
		Subject subject = entityManager.find(Subject.class, subjectId);
		entityTransaction.begin();
		entityManager.remove(subject);
		entityTransaction.commit();
		
		System.out.println("Data Deleted");
		
	}
	
	// display method
	public List<Subject> displaySubject(){
		String select = "SELECT s FROM Subject s";
		Query query = entityManager.createQuery(select);
		return query.getResultList();
	}
}
