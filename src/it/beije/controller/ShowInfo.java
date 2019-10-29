package it.beije.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.beije.controller.bean.Assignment;
import it.beije.controller.bean.Utente;


public class ShowInfo {
	
	public static ArrayList<Assignment> list(int idutente) throws IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		int id = idutente;
		ArrayList<Assignment> list = new ArrayList<Assignment>();
		Utente u = entityManager.find(Utente.class, id);

		System.out.println("Utente pc : " + u.getComputer());
		int i = 0;
		for (Assignment a : u.getComputer()) {
			a.setConsegna(u.getComputer().get(i).getConsegna());
			a.setRestituzione(u.getComputer().get(i).getRestituzione());
			a.setId_utente(u.getComputer().get(i).getId_utente());
			a.setId_computer(u.getComputer().get(i).getId_computer());
			i++;
			list.add(a);
		}
		entityManager.close();
		return list;

	}
	
}