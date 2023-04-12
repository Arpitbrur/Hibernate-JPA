package hibernate_many_to_one_uni_morning.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hibernate_many_to_one_uni_morning.dto.Competition;
import hibernate_many_to_one_uni_morning.dto.Teams;
import hibernate_many_to_one_uni_morning.service.TeamsService;

public class TeamsController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TeamsService teamsService = new TeamsService();
		
		while(true) {
			System.out.println("Enter your choice");
			System.out.println("1.insert\n2. Search\n3. Delete");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				Teams teams = new Teams();
				System.out.println("=================Enter First Team==============");
				System.out.println("Enter team Name");
				teams.setTeamName(sc.next());
				System.out.println("Enter team Coach");
				teams.setTeamCoach(sc.next());
				System.out.println("Enter teamCAption");
				teams.setTeamCaption(sc.next());
				System.out.println("Enter team Size");
				teams.setTeamsize(sc.nextInt());
				
				System.out.println("==================Enter Second Team==============");
				Teams teams1 = new Teams();
				System.out.println("Enter team Name");
				teams1.setTeamName(sc.next());
				System.out.println("Enter team Coach");
				teams1.setTeamCoach(sc.next());
				System.out.println("Enter teamCAption");
				teams1.setTeamCaption(sc.next());
				System.out.println("Enter team Size");
				teams1.setTeamsize(sc.nextInt());
				
				System.out.println("===================Enter Competition Detail=================");
				Competition competition = new Competition();			
				System.out.println("Enter Competition Name");
				competition.setComprtitionName(sc.next());
				System.out.println("Enter Competition Year");
				int year = LocalDateTime.now().getYear();
				competition.setCompetitionYear(year);
				System.out.println("Enter Competition Chairman");
				competition.setCompetitionChairman(sc.next());
				System.out.println("Enter Cmpetiton Sponser Name");
				competition.setSponsersName(sc.next());
				
				teams.setCompetition(competition);
				teams1.setCompetition(competition);
				
				List<Teams> list = new ArrayList<Teams>();
				list.add(teams);
				list.add(teams1);
				teamsService.insertTeams(list);
			}break;
			
			case 2:{
				System.out.println("Enter team ID");
				int teamsId = sc.nextInt();
				
				Teams teams = teamsService.searchTeams(teamsId);
				System.out.println("==========Teams Detail========");
				if(teams != null) {
					System.out.println("teamdId:"+teams.getTeamId());
					System.out.println("teamsName: "+ teams.getTeamName());
					System.out.println("teamsCoach: "+ teams.getTeamCoach());
					System.out.println("teamsCaption: "+ teams.getTeamCaption());
					System.out.println("teamsSize: "+ teams.getTeamsize());
					
					
					System.out.println("===============Competition Detail===========");
					System.out.println("CompetitonId: "+ teams.getCompetition().getCompetitionId());
					System.out.println("CompetitonName: "+teams.getCompetition().getComprtitionName());
					System.out.println("CompetitonYear: "+teams.getCompetition().getCompetitionYear());
					System.out.println("CompetitionSponser: "+ teams.getCompetition().getSponsersName());
					System.out.println("CompetitonChairman: "+ teams.getCompetition().getCompetitionChairman());
					
				}else {
					System.out.println("Invalid teamsId please check again");
				}
			}break;
			
//			case 3:{
//				System.out.println("Enter teamid");
//				teamsService.deleteTeams(sc.nextInt());
//				
//              }
			}
		}
	}

}
