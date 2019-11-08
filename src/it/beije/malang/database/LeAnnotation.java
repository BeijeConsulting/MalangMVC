package it.beije.malang.database;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import it.beije.malang.database.entities.Contatto;
import it.beije.malang.database.entities.Indirizzo;
import it.beije.malang.database.entities.Utente;


public class LeAnnotation {
	
	public static void main(String argv[]) throws Exception {
		
		Configuration configuration = new Configuration();
		configuration = configuration.configure()
				.addAnnotatedClass(Contatto.class)
				.addAnnotatedClass(Utente.class)
				.addAnnotatedClass(Indirizzo.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		System.out.println("is open?" + factory.isOpen());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "SELECT u FROM Utente as u";
		Query<Utente> query = session.createQuery(hql);
		for (Utente utente : query.list()) { //prende la lista dei contatti presente dentro la tabella rubrica su mysql db malang
			System.out.println("id : " + utente.getId());
			System.out.println("cognome : " + utente.getCognome());
			System.out.println("nome : " + utente.getNome());
			System.out.println("email : " + utente.getEmail());
		}
		
//		Criteria criteria = session.createCriteria(Contatto.class);
//		List<Contatto> contatti = criteria.list();//.add(Restrictions.eq("nome", "pippo"))
//
//		for (Contatto contatto : contatti) {
//			System.out.println("id : " + contatto.getId());
//			System.out.println("nome : " + contatto.getNome());
//			System.out.println("cognome : " + contatto.getCognome());
//			System.out.println("telefono : " + contatto.getTelefono());
//			System.out.println("email : " + contatto.getEmail());
//			
//			if (contatto.getNome().equals("Giuseppe")) {
//				contatto.setCognome("Rossi");
//			}
//		}
		
		
		//inserisce un nuovo utente dentro la tabella utente
		Utente utente = new Utente();
		utente.setCognome("Riccio");
		utente.setNome("gina");
		utente.setEmail("gina@riccio.it");
		

		System.out.println("id : " + utente.getId());
		session.save(utente);
		System.out.println("id : " + utente.getId());
		
		//inserisce un nuovo indirizzo dentro la tabella indirizzo
		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setIdUtente(utente.getId());
		indirizzo.setProvincia("MB");
		indirizzo.setCap("20900");
		indirizzo.setCitta("Monza");
		indirizzo.setIndirizzo("gina@riccio.it");
		indirizzo.setTelefono("3122123475");
		
		

		System.out.println("id : " + indirizzo.getId());
		session.save(indirizzo);
		System.out.println("id : " + indirizzo.getId());
		
		transaction.commit();
		session.close();
		factory.close();
		System.out.println("is open?" + factory.isOpen());
	}
}