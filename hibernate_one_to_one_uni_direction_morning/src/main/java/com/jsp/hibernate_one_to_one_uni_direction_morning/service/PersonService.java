package com.jsp.hibernate_one_to_one_uni_direction_morning.service;

import java.util.List;

import com.jsp.hibernate_one_to_one_uni_direction_morning.dao.PersonDao;
import com.jsp.hibernate_one_to_one_uni_direction_morning.dto.Passport;
import com.jsp.hibernate_one_to_one_uni_direction_morning.dto.Person;

public class PersonService {

	PersonDao personDao = new PersonDao();
	// insert Method 
		public void insertPerson(Person person, Passport passport ) {
			personDao.insertPerson(person, passport);
			
		}
		
		
		// get By Id Method
		public Person getbyidperson(int personId) {
			if(personDao.getbyidperson(personId) != null) {
				return personDao.getbyidperson(personId);
			}else {
				return null;
			}
		}
	
		
		// deleted method
		public void deletePersonPassport(int personId) {
			Person person = personDao.getbyidperson(personId);
			if(person != null) {
				if(person.getPassport() != null) {
					if(person.getPersonId() == personId) {
						personDao.deletePersonPassport(personId);
					}else {
						System.out.println("personId is not present in database");
					}
						
					}else {
						System.out.println("Passport Number is  not available in database");
					}
				}else {
					System.out.println("person is null");
				}
			}
		
			
		
		// update method
		public void updatePerson(int personId, String personName, int personAge, String passportColor, String passportType) {
			personDao.updatePerson(personId, personName, personAge, passportColor, passportType);
		}
			
		// display Method
		public List<Person> dispalyPerson(){
			return personDao.dispalyPerson();
		}
}
