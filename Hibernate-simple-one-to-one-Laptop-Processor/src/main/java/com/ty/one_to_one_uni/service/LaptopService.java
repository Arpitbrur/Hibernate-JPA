package com.ty.one_to_one_uni.service;

import java.util.List;

import com.ty.one_to_one_uni.dao.LaptopDao;
import com.ty.one_to_one_uni.dto.Laptop;
import com.ty.one_to_one_uni.dto.Processor;

public class LaptopService {

	LaptopDao dao = new LaptopDao();
	//InsertMethod
	public void insertLaptopProcessor(Laptop laptop, Processor processor) {
		dao.insertLaptopProcessor(laptop, processor);
	}
	//UpdateMethod
	public void updateLaptopProcessor(int id, String name, String processorName, double price, String core, String speed) {
		dao.updateLaptopProcessor(id, name, processorName, price, core, speed);
	}
	//DeleteMethod
	public void deleteLaptopProcessor(int id) {
		dao.deleteLaptopProcessor(id);
	}
	//DisplayMethod
		public List<Laptop>DisplayLaptopProcessor(){
			 return dao.displayLaptop();

		}

}
