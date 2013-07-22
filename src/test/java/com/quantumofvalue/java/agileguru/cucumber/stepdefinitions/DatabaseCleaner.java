package com.quantumofvalue.java.agileguru.cucumber.stepdefinitions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("databaseCleaner")
@Repository
@Transactional
public class DatabaseCleaner {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void truncate() {
		Query truncateQuery = em.createNativeQuery("truncate item");
		truncateQuery.executeUpdate();
		em.flush();
	}
}
