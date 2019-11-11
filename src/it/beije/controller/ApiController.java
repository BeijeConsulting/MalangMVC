package it.beije.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import it.beije.controller.bean.Contatto;


@RestController
@RequestMapping("api")
public class ApiController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody Contatto test() {
		System.out.println("TEST");

		return new Contatto();
	}

	@RequestMapping(value = "/testpost", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Contatto testpost(@RequestBody Contatto contatto) {
		System.out.println("TEST POST");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(contatto);
		entityManager.getTransaction().commit();
		entityManager.close();
		return contatto;
	}
	
	@RequestMapping(value = "/getcontatto", method = RequestMethod.POST)
	public @ResponseBody Contatto getcontatto(@RequestParam("id") int n) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		Contatto contatto=entityManager.find(Contatto.class, n);
		return contatto;
	}

	@RequestMapping(value = "/getcontatti", method = RequestMethod.GET)
	public @ResponseBody List<Contatto> getcontatti() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<Contatto> query=entityManager.createQuery("SELECT c FROM Contatto c",Contatto.class);
		List<Contatto> contatti=query.getResultList();
		return contatti;
	}

		
}
