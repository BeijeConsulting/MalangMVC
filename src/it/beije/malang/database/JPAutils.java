package it.beije.malang.database;

import java.io.IOException;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.beije.malang.database.entities.Contatto;
import it.beije.malang.database.entities.Indirizzo;
import it.beije.malang.database.entities.Utente;


public class JPAutils {
	
	public static void main(String argv[]) throws IOException {
		//Con EntityManager si apre la sessione e si fa la configurazione con le classi in automatico, quello che si fa separatamente con le annotation in hibernate 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Malang");
		EntityManager entityManager = factory.createEntityManager();
		
		int id = 2;

		Utente u = entityManager.find(Utente.class, id);//find carica l'id di un certo contatto nella tabella rubrica del db
		System.out.println("Utente : " + u.getNome());
		System.out.println("Utente indirizzi : " + u.getIndirizzi());
	
		//ciclo per pescare gli indirizzi di tutti gli utenti. getIndirizzi() è presente nel bin Indirizzo.java
		for (Indirizzo i : u.getIndirizzi()) {
			System.out.println("id : " + i.getId());
			System.out.println("cap : " + i.getCap());
			System.out.println("citta : " + i.getCitta());
			System.out.println("prov : " + i.getProvincia());
		}
		
		
            //Crea un nuovo oggetto utente e setta i suoi parametri tramite i vari metodi dentro il bin Utente.java
////		Utente u = new Utente();
////		u.setCognome("Ferulli");
////		u.setNome("Marina3");
////		u.setEmail("marina3@ferulli.it");
		
		//Crea un nuovo oggetto indirizzo e setta i suoi parametri tramite i vari metodi dentro il bin Indirizzo.java
//		Indirizzo indirizzo = new Indirizzo();
//		indirizzo.setCap("20100");
//		indirizzo.setCitta("Milano");
//		indirizzo.setProvincia("MI");
//		indirizzo.setTelefono("23224");
//						
//		entityManager.getTransaction().begin(); //apre la transazione
//
//		System.out.println("Utente id : " + u.getId());
//		entityManager.persist(u); // Persist takes an entity instance, adds it to the context and makes that instance managed (ie future updates to the entity will be tracked)
//		System.out.println("Utente id : " + u.getId());
//		entityManager.getTransaction().commit();

		entityManager.close();

	}
	
}