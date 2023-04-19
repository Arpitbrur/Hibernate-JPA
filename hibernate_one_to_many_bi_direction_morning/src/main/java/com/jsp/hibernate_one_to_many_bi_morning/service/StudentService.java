package com.jsp.hibernate_one_to_many_bi_morning.service;

import java.util.List;

import com.jsp.hibernate_one_to_many_bi_morning.dao.StudentDao;
import com.jsp.hibernate_one_to_many_bi_morning.dto.Student;

public class StudentService {

	StudentDao dao = new StudentDao();
	
	// insert method
		public void insertStudent(Student student) {
			dao.insertStudent(student);
		}
		
		// Search by id
		public Student searchStudent(int studentId) {
			return dao.searchStudent(studentId);
		}
		
		//update method
		public void updateStudent(Student student) {
			dao.updateStudent(student);
		}
		
		// delete method
		public void deleteStudent(int studentId) {
			dao.deleteStudent(studentId);
		}
		
		//display method
		public List<Student> displayStudent(){
			return dao.displayStudent();
		}
}
