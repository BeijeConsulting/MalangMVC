package it.beije.controller.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	
	@Column(name="cognome")
	private String cognome;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="nome")
	private String nome;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
		
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cognome : ").append(cognome).append('\n');
		builder.append("email : ").append(email).append('\n');
		builder.append("nome : ").append(nome).append('\n');

		return builder.toString();
	}
}


