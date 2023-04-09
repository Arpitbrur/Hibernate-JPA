package com.qsp.hibernate.train.crud.operation.controller;

import java.util.Scanner;

import com.qsp.hibernate.train.crud.operation.dto.Train;
import com.qsp.hibernate.train.crud.operation.service.TrainService;

public class TrainController {

	public static void main(String[] args) {
		Scanner Scanner= new Scanner(System.in);
		TrainService trainService = new TrainService();
		Train train = new Train();
		
		while (true) {
			System.out.println(" 1. Insert");
			System.out.println(" 2. Update");
			System.out.println(" 3. delete");
			System.out.println(" 4. display");
			System.out.println("Enter your Choice");
			int ch = Scanner.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("Enter Train Number");
				train.setTrainNumber(Scanner.nextInt());
				System.out.println("Enter Train name");
				train.setTrainName(Scanner.next());
				System.out.println(" Enter Train Coaches");
				train.setTrainCoaches(Scanner.nextInt());
				System.out.println(" Enter Train Boarding point");
				train.setBoardingPoint(Scanner.next());
				
				trainService.insertTrain(train);
				
				System.out.println("data inserted");
			}break;
			
		// update method in hibernate
			case 2: {
				System.out.println("1.UpdateEverything\n2.updateName\n3.updateCoaches\n4.return");
				System.out.println("choose your option to update the data");

				int ch1 = Scanner.nextInt();

				switch (ch1) {

				case 1: {
					train = new Train();
					System.out.println("enter train id to update");
					int id = Scanner.nextInt();
					
					System.out.println("enter the new train name");
					train.setTrainName(Scanner.next());
					
					System.out.println("enter the new train coaches");
					train.setTrainCoaches(Scanner.nextInt());
					
					System.out.println("enter the new boarding point");
					train.setBoardingPoint(Scanner.next());
					
					trainService.updateTrain(id, train);
				}
					break;
				case 2: {
					
					train = new Train();
					System.out.println("enter train id to update");
					int id = Scanner.nextInt();
					
					System.out.println("enter the new train name");
					train.setTrainName(Scanner.next());
					
					trainService.updateTrain(id, train);
					
				}
					break;
					
				case 3: {
					train = new Train();
					System.out.println("enter train id to update");
					int id = Scanner.nextInt();
					System.out.println("enter the new train coaches");
					train.setTrainCoaches(Scanner.nextInt());
					trainService.updateTrain(id, train);
				}
					break;
				case 4: {

					return;
				}
					
				}
				System.out.println("data Updated");
				
			}break;
								
			case 3:{
				System.out.println("Enter the train number");
				trainService.deletetrain(Scanner.nextInt());
				
				System.out.println("data deleted");
			}break;
			
			case 4:{
				for( Train train1 : trainService.displayTrain()) {
					System.out.println(train1.getTrainNumber());
					System.out.println(train1.getTrainCoaches());
					System.out.println(train1.getTrainName());
					System.out.println(train1.getBoardingPoint());
					System.out.println("........................");
					System.out.println(" ");
				}
			}break;
				
			}
			
		}

	}

}
