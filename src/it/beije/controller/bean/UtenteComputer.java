package it.beije.controller.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "utente_computer")
public class UtenteComputer {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
    @ManyToOne
    @JoinColumn(name = "id_computer")
    Computer computer;
 
    
    @ManyToOne
    @JoinColumn(name = "id_utente")
    Contatto utenti;

	@Column(name="dataconsegna")
	private String dataconsegna;
	
	@Column(name="datarestituzione")
	private String datarestituzione;
	
	@Column(name="note")
	private String note;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public Contatto getUtenti() {
		return utenti;
	}

	public void setUtenti(Contatto utenti) {
		this.utenti = utenti;
	}

	public String getDataconsegna() {
		return dataconsegna;
	}

	public void setDataconsegna(String dataconsegna) {
		this.dataconsegna = dataconsegna;
	}

	public String getDatarestituzione() {
		return datarestituzione;
	}

	public void setDatarestituzione(String datarestituzione) {
		this.datarestituzione = datarestituzione;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
}
