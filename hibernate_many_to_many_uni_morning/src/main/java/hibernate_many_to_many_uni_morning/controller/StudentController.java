package hibernate_many_to_many_uni_morning.controller;

import java.util.Scanner;

import hibernate_many_to_many_uni_morning.dto.Student;
import hibernate_many_to_many_uni_morning.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService studentService = new StudentService();
		
		while(true) {
			System.out.println("Enter your choice");
			System.out.println("1.Insert");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				Student student = new Student();
				System.out.println("==========Student Details===========");
				System.out.println("Enter Student Id");
				student.setStudentId(sc.nextInt());
				System.out.println("Enter Student Name");
				student.setStudentName(sc.next());
				System.out.println("Enter Student email");
				student.setStudentEmail(sc.next());
				System.out.println("Enter Student branch");
				student.setStudentbranch(sc.next());
				
				
			}
			}
		}
	}
}
