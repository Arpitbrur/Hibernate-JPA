package com.jsp.hibernate_one_to_one_bi_direction_morning.service;

import java.util.List;

import com.jsp.hibernate_one_to_one_bi_direction_morning.dao.EmployeeDao;
import com.jsp.hibernate_one_to_one_bi_direction_morning.dto.Employee;

public class EmployeeService {

	EmployeeDao dao = new EmployeeDao();
	
	// Insert Method
		public void insertEmployee(Employee employee) {
			dao.insertEmployee(employee);
		}
		
		//getById Method
		public Employee getByIdEmployee(int employeeId) {
			return dao.getByIdEmployee(employeeId);
		}
		
		// Update Method
		public void updateEmployee(Employee employee) {
			dao.updateEmployee(employee);
		}
		
		// delete Method
		public void deleteEmployee(int employeeId) {
			dao.deleteEmployee(employeeId);
		}
		
		// display method
		public List<Employee> displayAllEmployee(){
			return dao.displayAllEmployee();
		}
}
