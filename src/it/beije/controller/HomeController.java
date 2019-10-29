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

}
