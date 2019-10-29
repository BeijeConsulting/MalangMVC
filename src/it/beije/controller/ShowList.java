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

@Controller
public class ShowList {
	
	@RequestMapping(value = "/computerdot", method = RequestMethod.POST)
	public String computerList(@Validated ArrayList<Assignment> assignment ,Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	int id=Integer.valueOf(request.getParameter("param_id"));
	assignment=ShowInfo.list(id);
	model.addAllAttributes(assignment);
	return "computerlist";
}
}
