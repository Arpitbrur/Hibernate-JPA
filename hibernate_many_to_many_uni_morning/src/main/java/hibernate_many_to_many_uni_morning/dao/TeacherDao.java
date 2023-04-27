package hibernate_many_to_many_uni_morning.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_many_uni_morning.dto.Student;
import hibernate_many_to_many_uni_morning.dto.Teacher;

public class TeacherDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	// insert method
	public void insertTeacher(Teacher teacher, int studentId) {
		Student student = entityManager.find(Student.class, studentId);
		List<Student> studentlist = new ArrayList<Student>();
		studentlist.add(student);
		
		if(student != null) {
			teacher.setStudent(studentlist);
			entityTransaction.begin();
			entityManager.persist(teacher);
			entityTransaction.commit();
			System.out.println("Data inserted");
		}
	}
}
