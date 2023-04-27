package hibernate_many_to_many_uni_morning.controller;

import java.util.Scanner;

import hibernate_many_to_many_uni_morning.dto.Teacher;
import hibernate_many_to_many_uni_morning.service.TeacherService;

public class TeacherController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TeacherService teacherService = new TeacherService();
		
		while(true) {
			System.out.println("Enter your choice");
			System.out.println("1. Insert");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				Teacher teacher = new Teacher();
				System.out.println("Enter teacherId");
				teacher.setTeacherId(sc.nextInt());
				System.out.println("Enter teacherName");
				teacher.setTeacherName(sc.next());
				System.out.println("Enter teacherEmail");
				teacher.setTeacherEmail(sc.next());
				System.out.println("Enter teacherYOE");
				teacher.setTeacharYOE(sc.nextInt());
				
				System.out.println("Enter studentId");
				int studentId = sc.nextInt();
				
				teacherService.insertTeacher(teacher, studentId);
			}break;
			
			}
		}
	}
}
