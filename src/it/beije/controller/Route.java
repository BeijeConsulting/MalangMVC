package it.beije.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Route {
	@RequestMapping(value = "/route", method = RequestMethod.GET)
	public String Route(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "route";
	}
	
	@RequestMapping(value = "/aggiungiutente", method = RequestMethod.GET)
	public String AggiungiUtente(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getQueryString());
		return "crea_utente";
	}
	
	
	@RequestMapping(value = "/associa", method = RequestMethod.POST)
	public String Associa(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		String id_utente = request.getParameter("utente");
		String id_computer = request.getParameter("computer");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/malang?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","beije12");
			System.out.println(connessione.isValid(0));
			Statement stmt = connessione.createStatement();
			String insert = "INSERT INTO utente_computer (id_utente,id_computer,data_consegna,data_restituzione,note) VALUES ('"+id_utente+"','"+id_computer+"','Oggi','Vuoto','Vuoto')";
			stmt.executeUpdate(insert);
			
			String upd1 = "UPDATE utenti SET assegnato='si' WHERE id='"+id_utente+"'";
			stmt.executeUpdate(upd1);
			String upd2 = "UPDATE computer SET libero='no' WHERE id='"+id_computer+"'";
			stmt.executeUpdate(upd2);
			model.addAttribute("successo","Dati Inseriti!");
		}catch(Exception e) {
			model.addAttribute("errore","error");
		}
		
		
		return "associa_computer_a_utente";
	}
	
	
	@RequestMapping(value = "/aggiungiutente", method = RequestMethod.POST)
	public String AggiungiUtentePOST(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		if(nome.length() == 0 || cognome.length() == 0 || email.length() == 0) {
			model.addAttribute("errore","Alcuni campi sono vuoti.");
		}else {
			model.addAttribute("successo","I Campi sono stati inseriti nel DATABASE");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/malang?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","beije12");
				System.out.println(connessione.isValid(0));
				Statement stmt = connessione.createStatement();
				String insert = "INSERT INTO utenti (cognome,email,nome) VALUES ('"+cognome+"','"+email+"','"+nome+"')";
				stmt.executeUpdate(insert);
			}catch(Exception e) {
				
			}
				
		}
		return "crea_utente";
	}
	
	@RequestMapping(value = "/aggiungicomputer", method = RequestMethod.GET)
	public String AggiungiComputer(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "crea_computer";
	}
	
	@RequestMapping(value = "/aggiungicomputer", method = RequestMethod.POST)
	public String AggiungiComputerPOST(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		String modello = request.getParameter("modello");
		String marca = request.getParameter("marca");
		String cpu = request.getParameter("cpu");
		String ram = request.getParameter("ram");
		String hd = request.getParameter("hd");
		String sn = request.getParameter("sn");
		String note = request.getParameter("note");
		String so = request.getParameter("so");
		
		if(modello.length() == 0 ||
		   marca.length() == 0 ||
		   cpu.length() == 0 ||
		   ram.length() == 0 ||
		   hd.length() == 0 ||
		   sn.length() == 0 ||
		   note.length() == 0 ||
		   so.length() == 0) {
			model.addAttribute("errore","Compila tutti i campi prima...");
		}else {
			model.addAttribute("successo","Computer inserito correttamente");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/malang?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","beije12");
				System.out.println(connessione.isValid(0));
				Statement stmt = connessione.createStatement();
				String insert = "INSERT INTO computer (marca,modello,CPU,RAM,HD,sn,note,SO) VALUES "
						+ "('"+marca+"','"+modello+"','"+cpu+"','"+ram+"','"+hd+"','"+sn+"','"+note+"','"+so+"')";
				stmt.executeUpdate(insert);
			}catch(Exception e) {
				
			}
		
		}
		return "crea_computer";
	}
	
	@RequestMapping(value = "/associacomputer", method = RequestMethod.GET)
	public String AssociaComputer(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		String user = "";	
		String computer = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/malang?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","beije12");
			System.out.println(connessione.isValid(0));
			Statement stmt = connessione.createStatement();
	
			String sql = "SELECT * FROM utenti WHERE assegnato='no'";
			ResultSet fetch = stmt.executeQuery(sql);
			while(fetch.next()) {
				
				user = user+"<option value='"+fetch.getInt("id")+"'>"+fetch.getString("nome")+" "+fetch.getString("cognome")+"</option>";
		
			}
	        model.addAttribute("utenti", user);

			
			
			String sql1 = "SELECT * FROM computer WHERE libero='si'";
			ResultSet fetch1 = stmt.executeQuery(sql1);
			while(fetch1.next()) {
				computer = computer+"<option value='"+fetch1.getInt("id")+"'>"+fetch1.getString("marca")+" "+fetch1.getString("modello")+"</option>";
		
			}
			model.addAttribute("computer", computer);
		}catch(Exception e) {
			
		}
		
		
	        

				return "associa_computer_a_utente";
	}
	
	
}
