package it.beije.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
public class HomeController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage(Locale locale, Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String formReg(Locale locale, Model model,HttpServletResponse response, HttpServletRequest request) throws IOException {
		String email = request.getParameter("param_email");
		String telefono = request.getParameter("param_telefono");
		String nome = request.getParameter("param_nome");
		String cognome = request.getParameter("param_cognome");
		
		Utente u = new Utente();
		
		u.setCognome(cognome);
		u.setNome(nome);
		u.setEmail(email);
		u.setTelefono(telefono);
		
		
		if (ControlloDati.controlloNome(nome)==null) {
			request.getSession().setAttribute("error", "NOME MANCANTE");
			return "home";
		}
		else if (ControlloDati.controlloCognome(cognome)==null) {
			request.getSession().setAttribute("error", "COGNOME MANCANTE");
			return "home";
		}
		else if (ControlloDati.controlloMail(email)==null) {
			request.getSession().setAttribute("error", "EMAIL ERRATA");
			return "home";
		}
		else if(ControlloDati.controlloTel(u.getTelefono())==null) {
			request.getSession().setAttribute("error", "TELEFONO NON VALIDO");
			return "home";
		}
		ControlloDati.controlloTel(u.getTelefono());
		return "auth2";
		}
}