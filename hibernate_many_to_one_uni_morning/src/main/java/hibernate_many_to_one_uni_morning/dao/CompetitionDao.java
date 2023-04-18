package hibernate_many_to_one_uni_morning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	// delete method
	public void deleteCompetition(int CompetitionId) {
		Competition competition = entityManager.find(Competition.class, CompetitionId);
		if(competition != null) {
			entityTransaction.begin();
			entityManager.remove(competition);
			entityTransaction.commit();
			
			System.out.println("Data Deleted");
		}else {
			System.out.println("Competition ID is not found in database ");
		}
	}
	
	// display method
	public List<Competition> displayCompetition() {
		
		String select = "SELECT c FROM Competition c";
		
		Query query = entityManager.createQuery(select);
		return query.getResultList();
	}
}
