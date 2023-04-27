package hibernate_many_to_many_uni_morning.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
	
	@Id
	private int studentId;
	private String studentName;
	private String studentEmail;
	private String studentbranch;
	
	
	
}
