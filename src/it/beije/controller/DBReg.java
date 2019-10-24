package it.beije.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;

public class DBReg {
	
	public static void regDB(String cognome, String nome, String email, String telefono) throws ClassNotFoundException, SQLException
	{
		try {
	Connection conn = ConnectionFactory.getConnection();
	 String query = " insert into rubrica (cognome, nome, email, telefono)"
		        + " values (?, ?, ?, ?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, cognome);
		      preparedStmt.setString (2, nome);
		      preparedStmt.setString (3, email);
		      preparedStmt.setString (4, telefono);

		      // execute the preparedstatement
		      preparedStmt.execute();
		      
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
		  }
		}