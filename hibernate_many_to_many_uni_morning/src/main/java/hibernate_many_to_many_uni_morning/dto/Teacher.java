package hibernate_many_to_many_uni_morning.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Teacher {
	
	@Id
	private int teacherId;
	private String teacherName;
	private String teacherEmail;
	private int teacharYOE;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	private List<Student> student;
}
