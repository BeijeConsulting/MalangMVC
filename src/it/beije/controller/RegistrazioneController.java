package it.beije.controller;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


import static it.beije.malang.database.JPAInsertDB.insert;


@Controller
public class RegistrazioneController {
	
	@RequestMapping(value = "/formUtente", method = RequestMethod.GET)
	public String registrazione(HttpServletRequest request, HttpServletResponse response,@Validated Contatto contatto, Model model) throws ClassNotFoundException, SQLException, IOException {
		
		System.out.println(contatto);
		System.out.println("index Page Requested : " + request.getRequestURI());
		//String registra_utente = request.getParameter("registra_utente"); 
		model.addAttribute("contatto", contatto);
		int colonne = 4;
		  
	      PreparedStatement pstmt = null;
	      Connection conn = null;
	      conn = ConnectionFactory.getConnection();
		  pstmt = conn.prepareStatement("insert into utenti(nome, cognome, telefono, email) values (?, ?, ?,?)");
		    String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String email = request.getParameter("email");
			String telefono = request.getParameter("telefono");
			contatto.setNome(nome);
			contatto.setCognome(cognome);
			contatto.setEmail(email);
			contatto.setTelefono(telefono);
					//List<String[]> writer = ScriviCSV.scrivi( utente, nome, cognome, email, tel, filename);
	           
			   Object[] vals = new Object[colonne] ;
			   vals[0] = contatto.getNome();
			   vals[1] = contatto.getCognome();;
			   vals[2] = contatto.getTelefono();;
			   vals[3] = contatto.getEmail();
	           insert(conn, pstmt, colonne, vals );
			
			// Se i parametri non sono nulli stampa i parametri ricevuti sulla pagina home2.jsp sulla quale rindirizza l'utente 
			if (request.getParameter("nome")!= null  )
				{
				
				
		           
				request.getSession().setAttribute("user", contatto);
					
					response.sendRedirect("formUtente.jsp");
				
				//Altrimenti stampa un msg di errore sulla pagina di login.jsp
			} 
			else  
				System.out.println("ERRORE");
				
	       
		
		
		return "formUtente";
	}

//	@RequestMapping(value = "/formComputer", method = RequestMethod.GET)
//	public String registra_computer(@Validated Computer computer, Model model) {
//		System.out.println(computer);
//		
//		model.addAttribute("computer", computer);
//		
//		return "formComputer";
//	}
//	
//	@RequestMapping(value = "/formUtenteComputer", method = RequestMethod.GET)
//	public String registra_utentecomputer(@Validated UtenteComputer utentecomputer, Model model) {
//		System.out.println(utentecomputer);
//		
//		model.addAttribute("utentecomputer", utentecomputer);
//		return "formUtenteComputer";
//	}
//	
//	
//	
//	@RequestMapping(value = "/txt2", method = RequestMethod.GET)
//	public void returnTXT(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("index Page Requested : " + request.getRequestURI());
//
//		response.setContentType("text/plain");
//		response.getWriter().append("CIAO");
//	}

	

	
	
}
