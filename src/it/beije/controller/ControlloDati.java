package it.beije.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ControlloDati{

public static boolean controlloDate(Date data1, Date data2) {
	if(data1.compareTo(data2)>0)
	{
		return false;
	}
	else
		return true;
}

public static boolean controlloImpegno(int idpc,Date date1) throws ClassNotFoundException, SQLException{
	Connection conn = ConnectionFactory.getConnection();
	try {
	Statement stmt = conn.createStatement();
	String query="SELECT * FROM users_computer";
	ResultSet rs = stmt.executeQuery(query);
	System.out.println("connection ? " + !conn.isClosed());
	int temp=0;
	Date temp2 = null;
	while (rs.next()) {
	
	 temp=(rs.getInt("id_computer"));
	 temp2=(rs.getDate("restituzione"));
	 if (temp==idpc) {
		 if (temp2.compareTo(date1)<0) return true;
		 conn.close();
		 return false;
	 }

	}
	
	rs.close();
	
} catch (SQLException sqlEx) {
	sqlEx.printStackTrace();
} finally {
	try {
		if (conn != null) conn.close();
	} catch (SQLException ce) {
		ce.printStackTrace();
	}
}
	return true;
	
}

public static String controlloNome(String nome) {
	if(nome.equals("")||nome.contains("  ")||nome.equals(" ")) {
		return null;
	}
	else
		return nome;
}

public static String controlloCognome(String cognome) {
	if (cognome.equals("")||cognome.contains("  ")||cognome.equals(" ")) {
		return null;
	}
	else
		return cognome;
}
}
