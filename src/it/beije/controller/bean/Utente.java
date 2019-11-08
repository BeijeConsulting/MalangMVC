package it.beije.controller.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusers")
	private int idusers;	
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@OneToMany
	@JoinColumn(name = "id_utente")
	private List<Assignment> computer;
	
	public int getIdusers() {
		return idusers;
	}
	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}
	public List<Assignment> getComputer() {
		return computer;
	}
	public void setComputer(List<Assignment> computer) {
		this.computer = computer;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cognome : ").append(cognome).append('\n');
		builder.append("nome : ").append(nome).append('\n');
		builder.append("email : ").append(email).append('\n');
		return builder.toString();
	}
}
