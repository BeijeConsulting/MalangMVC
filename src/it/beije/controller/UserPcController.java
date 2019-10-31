package it.beije.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Utente;
import it.beije.controller.bean.UtenteComputer;

//@Todo capire perchè inserisce utenti con gli stessi parametri anche se hai fatto i controlli

@Controller
public class UserPcController {

	@RequestMapping (value="/homepage" , method=RequestMethod.GET)
	public String getUsers(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		/*try {
			response.getWriter().append("Redirecting...");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		
		TypedQuery<Utente> query=entityManager.createQuery("SELECT u from Utente u",Utente.class);
		
		List<Utente> utenti=query.getResultList();
		
		request.getSession().setAttribute("user", utenti);
		
		//model.addAttribute("result","OK!");
		return "homepage";
	}
	
	@RequestMapping (value="/homepage" , method=RequestMethod.POST)
	public String getAssociatedComputers(@RequestParam("user") String userString, HttpServletRequest request, Model model) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		
		String[] user=userString.split(" ");
		System.out.println(userString);
		System.out.println(Integer.valueOf(user[0]));
		Utente u=new Utente();
		u.setId(Integer.valueOf(user[0]));
		u.setNome(user[1]);
		u.setCognome(user[2]);
		u.setEmail(user[3]);
		
		u.updateComputerList();
		
		request.getSession().setAttribute("computerlist", u.getPcs());
		String result;
		if (u.getPcs()!=null) 
			result="Computer caricati con successo!";
		else
			result="Errore Caricamento computer!";
		
		model.addAttribute("result", result);
		return "homepage";
	}
	
	@RequestMapping (value="/newuser", method=RequestMethod.GET)
	public String newUserRedirect(HttpServletResponse response) {
		
		try {
			response.getWriter().append("Redirecting...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "newuser";
	}
	
	@RequestMapping (value="/newuser", method=RequestMethod.POST)
	public String newUser(Model model, HttpServletRequest request, @Validated Utente utente, HttpServletResponse response)
	{
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		
		Query query=entityManager.createQuery("SELECT u.id FROM Utente u WHERE u.nome='"+utente.getNome()+"' AND u.cognome='"+utente.getCognome()+
				"'AND u.email='"+utente.getEmail()+"'");
		String result;
		if (query.getResultList()==null || !query.getResultList().isEmpty())
		{
			entityManager.getTransaction().begin();
			entityManager.persist(utente);
			entityManager.getTransaction().commit();
			entityManager.close();
			result="Utente Inserito con Successo";
		}
		else
			result="Utente gia Registrato!";
		
		model.addAttribute("result",result);
		return getUsers(model,request,response);
	}
	
	@RequestMapping (value="newpc", method=RequestMethod.GET)
	public String newPcRedirect() {	
		return "newpc";
	}
	
	@RequestMapping (value="newpc", method=RequestMethod.POST)
	public String newPc(@Validated Computer computer, Model model) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		
		//Effettuare controlli per verificare se l'entità esiste gia nel db
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(computer);
			entityManager.getTransaction().commit();
			entityManager.close();
			model.addAttribute("result","Nuovo computer inserito con successo!");
		}
		catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result","Impossibile inserire nuovo computer");
		}
		return "homepage";
	}
	
	@RequestMapping (value="assignpc", method=RequestMethod.GET)
	public String assignPCRedirect(HttpServletRequest request) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		
		TypedQuery<Utente> utenti = entityManager.createQuery("SELECT u from Utente u",Utente.class);
		TypedQuery<Computer> pcs = entityManager.createQuery("SELECT c from Computer c",Computer.class);
		
		request.getSession().setAttribute("user",utenti.getResultList());
		request.getSession().setAttribute("computerlist",pcs.getResultList());
		
		return "assignpc";
	}
	
	@RequestMapping (value="assignpc", method=RequestMethod.POST)
	public String assignPc(Model model, @Validated UtenteComputer uc) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		String result;
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(uc);
			entityManager.getTransaction().commit();
			entityManager.close();
			result="Computer associato correttamente";
		}catch(Exception e) {
			e.printStackTrace();
			result="Errore associazione!";
		}
		
		model.addAttribute("result",result);
		
		return "homepage";
	}
}
