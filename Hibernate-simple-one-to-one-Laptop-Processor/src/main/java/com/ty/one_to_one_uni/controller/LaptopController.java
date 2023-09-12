package com.ty.one_to_one_uni.controller;

import java.util.Scanner;

import com.ty.one_to_one_uni.dto.Laptop;
import com.ty.one_to_one_uni.dto.Processor;
import com.ty.one_to_one_uni.service.LaptopService;

public class LaptopController {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		LaptopService laptopService = new LaptopService();
		Processor processor= new Processor();
		
		Laptop laptop= new Laptop();
		while(true) {
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Display");
			System.out.println("Enter your choice : ");
			int ch = scanner.nextInt();
			switch(ch) {
			//InsertMethod
			case 1 :{
				System.out.println("Enter Laptop name : ");
				laptop.setName(scanner.next());
				System.out.println("Enter Laptop Price : ");
				laptop.setPrice(scanner.nextDouble());
				
				
				System.out.println("Enter LaptopProcessor name : ");
				processor.setProcessorName(scanner.next());
				System.out.println("Enter LaptopProcessor Speed : ");
				processor.setSpeed(scanner.next());
				System.out.println("Enter laptopProcessor core : ");
				processor.setCore(scanner.next());
				laptop.setProcessor(processor);
				laptopService.insertLaptopProcessor(laptop, processor);
			}break;
			//UpdateMethod
			case 2:{
				System.out.println("Enter your id : ");
				int id =scanner.nextInt();
				System.out.println("Enter Laptop name :");
				String name= scanner.next();
				System.out.println("Enter Laptop price :");
				double price = scanner.nextDouble();
				System.out.println("Enter Processor name: ");
				String processorName= scanner.next();
				System.out.println("Enter Processor core :");
				String core = scanner.next();
				System.out.println("Enter Processor Speed :");
				String speed = scanner.next();
				laptopService.updateLaptopProcessor(id, name, processorName, price, core, speed);
				
			}break;
			//DeleteMethod
			case 3:{
				System.out.println("Enter your Id for delete: ");
				int id = scanner.nextInt();
				laptopService.deleteLaptopProcessor(id);
			}break;
			//DisplayMethod
			case 4:{
				for(Laptop laptop2: laptopService.DisplayLaptopProcessor()) {
					System.out.println("Laptop Id: "+laptop2.getId());
					System.out.println("Laptop Name: "+laptop2.getName());
					System.out.println("Laptop Price: "+laptop2.getPrice());
					System.out.println("================================================");
					System.out.println("Processor Details : ");
					if(laptop2.getProcessor()!=null) {
						System.out.println("Processor Id: "+laptop2.getProcessor().getId());
						System.out.println("Processor Name: "+laptop2.getProcessor().getProcessorName());
						System.out.println("Processor Core: "+laptop2.getProcessor().getCore());
						System.out.println("Processor Speed: "+laptop2.getProcessor().getSpeed());
					}
				}
			}break;
			
			
		}	
		
	  }	
	}
}

