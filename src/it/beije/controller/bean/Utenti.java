package it.beije.controller.bean;

import org.springframework.stereotype.Component;
@Component
public class Utenti {
	
	private String id;
	private String nome ;
	private String cognome;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id : ").append(id).append('\n');
		builder.append("nome : ").append(nome).append('\n');
		builder.append("cognome : ").append(cognome).append('\n');
		builder.append("email : ").append(email).append('\n');
		return builder.toString();
	}
}