package it.beije.controller.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "utente_computer")
public class UtenteComputer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	
	
	
	@Column(name="id_utente")
	private int id_utente;
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_utente")
//	private Contatto utente;
	
	@Column(name="id_computer")
	private int id_computer;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_computer")
//	private Computer computer;
	
	@Column(name ="data_consegna")
	private Date data_consegna;
	
	@Column(name ="data_restituizione")
	private Date data_restituizione;
	
	@Column(name="note")
	private String note;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_utente() {
		return id_utente;
	}
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
	
	public int  getId_Computer() {
		return id_computer;
	}
	public void setId_Computer(int id_computer) {
		this.id_computer = id_computer;
	}
	
	public Date getData_consegna() {
		return data_consegna;
	}
	public void setData_consegna(Date data_consegna) {
		this.data_consegna = data_consegna;
	}
	
	public Date getData_restituizione() {
		return data_consegna;
	}
	public void setData_restituizione(Date data_restituizione) {
		this.data_restituizione = data_restituizione;
	}
	
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id_utente : ").append(id_utente).append('\n');
		builder.append("id_computer : ").append(id_computer).append('\n');
		builder.append("data_consegna : ").append(data_consegna).append('\n');
		builder.append("note : ").append(note).append('\n');
		return builder.toString();
	}
}
