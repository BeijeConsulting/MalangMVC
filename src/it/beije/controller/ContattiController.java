package it.beije.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.controller.bean.Contatto;

@Controller
public class ContattiController {

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getForm() {
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String postForm(@Validated Contatto contatto, Model model) {
		System.out.println(contatto);
		
		model.addAttribute("contatto", contatto);
		
		return "contatto";
	}

	@RequestMapping(value = "/sendparameter", method = RequestMethod.GET)
	public String sendparameter() {
		return "sendparameter";
	}

	@RequestMapping(value = "/getparameter", method = RequestMethod.POST)
	public String getparameter(@RequestParam("param_stringa") String s,
			@RequestParam("param_numero") int n,
			Model model) {
		System.out.println(s);
		System.out.println(n);
		
		model.addAttribute("stringa", s);
		model.addAttribute("numero", n);
		
		return "viewparams";
	}

}
