package com.ty.one_to_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_one_uni.dto.Laptop;
import com.ty.one_to_one_uni.dto.Processor;



public class LaptopDao {

	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction= entityManager.getTransaction();
	//InsertMethod
	public void insertLaptopProcessor(Laptop laptop, Processor processor) {
		entityTransaction.begin();
		entityManager.persist(processor);
		entityManager.persist(laptop);
		entityTransaction.commit();
	}
	
	//UpdateMethod
		public void updateLaptopProcessor(int id, String name, String processorName, double price, String core, String speed) {
			Laptop laptop= entityManager.find(Laptop.class, id);
			
			Processor processor= laptop.getProcessor();
			if(laptop!=null) {
				if(processor!=null) {
					processor.setProcessorName(processorName);
					processor.setCore(core);
					processor.setSpeed(speed);
					laptop.setName(name);
					laptop.setPrice(price);
					entityTransaction.begin();
					entityManager.persist(processor);
					entityManager.persist(laptop);
					entityTransaction.commit();
				}else {
					System.out.println("Check your Id.....");
				}
			}
			
		}
		//DeleteMethod
		public void deleteLaptopProcessor(int id) {
			Laptop laptop= entityManager.find(Laptop.class, id);
			Processor processor=laptop.getProcessor();
			if(laptop!=null) {
				entityTransaction.begin();
				if(processor!=null) {
					entityManager.remove(processor);
				}else {
					System.out.println("Id is not found....");
				}
				entityManager.remove(laptop);
				entityTransaction.commit();
			}
			else {
				System.out.println("laptop id is not found....");
			}
			
		}
		//DisplayMethod
		public List<Laptop> displayLaptop(){
			String select ="Select l From Laptop l";
			Query query= entityManager.createQuery(select);
			return query.getResultList();
		}
		
		
		
}
