package hibernate_many_to_one_uni_morning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_one_uni_morning.dto.Teams;


public class TeamsDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	// insert method
	public void insertTeams(List<Teams> list) {
		for (Teams teams : list) {
			entityTransaction.begin();
			entityManager.persist(teams);
			entityTransaction.commit();	
		}
		System.out.println("Data Inserted");
	}
	
	// SearchTeam method 
	public Teams searchTeams(int teamId) {
		Teams teams = entityManager.find(Teams.class, teamId);
		return teams;
	}
	
	// delete method
//	public void deleteTeams(int teamsId) {
//		Teams teams = entityManager.find(Teams.class, teamsId);
//		entityTransaction.begin();
//		entityManager.remove(teams);
//		entityTransaction.commit();
//		
//		System.out.println("Data deleted");
//	}
	
	
}
