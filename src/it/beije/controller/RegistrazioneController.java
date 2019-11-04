package it.beije.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Contatto;
import it.beije.controller.bean.UtenteComputer;

import it.beije.malang.database.ConnectionFactory;
import static it.beije.malang.database.JPAInsertDB;


@Controller
public class RegistrazioneController {
	
	@RequestMapping(value = "/formUtente", method = RequestMethod.GET)
	public String registra_computer(@Validated Contatto contatto, Model model) {
		System.out.println(contatto);
		//String registra_utente = request.getParameter("registra_utente"); 
		model.addAttribute("contatto", contatto);
		int colonne = 4;
		  Object[] vals = new Object[colonne] ;
		   vals[0] = contatto.getNome();
		   vals[1] = contatto.getCognome();;
		   vals[2] = contatto.getTelefono();;
		   vals[3] = contatto.getEmail();
	      PreparedStatement pstmt = null;
	      Connection conn = null;
	      conn = ConnectionFactory.getConnection();
		  pstmt = conn.prepareStatement("insert into utente(nome, cognome, telefono, email) values (?, ?, ?,?)");
		  
		insert ( conn,  pstmt,  colonne, Object[] vals );
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
