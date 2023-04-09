package com.jsp.hibernate_one_to_one_uni_direction_morning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_one_to_one_uni_direction_morning.dto.Passport;
import com.jsp.hibernate_one_to_one_uni_direction_morning.dto.Person;

public class PersonDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	// insert Method 
	public void insertPerson(Person person, Passport passport ) {
		
		entityTransaction.begin();
		entityManager.persist(passport);
		entityManager.persist(person);
		entityTransaction.commit();
		
		System.out.println("Data Inserted Successfully");	
	}
	
	
	// get By Id Method
	public Person getbyidperson(int personId) {
		Person person = entityManager.find(Person.class, personId );
		if(person !=null) {
			return person;
		}else {
			return null;
		}
	}
	
	
	// deleted method
	public void deletePersonPassport(int personId) {
		
		Person person = entityManager.find(Person.class, personId);
		if(person !=null) {
			Passport passport = person.getPassport();
			
			entityTransaction.begin();
			entityManager.remove(passport);
			entityManager.remove(person);
			entityTransaction.commit();
			
			System.out.println("Data Deleted Successfully");	
			
		}	
	}	
	
	// update method
	public void updatePerson(int personId, String personName, int personAge, String passportColor, String passportType) {
		
		Person person = entityManager.find(Person.class, personId);
		if(person != null) {
			Passport passport = person.getPassport();
			
			if(passport != null) {
				passport.setPassportColor(passportColor);
				passport.setPassportType(passportType);
			}
			
			person.setPersonName(personName);
			person.setPersonAge(personAge);
		
			
			entityTransaction.begin();
			entityManager.merge(passport);
			entityManager.merge(person);
			entityTransaction.commit();
			
			System.out.println("Data updated Successfully");
		}	
	}
	
	// display method
	public List<Person> dispalyPerson(){
		
		String Select = "SELECT p FROM Person p";
		
		Query query = entityManager.createQuery(Select);
		
		return query.getResultList();
	}
	
	
}