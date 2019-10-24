package it.beije.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xml.sax.SAXException;





@Controller
public class RegController {
	
	@RequestMapping(value = "CSVServlet", method = RequestMethod.POST)
	public String createCSV(Locale locale, Model model, HttpServletRequest request) throws IOException {
		Utente u = new Utente();
		u=(Utente) request.getSession().getAttribute("user");
		AddContact.writeCSV(u.getCognome(),u.getNome(),
							u.getEmail(),u.getTelefono());
		return "registrato";
	}
	
	@RequestMapping(value = "DBServlet", method = RequestMethod.POST)
	public String createDB(Locale locale, Model model, HttpServletRequest request) throws IOException {
	try {
		
		Utente u = new Utente();
		u=(Utente) request.getSession().getAttribute("user");
		
		DBReg.regDB(u.getCognome(), u.getNome(),
				 	u.getEmail(),u.getTelefono());
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "registrato";
	}
	
	@RequestMapping(value = "XMLServlet", method = RequestMethod.POST)
	public String createXML(Locale locale, Model model, HttpServletRequest request) throws IOException {
	try {
		Utente u = new Utente();
		u=(Utente) request.getSession().getAttribute("user");
		
		XMLReg.addXMLContact(u.getCognome(), u.getNome(),
							 u.getEmail(),u.getTelefono());
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "registrato";
	
}
}
