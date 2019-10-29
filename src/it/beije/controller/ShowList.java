package it.beije.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.beije.controller.bean.Assignment;
import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Utente;

@Controller
public class ShowList {
	
	@RequestMapping(value = "/computerdot", method = RequestMethod.POST)
	public String computerList(ArrayList<Assignment> assignment ,Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	int id=Integer.valueOf(request.getParameter("param_id"));
	assignment=ShowInfo.list(id);
	model.addAttribute("list", assignment);
	Utente u = ShowInfo.showUser(id);
	model.addAttribute("user",u);
	return "computerlist";
}
	
	@RequestMapping(value = "/storico", method = RequestMethod.POST)
	public String userList(ArrayList<Assignment> assignment ,Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	int id=Integer.valueOf(request.getParameter("param_id"));
	assignment=ShowInfo.list2(id);
	model.addAttribute("list", assignment);
	Computer c = ShowInfo.showComputer(id);
	model.addAttribute("pc", c);
	return "storicoutenti";
}
}
