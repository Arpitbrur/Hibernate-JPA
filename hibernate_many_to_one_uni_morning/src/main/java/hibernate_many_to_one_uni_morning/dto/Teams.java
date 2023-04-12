package hibernate_many_to_one_uni_morning.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "myTeam")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teams {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamId;
	private String teamName;
	private String teamCaption;
	private int teamsize;
	private String teamCoach;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CompetitionId")
	
	private Competition competition;
	
	
	
}
