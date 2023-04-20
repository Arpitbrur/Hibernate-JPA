package com.jsp.hibernate_one_to_many_bi_morning.service;

import java.util.List;

import com.jsp.hibernate_one_to_many_bi_morning.dao.SubjectDao;
import com.jsp.hibernate_one_to_many_bi_morning.dto.Subject;

public class SubjectService {

	SubjectDao dao = new SubjectDao();
	
	// insert method
		public void insertSubject(List<Subject> list) {
				dao.insertSubject(list);
		}
		
		// search by id
		public Subject searchSubject(int subjectId) {
			return dao.searchSubject(subjectId);
		}
		
		// update method
		public void updateSubject(Subject subject) {
			dao.updateSubject(subject);
		}
		
		//delete method
		public void deleteSubject(int subjectId) {
			Subject subject = dao.searchSubject(subjectId);
			if(subject != null) {
				dao.deleteSubject(subjectId);
			}else {
				System.out.print("subjectid is not present");
				
			}
		}
		
		// display method
		public List<Subject> displaySubject(){
			return dao.displaySubject();
		}
}
