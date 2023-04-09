package com.qsp.hibernate.train.crud.operation.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Train {

	@Id
	private int trainNumber;
	private String trainName;
	private int trainCoaches;
	private String boardingPoint;
	
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String string) {
		this.trainName = string;
	}
	public int getTrainCoaches() {
		return trainCoaches;
	}
	public void setTrainCoaches(int trainCoaches) {
		this.trainCoaches = trainCoaches;
	}
	public String getBoardingPoint() {
		return boardingPoint;
	}
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}
	
	
	
}
