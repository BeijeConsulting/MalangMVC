package it.beije.controller.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users_computer")
public class Assignment {
	
	public Date getConsegna() {
		return consegna;
	}

	public void setConsegna(Date consegna) {
		this.consegna = consegna;
	}

	public Date getRestituzione() {
		return restituzione;
	}

	public void setRestituzione(Date restituzione) {
		this.restituzione = restituzione;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusers_computer")
	private int idusers_computer;	
	
	@Column(name="consegna")
	private Date consegna;
	
	@Column(name="restituzione")
	private Date restituzione;
	
	@Column(name="note")
	private String note;

	@Column(name="id_utente")
	private int id_utente;
	
	@Column(name="id_computer")
	private int id_computer;

	public int getIdusers_computer() {
		return idusers_computer;
	}

	public void setIdusers_computer(int idusers_computer) {
		this.idusers_computer = idusers_computer;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	public int getId_computer() {
		return id_computer;
	}

	public void setId_computer(int id_computer) {
		this.id_computer = id_computer;
	}
}

