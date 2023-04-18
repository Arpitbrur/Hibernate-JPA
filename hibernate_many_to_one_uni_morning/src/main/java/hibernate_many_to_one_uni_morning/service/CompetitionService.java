package hibernate_many_to_one_uni_morning.service;

import java.util.List;

import hibernate_many_to_one_uni_morning.dao.CompetitionDao;
import hibernate_many_to_one_uni_morning.dto.Competition;

public class CompetitionService {

	CompetitionDao dao = new CompetitionDao();
	
	// insert method
		public void insertCompetition(Competition competition) {
			dao.insertCompetition(competition);
		}
		
		// Search method
		public Competition searchCompetition(int competitionId) {
			return dao.searchCompetition(competitionId);
		}
		
		// update method
		public void updateCompetition(Competition competition) {
			dao.updateCompetition(competition);
		}
		
		// delete method
		public void deleteCompetition(int CompetitionId) {
			dao.deleteCompetition(CompetitionId);
		}
		
		// display method
		public List<Competition> displayCompetition() {
			return dao.displayCompetition();
		}
}
