package it.beije.controller;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.controller.bean.Assignment;
import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Utente;

@Controller
public class FormController {

	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public String newUser(@Validated Utente utente, Model model, HttpServletRequest request) {
		utente.setCognome(request.getParameter("param_cognome"));
		utente.setNome(request.getParameter("param_nome"));
		utente.setEmail(request.getParameter("param_email"));
		RegDB.regUser(utente);
		return "registrato";
	}

	@RequestMapping(value = "/newcomputer", method = RequestMethod.POST)
	public String newComputer(@Validated Computer computer, Model model, HttpServletRequest request) {
		computer.setModello(request.getParameter("param_modello"));
		computer.setMarca(request.getParameter("param_marca"));
		computer.setCpu(request.getParameter("param_cpu"));
		computer.setRam(Integer.valueOf(request.getParameter("param_ram")));
		computer.set_HD(request.getParameter("param_HD"));
		computer.set_SN(request.getParameter("param_SN"));
		computer.setNote(request.getParameter("param_note"));
		computer.set_SO(request.getParameter("param_SO"));
		RegDB.regComputer(computer);
		return "registrato";
	}
	
	@RequestMapping(value = "/newassignment", method = RequestMethod.POST)
	public String newAssignment(@Validated Assignment assignment, Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		boolean verify=false;
		
		assignment.setConsegna(Date.valueOf(request.getParameter("param_consegna")));
		assignment.setRestituzione(Date.valueOf(request.getParameter("param_restituzione")));
		assignment.setNote(request.getParameter("param_note"));
		assignment.setId_utente(Integer.valueOf(request.getParameter("param_idutente")));
		assignment.setId_computer(Integer.valueOf(request.getParameter("param_idcomputer")));
		verify=ControlloDati.controlloDate(assignment.getConsegna(), assignment.getRestituzione());
		if(verify==true)
		{
		verify=ControlloDati.controlloImpegno(assignment.getId_computer(),assignment.getConsegna());
		if (verify==true) {
		RegDB.regAssignment(assignment);
		return "registrato";
		}
		else return "newassignment";
		}
		else
		{
			return "newassignment";
		}
	}

}
