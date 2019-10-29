package it.beije.controller;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


import it.beije.controller.*;
public class Utilities {
	
		public static void toDB(String nome, String cognome, String email) {	
			
			try {
			Connection conn = ConnectionFactory.getConnection();
					
			Statement stmt = conn.createStatement();
			
			String insert =  "INSERT INTO utenti VALUES (null,'"+cognome+"','"+email+"', '"+nome+"' )";

			int r = stmt.executeUpdate(insert);
			
			System.out.println("rows affected : " + r);
			
			conn.close();
			} catch (ClassNotFoundException a) {
				System.out.println("classe non trovata");
			}catch (SQLException b) {
				System.out.println("SQL exc");
			}
		}
			
			public static void toDB1(String modello, String marca, String cpu, String ram, String hd, String numeroseriale, String note, String so) {	
				
				try {
				Connection conn = ConnectionFactory.getConnection();
						
				Statement stmt = conn.createStatement();
				
				String insert =  "INSERT INTO computer VALUES (null,'"+modello+"','"+marca+"', '"+cpu+"','"+ram+"','"+hd+"','"+numeroseriale+"','"+note+"','"+so+"' )";

				int r = stmt.executeUpdate(insert);
				
				System.out.println("rows affected : " + r);
				
				conn.close();
				} catch (ClassNotFoundException a) {
					System.out.println("classe non trovata");
				}catch (SQLException b) {
					System.out.println("SQL exc"+b.getMessage());
				}

			}
			
			public static void toDB2(String idutente, String idcomputer, String datadiconsegna, String datadirestituzione, String note ) {	
				
				try {
				Connection conn = ConnectionFactory.getConnection();
						
				Statement stmt = conn.createStatement();
				
				String insert =  "INSERT INTO utente_computer VALUES (null,'"+idutente+"','"+idcomputer+"', '"+datadiconsegna+"','"+datadirestituzione+"','"+note+"' )";

				int r = stmt.executeUpdate(insert);
				
				System.out.println("rows affected : " + r);
				
				conn.close();
				} catch (ClassNotFoundException a) {
					System.out.println("classe non trovata");
				}catch (SQLException b) {
					System.out.println("SQL exc");
				}
			}
			
			
			
}

