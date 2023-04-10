package com.jsp.hibernate_one_to_one_bi_direction_morning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_one_to_one_bi_direction_morning.dto.Employee;

public class EmployeeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	// Insert Method
	public void insertEmployee(Employee employee) {
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		System.out.println(" Data Inserted Successfully");
		
	}
	
	//getById Method
	public Employee getByIdEmployee(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}
	
	// Update Method
	public void updateEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		
		System.out.println("Data Updated Successfully");
	}
	
	// delete Method
	public void deleteEmployee(int employeeId) {
		Employee employee= entityManager.find(Employee.class, employeeId);
		if(employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			System.out.println("Data deleted");
		}else {
			System.out.println("Id is not found in database");
		}
		
	}
	
	// display method
	public List<Employee> displayAllEmployee(){
		String select = "SELECT e FROM Employee e";
		Query query = entityManager.createQuery(select);
		return query.getResultList();
	}
}
