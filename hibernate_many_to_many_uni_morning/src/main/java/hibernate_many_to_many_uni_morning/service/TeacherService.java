package hibernate_many_to_many_uni_morning.service;

import hibernate_many_to_many_uni_morning.dao.TeacherDao;
import hibernate_many_to_many_uni_morning.dto.Teacher;

public class TeacherService {

	TeacherDao dao = new TeacherDao();
	
	// insert method
		public void insertTeacher(Teacher teacher, int studentId) {
			dao.insertTeacher(teacher, studentId);
		}
}
