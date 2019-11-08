package it.beije.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Utente;

@Controller
public class SearchController {
	
	@RequestMapping(value = "/searchuser", method = RequestMethod.POST)
	public String searchUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		String cognome = request.getParameter("param_cognome");
		String nome = request.getParameter("param_nome");
		String email = request.getParameter("param_email");
		
		System.out.println(cognome+nome+email);
		
		Utente u = ControlloDati.searchUser(cognome, nome, email);
		
		if (u==null) {
			request.getSession().setAttribute("error", "Non esiste questo utente");
			return "searchuser";
		}
		else {
		int id=u.getIdusers();
		System.out.println(id);
		System.out.println(u.getCognome() + u.getNome() + u.getEmail());
		u.setComputer(ShowInfo.list(id));
		ArrayList <Computer> pcs = new ArrayList<>();
		for (int i = 0; i<u.getComputer().size();i++)
		pcs.add(ShowInfo.showComputer(u.getComputer().get(i).getId_computer()));
		request.getSession().setAttribute("pcs",pcs);
		request.getSession().setAttribute("list", u.getComputer());
		request.getSession().setAttribute("user", u);
		return "showuser";
		}
	}
}
