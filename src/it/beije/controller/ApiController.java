package it.beije.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
		contatto.setCognome("rossi");
		contatto.setId(100);

		return contatto;
	}

}
