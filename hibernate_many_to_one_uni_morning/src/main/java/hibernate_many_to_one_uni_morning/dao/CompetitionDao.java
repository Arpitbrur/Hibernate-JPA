package hibernate_many_to_one_uni_morning.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_many_to_one_uni_morning.dto.Competition;

public class CompetitionDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	// insert method
	public void insertCompetition(Competition competition) {
		entityTransaction.begin();
		entityManager.persist(competition);
		entityTransaction.commit();
		
		System.out.println("Data Inserted");
	}
	
	// Search method
	public Competition searchCompetition(int competitionId) {
		Competition competition = entityManager.find(Competition.class, competitionId);
		
		return competition;
	}
	
	// update method
	public void updateCompetition(Competition competition) {
		
		entityTransaction.begin();
		entityManager.merge(competition);
		entityTransaction.commit();
		
		System.out.println("Data Updated");
	}
}
