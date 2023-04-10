package com.jsp.hibernate_one_to_one_bi_direction_morning.service;

import java.util.List;

import com.jsp.hibernate_one_to_one_bi_direction_morning.dao.LaptopDao;
import com.jsp.hibernate_one_to_one_bi_direction_morning.dto.Laptop;

public class LaptopService {

	LaptopDao dao = new LaptopDao();
	
	// insert method
		public void insertLaptop(Laptop laptop) {
			dao.insertLaptop(laptop);
		}
		
		//getByID
		public Laptop getByIDLaptop(int laptopId) {
			return dao.getByIDLaptop(laptopId);
		}
		
		// update Method
		public void updateLaptop(Laptop laptop) {
			dao.updateLaptop(laptop);
		}
		
		//delete Method
		public void deleteLaptop(int laptopId) {
			dao.deleteLaptop(laptopId);
		}
		
		// display method
		public List<Laptop> displayAllLaptop(){
			return dao.displayAllLaptop();
		}
}
