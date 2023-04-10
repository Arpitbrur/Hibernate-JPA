package com.jsp.hibernate_one_to_one_bi_direction_morning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_one_to_one_bi_direction_morning.dto.Laptop;

public class LaptopDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	// inert method
	public void insertLaptop(Laptop laptop) {
		
		entityTransaction.begin();
		entityManager.persist(laptop);
		entityTransaction.commit();
		System.out.println("Data Inserted Successfully");
	}
	
	//getByID
	public Laptop getByIDLaptop(int laptopId) {
		return entityManager.find(Laptop.class, laptopId);
	}
	
	// update Method
	public void updateLaptop(Laptop laptop) {
		entityTransaction.begin();
		entityManager.merge(laptop);
		entityTransaction.commit();
		
		System.out.println("Data updated Successfully");
	}
	
	//delete Method
	public void deleteLaptop(int laptopId) {
		Laptop laptop= entityManager.find(Laptop.class, laptopId);
		if(laptop != null) {
			entityTransaction.begin();
			entityManager.remove(laptop);
			entityTransaction.commit();
			
			System.out.println("Data Deleted");
		}else {
			System.out.println(" ID os not found in Database");
		}
	}
	
	// display method
	public List<Laptop> displayAllLaptop(){
		String select = "SELECT l FROM Laptop l";
		Query query = entityManager.createQuery(select);
		return query.getResultList();
	}
}
