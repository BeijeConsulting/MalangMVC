package it.beije.controller.bean;

import java.io.IOException;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.beije.controller.bean.User;
import it.beije.controller.bean.Personalcomputer;
import it.beije.controller.bean.Usercomputer;

public class Connesssiondba {
public static void main(String argv[]) throws IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		


		int id = 1;// stampo a video il nome dell ID che corrisponde tab.rubrica
		User c = entityManager.find(User.class, id);


		int id1 = 1 ;
		Personalcomputer u = entityManager.find(Personalcomputer.class, id);
		

		


		System.out.println("Contatto : " + c.getNome());
         
		User u1 = new User();
		u1.setCognome("Verdi");
		u1.setEmail("paolino@ferulli.it");
		u1.setNome("paolino");
		
		entityManager.getTransaction().begin();

		System.out.println("Utente id : " + u1.getId());
		entityManager.persist(u);
		System.out.println("Utente id : " + u1.getId());
		entityManager.getTransaction().commit();

		System.out.println("Utente : " + u1.getNome());
		

	
	


		entityManager.close();

	}
	
}
