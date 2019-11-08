package it.beije.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.beije.controller.*;

@Controller
public class PcUtentiController {
	
	@RequestMapping(value = "/Gestionale", method = RequestMethod.GET)
	public String Gestionale(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		return "Gestionale";
	}
	
	@RequestMapping(value = "/Utenti", method = RequestMethod.GET)
	public String Utenti(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		return "Utenti";
	}
	
	@RequestMapping(value = "/Utenti", method = RequestMethod.POST)
	public String UtentiPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		
		Utilities.toDB(nome, cognome, email);

		return "Utenti";
	}
	
	@RequestMapping(value = "/Computer", method = RequestMethod.GET)
	public String Computer(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		return "Computer";
	}
	
	@RequestMapping(value = "/Computer", method = RequestMethod.POST)
	public String ComputerPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		
		String modello = request.getParameter("modello");
		String marca = request.getParameter("marca");
		String cpu = request.getParameter("cpu");
		String ram = request.getParameter("ram");
		String hd = request.getParameter("hd");
		String numeroseriale = request.getParameter("serial number");
		String note = request.getParameter("note");
		String so = request.getParameter("so");
		
		Utilities.toDB1(modello, marca, cpu, ram, hd, numeroseriale, note, so);

		return "Computer";
	}
	
	@RequestMapping(value = "/PcToID", method = RequestMethod.GET)
	public String PcToID(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		
		String user = "";	
		String computer = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/malang?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Marcomattia1");
			System.out.println(connessione.isValid(0));
			Statement stmt = connessione.createStatement();
	
			String sql = "SELECT * FROM utenti";
			ResultSet fetch = stmt.executeQuery(sql);
			while(fetch.next()) {
				
				user = user+"<option value='"+fetch.getInt("id")+"'>"+fetch.getString("nome")+" "+fetch.getString("cognome")+"</option>";
		
			}
	        model.addAttribute("utenti", "<form action='PcToID' method='post'>utente: <select id='ut' name='utente'>"+user+"</select><br>");

			
			
			String sql1 = "SELECT * FROM computer";
			ResultSet fetch1 = stmt.executeQuery(sql1);
			while(fetch1.next()) {
				computer = computer+"<option value='"+fetch1.getInt("id")+"'>"+fetch1.getString("marca")+" "+fetch1.getString("modello")+"</option>";
		
			}
			model.addAttribute("computer", "computer: <select id='comp' name='computer'>"+computer+"</select><br>");
		}catch(Exception e) {
			
		}
		
		model.addAttribute("messaggio","");

		return "PcToID";
	}
	
	@RequestMapping(value = "/PcToID", method = RequestMethod.POST)
	public String PcToIDpost(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		
		String idutente = request.getParameter("utente");
		String idcomputer = request.getParameter("computer");
		String datadiconsegna = request.getParameter("datadiconsegna");
		String datadirestituzione = request.getParameter("datadirestituzione");
		String note = request.getParameter("note");
		
		String user = "";	
		String computer = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/malang?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Marcomattia1");
			System.out.println(connessione.isValid(0));
			Statement stmt = connessione.createStatement();
	
			String sql = "SELECT * FROM utenti";
			ResultSet fetch = stmt.executeQuery(sql);
			while(fetch.next()) {
				
				user = user+"<option value='"+fetch.getInt("id")+"'>"+fetch.getString("nome")+" "+fetch.getString("cognome")+"</option>";
		
			}
	        model.addAttribute("utenti", "<form action='PcToID' method='post'>utente: <select id='ut' name='utente'>"+user+"</select><br>");

			
			
			String sql1 = "SELECT * FROM computer";
			ResultSet fetch1 = stmt.executeQuery(sql1);
			while(fetch1.next()) {
				computer = computer+"<option value='"+fetch1.getInt("id")+"'>"+fetch1.getString("marca")+" "+fetch1.getString("modello")+"</option>";
		
			}
			model.addAttribute("computer", "computer: <select id='comp' name='computer'>"+computer+"</select><br>");
		}catch(Exception e) {
			
		}

		
	
	
		
		Utilities.toDB2(idutente, idcomputer, datadiconsegna,datadirestituzione,note);
		
		model.addAttribute("messaggio","<font color='blue'><b>dati associati!</b></font>");

		return "PcToID";
	}

}
