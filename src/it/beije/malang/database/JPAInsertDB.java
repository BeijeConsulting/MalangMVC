package it.beije.malang.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

	public class JPAInsertDB {
		
//		public static void main(String[] args)throws Exception {
//				 
//				  int colonne = 4;
//				  Object[] vals = new Object[colonne] ;
//				   vals[0] = "i";
//				   vals[1] = "ii";
//				   vals[2] = 674;
//				   vals[3] = "i@ii.it";
//			      PreparedStatement pstmt = null;
//			      Connection conn = null;
//			      conn = ConnectionFactory.getConnection();
//				  pstmt = conn.prepareStatement("insert into prova(nome, cognome, telefono, email) values (?, ?, ?,?)");
//				  insert ( conn, pstmt, colonne, vals);
//			  }
			  
			  public static void insert (Connection conn, PreparedStatement pstmt, int colonne, Object[] vals )  throws SQLException {
						 
				  try {
				    	conn = ConnectionFactory.getConnection(); //accede alla classe ConnectionFactory e poi carica la classe del driver JDBC, così non ci serve più la riga successiva
						System.out.println("connection ? " + !conn.isClosed());
						
						for (int i = 0, j = 1 ; i < vals.length && j <= colonne ; i++, j++) 
								pstmt.setObject(j, vals[i]);
						pstmt.executeUpdate();
				    } catch (Exception e) {
				      System.err.println("Error: " + e.getMessage());
				      e.printStackTrace();
				    } finally {
				      pstmt.close();
				    
				      conn.close();
				    }
			  }
/***************************************************************************************************/  	           
//			  public static void main(String[] args)throws Exception {
//			  
//		    String nome = "r";
//		    String cognome = "rr";
//		    String email = "r@rr.it";
//		    int telefono = 786;
//		    PreparedStatement pstmt = null;
//		    Connection conn = null;
//		    try {
//		    	conn = ConnectionFactory.getConnection(); //accede alla classe ConnectionFactory e poi carica la classe del driver JDBC, così non ci serve più la riga successiva
//				
//				System.out.println("connection ? " + !conn.isClosed());
//				Statement stmt = conn.createStatement();
//		      pstmt = conn.prepareStatement("insert into prova(nome, cognome, telefono, email) values (?, ?, ?,?)");
//		      pstmt.setString(1, nome);
//		      pstmt.setString(2, cognome);
//		      pstmt.setInt(3, telefono);
//		      pstmt.setString(4, email);
//		      pstmt.executeUpdate();
//		    } catch (Exception e) {
//		      System.err.println("Error: " + e.getMessage());
//		      e.printStackTrace();
//		    } finally {
//		      pstmt.close();
//		     // fis.close();
//		      conn.close();
//		    }
//		  }
	//	
	
	
}
