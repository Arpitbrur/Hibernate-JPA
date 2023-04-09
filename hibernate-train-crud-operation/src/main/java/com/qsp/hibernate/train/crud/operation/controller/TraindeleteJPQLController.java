package com.qsp.hibernate.train.crud.operation.controller;

import com.qsp.hibernate.train.crud.operation.service.TrainService;

public class TraindeleteJPQLController {

	public static void main(String[] args) {
		
		//Scanner s= new Scanner(System.in);
		
		TrainService service = new TrainService();
		service.deletetrain(2344);
	}
}
