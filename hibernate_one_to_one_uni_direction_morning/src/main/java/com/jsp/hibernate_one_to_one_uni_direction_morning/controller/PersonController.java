package com.jsp.hibernate_one_to_one_uni_direction_morning.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_one_to_one_uni_direction_morning.dto.Passport;
import com.jsp.hibernate_one_to_one_uni_direction_morning.dto.Person;
import com.jsp.hibernate_one_to_one_uni_direction_morning.service.PersonService;

public class PersonController {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		Person person = new Person();
		Passport passport = new Passport();
		
		PersonService personService = new PersonService();
		while(true) {
			System.out.println("Entrt your choice");
			System.out.println("1. Insert\n2. GetById\n3. Delete\n4. Update\n5. Display\n.6 Exit");
			
			int ch= sc.nextInt();
			switch (ch) {
			case 1:{
				System.out.println("==================Person Detail==================");
				System.out.println("Enter the personId");
				person.setPersonId(sc.nextInt());
				System.out.println("Enter the personName");
				person.setPersonName(sc.next());
				System.out.println("Enter the personAge");
				person.setPersonAge(sc.nextInt());
				
				System.out.println("==================Passport Detail==================");
				System.out.println("Enter the passportId");
				passport.setPassportId(sc.nextInt());
				System.out.println("Enter the passportColor");
				passport.setPassportColor(sc.next());
				System.out.println("Entr the passportType");
				passport.setPassportType(sc.next());
				
				person.setPassport(passport);
				personService.insertPerson(person, passport);
				
			 }break;
			
			case 2:{
				System.out.println("Enter the PersonId for fetching");
				
			Person person1 =	personService.getbyidperson(sc.nextInt());
				if(person != null) {
					System.out.println("==================Person Detail==================");
					System.out.println("personId: "+ person1.getPersonId());
					System.out.println("personName: "+ person1.getPersonName());
					System.out.println("personAge: "+ person1.getPersonAge());
					
					System.out.println("==================Passport Detail==================");
					System.out.println("passportId: "+ person1.getPassport().getPassportId());
					System.out.println("passportColor: "+ person1.getPassport().getPassportColor());
					System.out.println("passportType: "+ person1.getPassport().getPassportType());
					System.out.println("LocalDateTime: " + person1.getPassport().getDateTime());
					System.out.println(" ");
				}else {
					System.out.println(" Id id not present in database or already has been deleted");
				}
				
			}break;
			
			case 3:{
				System.out.println("Enter the personID you want to delete");
				personService.deletePersonPassport(sc.nextInt());
				
			}break;
			
			case 4:{
				System.out.println("==================Person Detail==================");
				System.out.println(" Enter the personId");
				int id= sc.nextInt();
				System.out.println(" Enter the personName");
				String name= sc.next();
				System.out.println(" Enter the personAge");
				int age= sc.nextInt();
				
				System.out.println("==================Paasport Detail==================");
				System.out.println("Enter the passportColor");
				String color= sc.next();
				System.out.println("Enter the passportType");
				String type = sc.next();
				
				person.setPassport(passport);
				personService.updatePerson(id, name, age, color, type);
				
			}break;
			
			case 5:{
				
				List<Person> list = personService.dispalyPerson();
				for (Person display : personService.dispalyPerson()) {
					System.out.println("================Person detail==============");
					System.out.println("PersonID: "+ display.getPersonId());
					System.out.println("PersonName: "+ display.getPersonName());
					System.out.println("PersonAge: "+ display.getPersonAge());
					System.out.println("================Passport detail==============");
					System.out.println("Passportid: "+ display.getPassport().getPassportId());
					System.out.println("PassportColor: "+display.getPassport().getPassportColor());
					System.out.println("PaasportType: "+ display.getPassport().getPassportType());
					System.out.println(" ");
				}	
			}	break;
				
			case 6:{
				System.out.println(" System Close Successfully.......");
				System.exit(ch);
				
			}break;
				
			default:{
				System.out.println("Invalid choice please try again");
			}
			
			}
				 
		   }
	   }	
		
	}

