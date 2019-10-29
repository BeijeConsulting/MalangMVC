package it.beije.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.beije.controller.bean.Assignment;
import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Utente;

public class RegDB {
	
	public static void regUser(Utente utente) {
		
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(utente);
			entityManager.getTransaction().commit();
				      
			entityManager.close();
				    }
				    catch (Exception e)
				    {
				      System.err.println("Got an exception!");
				      System.err.println(e.getMessage());
				    }
				  }
	public static void regComputer(Computer computer) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(computer);
			entityManager.getTransaction().commit();
				      
			entityManager.close();
				    }
				    catch (Exception e)
				    {
				      System.err.println("Got an exception!");
				      System.err.println(e.getMessage());
				    }
				  }

	
	public static void regAssignment(Assignment assignment) {
		
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(assignment);
			entityManager.getTransaction().commit();
				      
			entityManager.close();
				    }
				    catch (Exception e)
				    {
				      System.err.println("Got an exception!");
				      System.err.println(e.getMessage());
				    }
				  }
}