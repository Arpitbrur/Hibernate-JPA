package com.jsp.hibernate_one_to_one_bi_direction_morning.Controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_one_to_one_bi_direction_morning.dto.Employee;
import com.jsp.hibernate_one_to_one_bi_direction_morning.dto.Laptop;
import com.jsp.hibernate_one_to_one_bi_direction_morning.service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		Employee employee = new Employee();
		Laptop laptop = new Laptop();
		
		EmployeeService employeeService= new EmployeeService();
		
		while(true) {
			System.out.println("Enter your Choice ");
			System.out.println("1. Insert\n2. GetById\n3. Update\n4. Delete\n5. Display\n6. Exit");
			
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				System.out.println("=============Employee Detail===============");
				System.out.println("Enter employee Id");
				employee.setEmployeeId(sc.nextInt());
				System.out.println("Employee Name");
				employee.setEmployeeName(sc.next());
				System.out.println("Employee Email");
				employee.setEmployeeEmail(sc.next());
				
				System.out.println("=============laptop Detail===============");
				System.out.println("Enter Laptop Id ");
				laptop.setLaptopId(sc.nextInt());
				System.out.println("Enter Laptop Color ");
				laptop.setLaptopColor(sc.next());
				System.out.println("Enter laptop Price");
				laptop.setLaptopPrice(sc.nextDouble());
				
				employee.setLaptop(laptop);
				employeeService.insertEmployee(employee);
			}break;
			
			case 2:{
				System.out.println("Enter the EmployeeId for fetching");
				Employee employee1 = employeeService.getByIdEmployee(sc.nextInt());
				
				if(employee1 != null) {
				System.out.println("=============Employee Detail===============");			
				System.out.println("EmployeeID: "+ employee1.getEmployeeId());
				System.out.println("EmployeeNAme: "+employee1.getEmployeeName());
				System.out.println("EmployeEmail: "+employee1.getEmployeeEmail());
				System.out.println("=============laptop Detail===============");
				System.out.println("Laptop Id: "+employee1.getLaptop().getLaptopId());
				System.out.println("LaptopColor: "+employee1.getLaptop().getLaptopColor());
				System.out.println("Laptop Price: "+employee1.getLaptop().getLaptopPrice());
				}else {
					System.out.println(" Id id not present in database or already has been deleted");
				}
			}break;
			
			case 3:{
				System.out.println("=============Employee Detail===============");
				System.out.println("Enter employee Id");
				employee.setEmployeeId(sc.nextInt());
				System.out.println("Employee Name");
				employee.setEmployeeName(sc.next());
				System.out.println("Employee Email");
				employee.setEmployeeEmail(sc.next());
				
				System.out.println("=============laptop Detail===============");
				System.out.println("Enter Laptop Id ");
				laptop.setLaptopId(sc.nextInt());
				System.out.println("Enter Laptop Color ");
				laptop.setLaptopColor(sc.next());
				System.out.println("Enter laptop Price");
				laptop.setLaptopPrice(sc.nextDouble());
				
				employee.setLaptop(laptop);
				employeeService.updateEmployee(employee);
			}break;
			
			case 4:{
				System.out.println("Enter the EmployeeID which want you deleted");
				employeeService.deleteEmployee(sc.nextInt());
			}break;
			
			
			case 5:{
				List<Employee> list = employeeService.displayAllEmployee();
				for(Employee emp :list) {
					System.out.println("==============Employee Detail=============");
					System.out.println("EmployeeId: "+emp.getEmployeeId());
					System.out.println("employeeName: "+emp.getEmployeeName());
					System.out.println("EmployeeEmail: "+emp.getEmployeeEmail());
					System.out.println("==============Laptop detail================");
					System.out.println("Laptop Id: "+emp.getLaptop().getLaptopId());
					System.out.println("laptopColor: "+emp.getLaptop().getLaptopColor());
					System.out.println("Laptop Price: "+emp.getLaptop().getLaptopPrice());
					System.out.println(" ");
				}
			}break;
			
			case 6:{
				System.out.println("System Closed");
				System.exit(ch);
			}break;
			
			default:{
				System.out.println("Invalid Choice......");
			}
			}
		}
		
	}
}
