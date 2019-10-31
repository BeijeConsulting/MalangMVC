package it.beije.controller.bean;
import org.springframework.stereotype.Component;
public class Utente_computer {
	private String id;
	private String id_utente;
	private String id_computer;
	private String data_cosegna;
	private String data_restituzione;
	private String note;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_utente() {
		return id_utente;
	}
	public void setId_utente(String id_utente) {
		this.id_utente = id_utente;
	}
	public String getId_computer() {
		return id_computer;
	}
	public void setId_computer(String id_computer) {
		this.id_computer = id_computer;
	}
	public String getData_cosegna() {
		return data_cosegna;
	}
	public void setData_cosegna(String data_cosegna) {
		this.data_cosegna = data_cosegna;
	}
	public String getData_restituzione() {
		return data_restituzione;
	}
	public void setData_restituzione(String data_restituzione) {
		this.data_restituzione = data_restituzione;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id : ").append(id).append('\n');
		builder.append("id_utente : ").append(id_utente).append('\n');
		builder.append("id_computer : ").append(id_computer).append('\n');
		builder.append("data_consegna : ").append(data_cosegna).append('\n');
		builder.append("data_restituzione : ").append(data_restituzione).append('\n');
		builder.append("note : ").append(note).append('\n');
		return builder.toString();
	}

	

}
