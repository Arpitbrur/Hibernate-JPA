package hibernate_many_to_one_uni_morning.controller;

import java.time.LocalDateTime;
import java.util.Scanner;

import hibernate_many_to_one_uni_morning.dto.Competition;
import hibernate_many_to_one_uni_morning.service.CompetitionService;

public class CompetitionController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CompetitionService competitionService = new CompetitionService();
		while(true) {
			System.out.println("Enter your choice");
			System.out.println("1. Insert\n2. Search\n3. Update");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:{
				Competition competition = new Competition();
				System.out.println("Enter Competition Name");
				competition.setComprtitionName(sc.next());
				System.out.println("Enter COmpetition Year");
				int year =LocalDateTime.now().getYear();
				competition.setCompetitionYear(year);
				System.out.println("Enter Competition Sponser");
				competition.setSponsersName(sc.next());
				System.out.println("Enter CompetitionChairman");
				competition.setCompetitionChairman(sc.next());
		/*
		 * here we give @transient to CompetitionChairman in dto so in database no colume will 
		 * be create and no data will store in CompetitionChairman. It show competitionChairman is null.  
		 */		
				
				competitionService.insertCompetition(competition);
				
			}case 2:{
				System.out.println("enter CompetitonId");
				Competition competition = competitionService.searchCompetition(sc.nextInt());
				if(competition != null) {
					System.out.println("CompetitonId: "+competition.getCompetitionId());
					System.out.println("CompetitionName: "+competition.getComprtitionName());
					System.out.println("CompetitionYear: "+competition.getCompetitionYear());
					System.out.println("COmpetitionChairman: "+competition.getCompetitionChairman());
					System.out.println("CompetitionSponser: "+competition.getSponsersName());

				}else {
					System.out.println("this id is not present in database");
				}
			}break;
			
			case 3:{
				Competition competition = new Competition();
				
				System.out.println("Enter Competition Id");
				competition.setCompetitionId(sc.nextInt());
				System.out.println("Enter Competition Name");
				competition.setComprtitionName(sc.next());
				System.out.println("Enter COmpetition Year");
				int year =LocalDateTime.now().getYear();
				competition.setCompetitionYear(year);
				System.out.println("Enter Competition Sponser");
				competition.setSponsersName(sc.next());
				System.out.println("Enter CompetitionChairman");
				competition.setCompetitionChairman(sc.next());
				
				competitionService.updateCompetition(competition);
			}
			}
			
		}
	}
}
