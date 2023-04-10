package com.jsp.hibernate_one_to_one_bi_direction_morning.Controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_one_to_one_bi_direction_morning.dto.Employee;
import com.jsp.hibernate_one_to_one_bi_direction_morning.dto.Laptop;
import com.jsp.hibernate_one_to_one_bi_direction_morning.service.LaptopService;

public class LaptopController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Laptop laptop = new Laptop();
		Employee employee = new Employee();
		LaptopService laptopService = new LaptopService();
		while(true){
			System.out.println("Enter your Choice");
			System.out.println("1.Insert\n2. GetById\n3. Update\n4. Delete\n5. Display\n6. Exit");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				System.out.println("===========Laptop Detail===============");
				System.out.println("Enter Laptop Id ");
				laptop.setLaptopId(sc.nextInt());
				System.out.println("Enter Laptop Color ");
				laptop.setLaptopColor(sc.next());
				System.out.println("Enter laptop Price");
				laptop.setLaptopPrice(sc.nextDouble());
				
				
				System.out.println("=============Employee Detail===============");
				System.out.println("Enter employee Id");
				employee.setEmployeeId(sc.nextInt());
				System.out.println("Employee Name");
				employee.setEmployeeName(sc.next());
				System.out.println("Employee Email");
				employee.setEmployeeEmail(sc.next());
				
				
				laptop.setEmployee(employee);
				employee.setLaptop(laptop);
				laptopService.insertLaptop(laptop);
			}break;
			
			case 2:{
				System.out.println("Enter the LaptopId for fetching");
				Laptop laptop1 = laptopService.getByIDLaptop(sc.nextInt());
				
				if(laptop1 != null) {
					System.out.println("=============laptop Detail===============");
					System.out.println("Laptop Id: "+laptop1.getLaptopId());
					System.out.println("LaptopColor: "+laptop1.getLaptopColor());
					System.out.println("Laptop Price: "+laptop1.getLaptopPrice());
					System.out.println("=============Employee Detail===============");			
					System.out.println("EmployeeID: "+ laptop1.getEmployee().getEmployeeId());
					System.out.println("EmployeeNAme: "+laptop1.getEmployee().getEmployeeName());
					System.out.println("EmployeEmail: "+laptop1.getEmployee().getEmployeeEmail());
						
				}else {
					System.out.println(" Id id not present in database or already has been deleted");
				}
			}break;
			
			case 3:{
				
				System.out.println("=============laptop Detail===============");
				System.out.println("Enter Laptop Id ");
				laptop.setLaptopId(sc.nextInt());
				System.out.println("Enter Laptop Color ");
				laptop.setLaptopColor(sc.next());
				System.out.println("Enter laptop Price");
				laptop.setLaptopPrice(sc.nextDouble());
				
				System.out.println("=============Employee Detail===============");
				System.out.println("Enter employee Id");
				employee.setEmployeeId(sc.nextInt());
				System.out.println("Employee Name");
				employee.setEmployeeName(sc.next());
				System.out.println("Employee Email");
				employee.setEmployeeEmail(sc.next());
				
				laptop.setEmployee(employee);
				laptopService.updateLaptop(laptop);
			}break;
			
			case 4:{
				System.out.println("Enter the laptopID which you want to deleted");
				laptopService.deleteLaptop(sc.nextInt());
			}break;
			
			
			case 5:{
				List<Laptop> list = laptopService.displayAllLaptop();
				for(Laptop laptop2 : list) {
					System.out.println("=============Laptop Detail===============");
					System.out.println("LaptopID: "+ laptop2.getLaptopId());
					System.out.println("LaptopColor: "+laptop2.getLaptopColor());
					System.out.println("LaptopPrice: "+laptop2.getLaptopPrice());
					
					System.out.println("==============Employee Detail=================");
					System.out.println("Employee ID: "+laptop2.getEmployee().getEmployeeId());
					System.out.println("Employee Name: "+laptop2.getEmployee().getEmployeeName());
					System.out.println("Employee Email: "+laptop2.getEmployee().getEmployeeEmail());
					System.out.println(" ");
					
					
				}
			}break;
			
			case 6:{
				System.out.println("System close successfully");
				System.exit(ch);
			}break;
			
			default:{
				System.out.println("Invalid Choice......");
			}
		   }
		}	
	}
}
