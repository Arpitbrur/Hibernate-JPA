package hibernate_many_to_many_uni_morning.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_many_uni_morning.dto.Student;

public class StudentDao {

	EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	// insert method
	public void insertStudent(Student student) {
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		
		System.out.println("Data Inserted");
	}

}
