package it.beije.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.controller.bean.Contatto;

@Controller
public class ContattiController {

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getForm() {
		return "form";
	}

	@RequestMapping(value = "/for", method = RequestMethod.POST)
	public String postForm(@Validated Contatto contatto, Model model) {
		System.out.println(contatto);
		
		model.addAttribute("contatto", contatto);
		
		return "contatto";
	}

}
