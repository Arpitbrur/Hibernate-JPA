package hibernate_many_to_many_uni_morning.service;

import hibernate_many_to_many_uni_morning.dao.StudentDao;
import hibernate_many_to_many_uni_morning.dto.Student;

public class StudentService {

	StudentDao dao = new StudentDao();
	
	// insert method
		public void insertStudent(Student student) {
			dao.insertStudent(student);
		}
}
