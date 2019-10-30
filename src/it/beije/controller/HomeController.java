package it.beije.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Utente;





@Controller
public class HomeController {
	
	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public String newUser(HttpServletRequest request, HttpServletResponse response) {

		return "newuser";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		return "home";
	}

	@RequestMapping(value = "/newcomputer", method = RequestMethod.GET)
	public String newComputer(HttpServletRequest request, HttpServletResponse response) throws IOException {

	return "newcomputer";
	}
	
	@RequestMapping(value = "/newassignment", method = RequestMethod.GET)
	public String newAssignment(HttpServletRequest request, HttpServletResponse response) throws IOException {

	return "newassignment";
	}
	
	@RequestMapping(value = "/computerdot", method = RequestMethod.GET)
	public String computerDot(HttpServletRequest request, HttpServletResponse response) throws IOException {

	return "computerdot";
	}
	
	@RequestMapping(value = "/storico", method = RequestMethod.GET)
	public String storico(HttpServletRequest request, HttpServletResponse response) throws IOException {

	return "storico";
	}
	
	@RequestMapping(value = "/searchuser", method = RequestMethod.GET)
	public String searchUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

	return "searchuser";
	}
	
	@RequestMapping(value = "/allpc", method = RequestMethod.GET)
	public String allPc(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
	ArrayList<Computer> computers = ShowInfo.allPc();
	model.addAttribute("pc", computers);
	return "allpc";
	}
	
	@RequestMapping(value = "/alluser", method = RequestMethod.GET)
	public String allUser(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
	ArrayList<Utente> users = ShowInfo.allUsers();
	model.addAttribute("user",users);
	return "alluser";
	}

}
