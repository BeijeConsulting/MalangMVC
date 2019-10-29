package it.beije.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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

import it.beije.controller.bean.Utente;
import it.beije.model.ConnectionFactory;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Home Page Requested, country = " + locale.getCountry());
		System.out.println("Home Page Requested, language = " + locale.getLanguage());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String dataFormattato = dateFormat.format(date);

		model.addAttribute("serverTime", dataFormattato);

		return "home";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,Model model) {
		
		Utente utente=(Utente)request.getSession().getAttribute("userBean");
		
		model.addAttribute("user", utente);
		
		return "login";
		
	}
	
	@RequestMapping(value="/auth", method= RequestMethod.POST)
	public String auth(HttpServletRequest request)
	{
		String nome,cognome,telefono,email;
		
		nome=request.getParameter("nome")!=null?request.getParameter("nome"):"";
		cognome=request.getParameter("cognome")!=null?request.getParameter("cognome"):"";
		email=request.getParameter("email")!=null?request.getParameter("email"):"";
		telefono=request.getParameter("telefono")!=null?request.getParameter("telefono"):"";
		Utente user=new Utente(nome,cognome,email,telefono);
		request.getSession().setAttribute("userBean", user);
		
		if (user.isValid())
			return "confirm";
		
		return "login";
	}
	
	@RequestMapping(value="/modifica", method = RequestMethod.POST)
	public String modifica() {
		return "login";
	}
	
//	@RequestMapping(value="/save", method = RequestMethod.POST)
//	public String save(HttpServletRequest request) {
//		
//		System.out.println("ciao");
//		try {
//			
//			Connection conn=ConnectionFactory.getConnection();
//			Statement stmt=conn.createStatement();
//			
//			if (stmt.execute(((Utente)(request.getSession().getAttribute("userBean"))).getInsertQuery()))
//				return "confirm?result=errore";
//			else
//				return "confirm?result=ok";
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "confirm?result=errore";
//	}
=======

	@RequestMapping(value = "/txt", method = RequestMethod.GET)
	public void returnTXT(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("index Page Requested : " + request.getRequestURI());

		response.setContentType("text/plain");
		response.getWriter().append("CIAO");
	}

>>>>>>> refs/remotes/origin/master
}
