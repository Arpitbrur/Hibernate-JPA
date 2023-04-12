package hibernate_many_to_one_uni_morning.service;

import java.util.List;

import hibernate_many_to_one_uni_morning.dao.TeamsDao;
import hibernate_many_to_one_uni_morning.dto.Teams;

public class TeamsService {

	TeamsDao dao = new TeamsDao();
	
	// insert method
		public void insertTeams(List<Teams> list) {
			dao.insertTeams(list);
		}
		
		// SearchTeam method 
		public Teams searchTeams(int teamId) {
			return dao.searchTeams(teamId);
		}
		
		// delete method
//		public void deleteTeams(int teamsId) {
//		Teams teams= dao.searchTeams(teamsId);
//		if(teams != null) {
//			dao.deleteTeams(teamsId);
//		}else {
//			System.out.println("teamID is not present in database");
//		}
//		}
}
