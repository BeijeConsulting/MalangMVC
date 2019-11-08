package it.beije.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.beije.controller.bean.Assignment;
import it.beije.controller.bean.Computer;
import it.beije.controller.bean.Utente;


public class ShowInfo {
	
	public static ArrayList<Assignment> list(int idutente) throws IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		int id = idutente;
		ArrayList<Assignment> list = new ArrayList<Assignment>();
		Utente u = entityManager.find(Utente.class, id);

		System.out.println("Utente pc : " + u.getComputer());
		int i = 0;
		for (Assignment a : u.getComputer()) {
			a.setConsegna(u.getComputer().get(i).getConsegna());
			a.setRestituzione(u.getComputer().get(i).getRestituzione());
			a.setId_utente(u.getComputer().get(i).getId_utente());
			a.setId_computer(u.getComputer().get(i).getId_computer());
			i++;
			list.add(a);
		}
		entityManager.close();
		return list;

	}
	
public static ArrayList<Assignment> list2(int idcomputer) throws IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		int id = idcomputer;
		ArrayList<Assignment> list = new ArrayList<Assignment>();
		Computer c = entityManager.find(Computer.class, id);

		int i = 0;
		for (Assignment a : c.getUtenti()) {
			a.setConsegna(c.getUtenti().get(i).getConsegna());
			a.setRestituzione(c.getUtenti().get(i).getRestituzione());
			a.setId_utente(c.getUtenti().get(i).getId_utente());
			a.setId_computer(c.getUtenti().get(i).getId_computer());
			i++;
			list.add(a);
		}
		entityManager.close();
		return list;

	}

public static Utente showUser(int idutente) throws IOException {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
	EntityManager entityManager = factory.createEntityManager();
	int id = idutente;
	Utente u = entityManager.find(Utente.class, id);
	entityManager.close();
	return u;

}

public static Computer showComputer(int idpc) throws IOException {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
	EntityManager entityManager = factory.createEntityManager();
	int id = idpc;
	Computer c = entityManager.find(Computer.class, id);
	entityManager.close();
	return c;

}

public static ArrayList<Computer> allPc() throws IOException {
	Connection conn = null;
	ArrayList<Computer> computers = new ArrayList<>();
	try {
		conn = ConnectionFactory.getConnection();
		Statement stmt = conn.createStatement();
		String query="SELECT * FROM computer";
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("connection ? " + !conn.isClosed());
		while (rs.next()) {
			Computer c = new Computer();
			c.setId_computer(rs.getInt("idcomputer"));
			c.setMarca(rs.getString("marca"));
			c.setModello(rs.getString("modello"));
			c.setCpu(rs.getString("cpu"));
			c.setRam(rs.getInt("ram"));
			c.set_HD(rs.getString("HD"));
			c.set_SN(rs.getString("SN"));
			c.setNote(rs.getString("note"));
			c.set_SO(rs.getString("SO"));
			
			computers.add(c);
		}
		
		rs.close();
	} catch (ClassNotFoundException cnfEx) {
		cnfEx.printStackTrace();
	} catch (SQLException sqlEx) {
		sqlEx.printStackTrace();
	} finally {
		try {
			if (conn != null) conn.close();
		} catch (SQLException ce) {
			ce.printStackTrace();
		}
	}
	return computers;
}

public static ArrayList<Utente> allUsers() throws IOException {
	Connection conn = null;
	ArrayList<Utente> users = new ArrayList<>();
	try {
		conn = ConnectionFactory.getConnection();
		Statement stmt = conn.createStatement();
		String query="SELECT * FROM users";
		ResultSet rs = stmt.executeQuery(query);
		System.out.println("connection ? " + !conn.isClosed());
		while (rs.next()) {
			Utente u = new Utente();
			u.setIdusers(rs.getInt("idusers"));
			u.setCognome(rs.getString("cognome"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			
			users.add(u);
		}
		
		rs.close();
	} catch (ClassNotFoundException cnfEx) {
		cnfEx.printStackTrace();
	} catch (SQLException sqlEx) {
		sqlEx.printStackTrace();
	} finally {
		try {
			if (conn != null) conn.close();
		} catch (SQLException ce) {
			ce.printStackTrace();
		}
	}
	return users;
}
	
}