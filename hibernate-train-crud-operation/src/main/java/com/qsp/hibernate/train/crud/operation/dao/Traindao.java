package com.qsp.hibernate.train.crud.operation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.qsp.hibernate.train.crud.operation.dto.Train;
import com.qsp.hibernate.train.crud.operation.exception.IdNotFoundException;

public class Traindao {
	
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	// insert method in hibernate
	public void insertTrain(Train train) {
		
		entityTransaction.begin();
		entityManager.persist(train);
		entityTransaction.commit();
		
	} 
	
	
	
//  upadte method in hibernate
	
	public void updateTrain(int id, Train train) {
		Train train2 = entityManager.find(Train.class,id);
		if(train2!=null) {
			
			if((train.getTrainName()!=null) && (train.getTrainCoaches()!=0) && (train.getBoardingPoint()!= null)) {
				
				train2.setBoardingPoint(train.getBoardingPoint());
				train2.setTrainName(train.getTrainName());
				train2.setTrainCoaches(train.getTrainCoaches());

				entityTransaction.begin();
				
				entityManager.merge(train2);
				
				entityTransaction.commit();
			}else if(train.getTrainCoaches() !=0) {
				
				train2.setTrainCoaches(train.getTrainCoaches());
				entityTransaction.begin();
				
				entityManager.merge(train2);
				
				entityTransaction.commit();
			}
		}else {
			System.out.println("train is not found");
		}
	}
	
	
	
	// delete method in hibernate
	public void deleteTrain(int trainNumber) {
		Train train = entityManager.find(Train.class, trainNumber);
		if( train!=null) {
			entityTransaction.begin();
			entityManager.remove(train);
			entityTransaction.commit();
			
		}else {
			try {
				throw new IdNotFoundException("plzz check your id");
			}
			catch(IdNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
			
	}
	// display method in hibernate
	public List<Train> displayTrain(){
		
		String select = "Select t FROM Train t";
		
		Query query = entityManager.createQuery(select);
		
		return query.getResultList();
		
	}


	// delete method in jpql 
	public void deleteTrainjpql(int id) {
		String delete = "Delete t from Train t where t.trainNumber=?123";
		
		Query query=entityManager.createQuery(delete);
		
		query.setParameter(123, id);
		query.executeUpdate();
		System.out.println("Data deleted Susccessfully");
	}

	
	
}
