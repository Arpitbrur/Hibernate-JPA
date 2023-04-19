package com.jsp.hibernate_one_to_many_bi_morning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_one_to_many_bi_morning.dto.Student;
import com.jsp.hibernate_one_to_many_bi_morning.dto.Subject;
import com.jsp.hibernate_one_to_many_bi_morning.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService studentService = new StudentService();
		
		while(true) {
			System.out.println("Enter your choice");
			System.out.println("1. Insert\n2. Search\n3. Update\n4. Delete\n5. Display\n6. Exit");
			int ch =sc.nextInt();
			switch(ch) {
			case 1:{
				Student student = new Student();
				System.out.println("==============Enter Student Detail=========");
				System.out.println("Enter StudentName: ");
				student.setStudentName(sc.next());
				System.out.println("Enter StudentEmail");
				student.setStudentEmail(sc.next());
				System.out.println(" ");
				
				System.out.println("==============Enter first Subject Detail=========");
				Subject subject = new Subject();
				System.out.println("Enter Subject Name");
				subject.setSubjectName(sc.next());
				System.out.println("Enter Subject Author");
				subject.setSubjectAuthor(sc.next());
				System.out.println("Enter Subject Price");
				subject.setSubjectPrice(sc.nextDouble());
				
				System.out.println("==============Enter second Subject Detail=========");
				Subject subject1 = new Subject();
				System.out.println("Enter Subject Name");
				subject1.setSubjectName(sc.next());
				System.out.println("Enter Subject Author");
				subject1.setSubjectAuthor(sc.next());
				System.out.println("Enter Subject Price");
				subject1.setSubjectPrice(sc.nextDouble());
				
				List<Subject> list = new ArrayList<Subject>();
				list.add(subject);
				list.add(subject1);
				student.setSubject(list);
				studentService.insertStudent(student);
			}break;
			
			case 2:{
				System.out.println("Student id you want to fetch");
				int studentid = sc.nextInt();
				Student student = studentService.searchStudent(studentid);
				if(student != null) {
				System.out.println("===========Student details=============");
				System.out.println("StudentID:" +student.getStudentId());
				System.out.println("StudentName: "+student.getStudentName());
				System.out.println("Student Email: "+student.getStudentEmail());
				
				System.out.println("===========Subject details=============");
				List<Subject> subjects = student.getSubject();
				for (Subject subject : subjects) {
					System.out.println("SubjectID: "+subject.getSubjectId());
					System.out.println("SubjectName:" +subject.getSubjectName());
					System.out.println("SubjectPrice:" +subject.getSubjectPrice());
					System.out.println("SubjectAuthor:" +subject.getSubjectAuthor());
					System.out.println(" ");
				}
				
			  }else {
				  System.out.println("Student id is not found");
			  }
			}break;
			
			case 3:{
				Student student = new Student();
				System.out.println("==============Enter Student Detail=========");
				System.out.println("Enter StudentId: ");
				student.setStudentId(sc.nextInt());
				System.out.println("Enter StudentName: ");
				student.setStudentName(sc.next());
				System.out.println("Enter StudentEmail");
				student.setStudentEmail(sc.next());
				System.out.println(" ");
				
				System.out.println("==============Enter first Subject Detail=========");
				Subject subject = new Subject();
				System.out.println("Enter Subject Id");
				subject.setSubjectId(sc.nextInt());
				System.out.println("Enter Subject Name");
				subject.setSubjectName(sc.next());
				System.out.println("Enter Subject Author");
				subject.setSubjectAuthor(sc.next());
				System.out.println("Enter Subject Price");
				subject.setSubjectPrice(sc.nextDouble());
				
				System.out.println("==============Enter second Subject Detail=========");
				Subject subject1 = new Subject();
				System.out.println("Enter Subject Name");
				subject1.setSubjectName(sc.next());
				System.out.println("Enter Subject Author");
				subject1.setSubjectAuthor(sc.next());
				System.out.println("Enter Subject Price");
				subject1.setSubjectPrice(sc.nextDouble());
				
				List<Subject> list = new ArrayList<Subject>();
				list.add(subject);
				list.add(subject1);
				student.setSubject(list);
				studentService.updateStudent(student);
			
			}break;
			
			case 4:{
				System.out.println("Enter Student Id you want you delete");
				studentService.deleteStudent(sc.nextInt());
			}break;
			
			case 5:{
				List<Student> list = studentService.displayStudent();
				if(list != null) {
					for (Student student : list) {
						System.out.println("===============Student Detail==============");
						System.out.println("StudentId: "+student.getStudentId());
						System.out.println("StudentName: "+student.getStudentName());
						System.out.println("StudentEmail: "+student.getStudentEmail());
						
						System.out.println("=================Subject Detail==============");
						List<Subject> subjects = student.getSubject();
						for (Subject subject: subjects) {
							System.out.println("SubjectId: "+subject.getSubjectId());
							System.out.println("SubjectName: "+subject.getSubjectName());
							System.out.println("SubjectAuthor: "+subject.getSubjectAuthor());
							System.out.println("SubjectPrice: "+subject.getSubjectPrice());
							System.out.println(" ");
						}
					}
				}else {
					System.out.println("table is empty in database");
				}
			}break;
			
			case 6:{
				System.out.println("System closed");
				System.exit(ch);
			}break;
			
			default:{
				System.out.println("Invalid choice");
			}
			}
			
		}
	}
}
