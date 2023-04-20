package com.jsp.hibernate_one_to_many_bi_morning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_one_to_many_bi_morning.dto.Student;
import com.jsp.hibernate_one_to_many_bi_morning.dto.Subject;
import com.jsp.hibernate_one_to_many_bi_morning.service.SubjectService;

public class SubjectController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SubjectService subjectService = new SubjectService();
		while(true) {
			System.out.println("Enter your choice");
			System.out.println("1. Insert\n2. Search\n3. Update\n4. Delete\n5. Display\n6. Exit");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				Subject subject = new Subject();
				System.out.println("=============Enter first Subject Details==========");
				System.out.println("Enter SubjectName");
				subject.setSubjectName(sc.next());
				System.out.println("Enter SubjectPrice");
				subject.setSubjectPrice(sc.nextDouble());
				System.out.println("Enter SubjectAuthor");
				subject.setSubjectAuthor(sc.next());
				
				
				Subject subject1 = new Subject();
				System.out.println("=============Enter second Subject Details==========");
				System.out.println("Enter SubjectName");
				subject1.setSubjectName(sc.next());
				System.out.println("Enter SubjectPrice");
				subject1.setSubjectPrice(sc.nextDouble());
				System.out.println("Enter SubjectAuthor");
				subject1.setSubjectAuthor(sc.next());
				
				System.out.println("=============Enter Subject Details==========");
				Student student = new Student();
				System.out.println("Enter StudentName");
				student.setStudentName(sc.next());
				System.out.println("Enter StudentEmail");
				student.setStudentEmail(sc.next());
				
				subject.setStudent(student);
				subject1.setStudent(student);
				
				List<Subject> list = new ArrayList<Subject>();
				list.add(subject);
				list.add(subject1);
				
				subjectService.insertSubject(list);
				
			}break;
			
			case 2:{
				System.out.println("Enter SubjectId which you want to fetching");
				int subjectId = sc.nextInt();
				Subject subject = subjectService.searchSubject(subjectId);
				if(subject !=null) {
				System.out.println("============Subject Details=============");
				System.out.println("subjectId: "+subject.getSubjectId());
				System.out.println("subjectName: "+subject.getSubjectName() );
				System.out.println("subjectAuthor: "+subject.getSubjectAuthor());
				System.out.println("subjectPrice: "+subject.getSubjectPrice());
				System.out.println(" ");
				
				System.out.println("============Subject Details=============");
				System.out.println("StudentId: "+subject.getStudent().getStudentId());
				System.out.println("StuentName: "+subject.getStudent().getStudentName());
				System.out.println("StudentEmail: "+subject.getStudent().getStudentEmail());
				System.out.println(" ");
				}else {
					System.out.println("Data not found in database");
				}

			}break;
			
			case 3:{
				Subject subject = new Subject();
				System.out.println("==============Enter Subject Details==============");
				System.out.println("Enter SubjectId: ");
				subject.setSubjectId(sc.nextInt());
				System.out.println("Enter SubjectNAme:");
				subject.setSubjectName(sc.next());
				System.out.println("Enter Subject Author");
				subject.setSubjectAuthor(sc.next());
				System.out.println("Enter Subject Price");
				subject.setSubjectPrice(sc.nextDouble());
				
				System.out.println("=============Enter  Student details");
				Student student = new Student();
				System.out.println("Enter Student Id");
				student.setStudentId(sc.nextInt());
				System.out.println("Enter Student NAme");
				student.setStudentName(sc.next());
				System.out.println("Enter Student Email");
				student.setStudentEmail(sc.next());
				
				subject.setStudent(student);
				subjectService.updateSubject(subject);
				
			}break;
			
			case 4:{
				System.out.println("Enter subject Id you want to deleted");
				subjectService.deleteSubject(sc.nextInt());
			}break;
			
			case 5:{
				List<Subject> list = subjectService.displaySubject();
				if(list != null) {
					for (Subject subject : list) {
						System.out.println("==============Subject Detail============== ");
						System.out.println("Subject ID:" +subject.getSubjectId());
						System.out.println("SubjectName: "+subject.getSubjectName());
						System.out.println("SubjectAuthor: "+subject.getSubjectAuthor());
						System.out.println("SubjectPrice: "+subject.getSubjectPrice());
						System.out.println("===============Student Details==================");
						System.out.println("Student Id: "+subject.getStudent().getStudentId());
						System.out.println("Student Name:"+subject.getStudent().getStudentName());
						System.out.println("Student Emails: "+subject.getStudent().getStudentEmail());
						System.out.println(" ");
						
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
				System.out.println("Invalid Choice");
			}
			}
		}
		 
	}
}
