package it.beije.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.controller.bean.Contatto;
import it.beije.controller.bean.Computer;
import it.beije.controller.bean.UtenteComputer;

@Controller
public class UtenteComputerController {
	

	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String registrazione(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("index Page Requested : " + request.getRequestURI());
		String utente = request.getParameter("utente");
		String computer = request.getParameter("computer");
		
		//model.addAttribute("registra_utente", registra_utente);
		
		if (utente != null) {
			
			//return response.encodeRedirectURL("formUtente.jsp"); 
			return "formUtente"; 
		}
		else if (computer != null) {
			
			return "formComputer"; 
			}
		else {
			return "homepage"; // index  è la pagina jsp che deve essere mostrata
			}
	}
	@RequestMapping(value = "/formUtente", method = RequestMethod.GET)
	public String registra_computer(@Validated Contatto contatto, Model model) {
		System.out.println(contatto);
		//String registra_utente = request.getParameter("registra_utente"); 
		model.addAttribute("contatto", contatto);
		
		return "formUtente";
	}

	@RequestMapping(value = "/formComputer", method = RequestMethod.GET)
	public String registra_computer(@Validated Computer computer, Model model) {
		System.out.println(computer);
		
		model.addAttribute("computer", computer);
		
		return "formComputer";
	}
	
	@RequestMapping(value = "/formUtenteComputer", method = RequestMethod.GET)
	public String registra_utentecomputer(@Validated UtenteComputer utentecomputer, Model model) {
		System.out.println(utentecomputer);
		
		model.addAttribute("utentecomputer", utentecomputer);
		return "formUtenteComputer";
	}
	
	
	
//	@RequestMapping(value = "/txt2", method = RequestMethod.GET)
//	public void returnTXT(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("index Page Requested : " + request.getRequestURI());
//
//		response.setContentType("text/plain");
//		response.getWriter().append("CIAO");
//	}

}

