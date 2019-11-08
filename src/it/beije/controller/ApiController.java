package it.beije.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Utente;



@RestController
@RequestMapping("api")
public class ApiController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody List<Utente> test() throws IOException {
		List<Utente> utenti = new ArrayList<>();
		System.out.println("TEST");
		utenti=ShowInfo.allUsers();
		for(int i=0;i<utenti.size();i++)
		utenti.get(i).setComputer(ShowInfo.list(utenti.get(i).getIdusers()));
		return utenti;
	}

	@RequestMapping(value = "/testpost", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Utente testpost(@RequestBody Utente utente) {
		System.out.println("TEST POST");
		
		RegDB.regUser(utente);

		return utente;
	}

}
