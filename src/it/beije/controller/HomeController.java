package it.beije.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
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
	public String index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		return "index"; // index  è la pagina jsp che deve essere mostrata
	}
	// Local, Model, request, response  sono i 4 parametri utilizzabili in homepage 
	@RequestMapping(value = "/home", method = RequestMethod.GET)

	public String homepage(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) { // model serve per trasportare il data dal controller al view

		System.out.println("Home Page Requested, country = " + locale.getCountry());
		System.out.println("Home Page Requested, language = " + locale.getLanguage());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String dataFormattato = dateFormat.format(date);

		model.addAttribute("serverTime", dataFormattato);

		return "home"; // home qui è la pagina jsp che deve essere mostrata
	}

	@RequestMapping(value = "/txt", method = RequestMethod.GET)
	public void returnTXT(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("index Page Requested : " + request.getRequestURI());

		response.setContentType("text/plain");
		response.getWriter().append("CIAO");
	}

}
