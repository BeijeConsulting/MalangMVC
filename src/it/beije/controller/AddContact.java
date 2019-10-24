package it.beije.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class AddContact {

	public static void writeCSV(String cognome,String nome, String email, String telefono) throws IOException{
		
		File f = new File("C:\\temp\\CSVContainer.txt");
		if(f.exists()) {}
		else
		{
		FileWriter fileWriter = new FileWriter("C:\\temp\\CSVContainer.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		final String firstROW="COGNOME;NOME;TELEFONO;EMAIL;";
		bufferedWriter.write(firstROW);
		}
		FileReader filereader = new FileReader(f);
		PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
		BufferedWriter bufferedWriter = new BufferedWriter(pw);
		bufferedWriter.newLine();
		bufferedWriter.write(cognome+";");
		bufferedWriter.write(nome+";");
		bufferedWriter.write(email+";");
		bufferedWriter.write(telefono+";");
		
		System.out.println("Contatto aggiunto in rubrica!");
		filereader.close();
		bufferedWriter.close();
		
	}
}
