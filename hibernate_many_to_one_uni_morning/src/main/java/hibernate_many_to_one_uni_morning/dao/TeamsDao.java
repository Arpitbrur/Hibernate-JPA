package hibernate_many_to_one_uni_morning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	/*
	 *Here delete method cannot delete the competition who are mapped with more
	 *than one teams because this project has many to one uni direction flow, so
	 *from competition entity class compiler cannot select next teams which is mapped 
	 *with competition class. so this is limitation of delete method for many to
	 *one uni direction. 
	 */
	
	// delete method
	public void deleteTeams(int teamsId) {
		Teams teams = entityManager.find(Teams.class, teamsId);
		entityTransaction.begin();
		entityManager.remove(teams);
		entityTransaction.commit();
		
		System.out.println("Data deleted");
	}
	
	
	// update Method	
	public void updateTeams(Teams teams) {
		entityTransaction.begin();
		entityManager.merge(teams);
		entityTransaction.commit();
		
		System.out.println("Data updated");
	}
	
	// display method
	public List<Teams> displayTeams() {
		String select = "SELECT t FROM Teams t";
		Query query = entityManager.createQuery(select);
		return query.getResultList();
		
	}
}
