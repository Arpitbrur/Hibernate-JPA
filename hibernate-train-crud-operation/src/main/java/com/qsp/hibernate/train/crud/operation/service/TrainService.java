package com.qsp.hibernate.train.crud.operation.service;

import java.util.List;

import com.qsp.hibernate.train.crud.operation.dao.Traindao;
import com.qsp.hibernate.train.crud.operation.dto.Train;

public class TrainService {

	Traindao dao= new Traindao();
	// this method is call the insert method of dao class
	
	public void insertTrain(Train train) {
		dao.insertTrain(train);
	}
	
	
	//  upadte method in hibernate
	
	public void updateTrain(int id, Train train) {
		dao.updateTrain(id, train);
	}
	// delete method in hibernate
	
	public void deletetrain(int trainNumber) {
		dao.deleteTrain(trainNumber);
	}
	
	// display method in hibernate
	
	public List<Train> displayTrain(){
		return dao.displayTrain();
		
	}
	
	
	
	// delete method in jpql 
	public void deleteTrainjpql(int id) {
		dao.deleteTrain(id);
	}

}
