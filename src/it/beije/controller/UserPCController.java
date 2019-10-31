package it.beije.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.controller.bean.Personalcomputer;
import it.beije.controller.bean.User;
import it.beije.controller.bean.Utenti;
import it.beije.controller.bean.Computer;


@Controller
public class UserPCController {

//			@RequestMapping(value = "/userform", method = RequestMethod.GET)
//			public String getForm() {
//				return "form";
//			}
//
//			@RequestMapping(value = "/userform", method = RequestMethod.POST)
//			public String postForm(@Validated Utenti utenti, Model model) {
//				System.out.println(utenti);
//				
//				model.addAttribute("utenti", utenti);// "contatto"-->attributo di model che creo io.
//				//contatto oggetto creato come parametro del metodo public String postFor
//				
//				return "File";// nome file contatto.jsp
//			}
		    //HOMEPAGE RICHIESTA MAPPING(QUANDO SCRIVO http://localhost:8080/MalangMVC/homepage)
			@RequestMapping(value = "/homepage", method = RequestMethod.GET)
			public String homepageRedirect() {
				return "homepage";
			}
			
			
			// ADDUSER  GET CONTROLLER
			@RequestMapping(value = "/adduser", method = RequestMethod.GET)
			public String addUserRedirect() {
				return "adduser";  // FILE adduser.jsp
			}
			
			
	
			// ADDUSER  POST CONTROLLER

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@Validated User utente, Model model) { // User utente--> oggetto della classe user
				
				EntityManagerFactory factory=Persistence.createEntityManagerFactory("MalangMVC");
				EntityManager entityManager = factory.createEntityManager();
				
				entityManager.getTransaction().begin();
				entityManager.persist(utente);
				
				entityManager.getTransaction().commit();
				entityManager.close();
				
				model.addAttribute("risultato","Operazione eseguita con successo");
				
				return "homepage";
				
			}
			
			
			//ADDCOMPUTER GET CONTROLLER

			@RequestMapping(value = "/addcomputer", method = RequestMethod.GET)
			public String addComputerRedirect() {
				return "addcomputer"; // file addcomputer.jsp
			}
			
			//ADDCOMPUTER POST CONTROLLER

			@RequestMapping(value = "/addcomputer", method = RequestMethod.POST)
			public String addComputer(@Validated Personalcomputer computer, Model model) {
				// Personalcomputer--> creo oggetto della classe Personalcomputer
				EntityManagerFactory factory=Persistence.createEntityManagerFactory("MalangMVC");// 
				EntityManager entityManager = factory.createEntityManager();
				
				entityManager.getTransaction().begin();
				entityManager.persist(computer);
				
				entityManager.getTransaction().commit();
				entityManager.close();
				
				
				
				model.addAttribute("risultato","Operazione eseguita con successo");
				
				return "homepage";
		
			}}
