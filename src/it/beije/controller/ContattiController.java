package it.beije.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Contatto;
import it.beije.controller.bean.UtenteComputer;

@Controller
public class ContattiController {

	
	
	
	
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getForm() {
		return "form";
	}
	
	
	@RequestMapping(value = "/regutentepc", method = RequestMethod.GET)
	public String getFor() {
		return "regUtentePc";
	}
	

	@RequestMapping(value = "/regcomputer", method = RequestMethod.POST)
	public String postForm(@Validated Computer com, Model model) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(com);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
		model.addAttribute("result", "computer aggiunto");
		
		return "home";
	}
	
	@RequestMapping(value = "/regutentecomputer", method = RequestMethod.POST)
public String registerDelivery(@RequestParam("id_utente") int idUtente, @RequestParam("id_computer") int idComputer, @RequestParam("note") String note, Model model) {
		
		LocalDate delivery = LocalDate.now();
		
		EntityManager entityManager = Persistence.createEntityManagerFactory("MalangMVC").createEntityManager();
		
		entityManager.getTransaction().begin();
		
		UtenteComputer deli = new UtenteComputer();
		deli.setComputer(entityManager.find(Computer.class, idUtente));
		deli.setUtenti(entityManager.find(Contatto.class, idComputer));
		deli.setDataconsegna(delivery.toString());
		deli.setNote(note);
		
		
		entityManager.persist(deli);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		model.addAttribute("result", "Nuovo delivery aggiunto");
		
		return "home";
	}
}
	


