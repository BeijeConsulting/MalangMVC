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
	public String PcToID(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		return "PcToID";
	}
	
	@RequestMapping(value = "/PcToID", method = RequestMethod.POST)
	public String PcToIDpost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		
		String idutente = request.getParameter("idutente");
		String idcomputer = request.getParameter("idcomputer");
		String datadiconsegna = request.getParameter("datadiconsegna");
		String datadirestituzione = request.getParameter("datadirestituzione");
		String note = request.getParameter("note");
		
		Utilities.toDB2(idutente, idcomputer, datadiconsegna,datadirestituzione,note);

		return "PcToID";
	}

}
