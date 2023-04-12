package hibernate_many_to_one_uni_morning.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="IndianCompetition")
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Competition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int competitionId;
	@Column(nullable = false)
	private String comprtitionName;
	private int competitionYear;
	private String sponsersName;
	@Transient
	private String competitionChairman;
	
	
	
}
