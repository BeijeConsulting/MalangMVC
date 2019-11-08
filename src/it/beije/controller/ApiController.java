package it.beije.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.controller.bean.Utente;


@RestController
@RequestMapping("api")
public class ApiController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody Utente test() {
		System.out.println("TEST");

		return new Utente();
	}

	@RequestMapping(value = "/testpost", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Utente testpost(@RequestBody Utente utente) {
		System.out.println("TEST POST");
		
		utente.setIdusers(100);

		return utente;
	}

}
