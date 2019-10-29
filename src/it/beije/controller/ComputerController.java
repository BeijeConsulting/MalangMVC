package it.beije.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.controller.bean.Computer;

@Controller
public class ComputerController {

	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String postpc(@Validated Computer computer, Model model) {
		
		System.out.println(computer);
		
		model.addAttribute("computer", computer);
		
		return "computer";
	}
	
}
