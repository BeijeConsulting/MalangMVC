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
@Table(name = "computer")
public class Computer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcomputer")
	private int id_computer;
	
	public int getId_computer() {
		return id_computer;
	}

	public void setId_computer(int id_computer) {
		this.id_computer = id_computer;
	}
	
	@OneToMany
	@JoinColumn(name = "id_computer")
	private List<Assignment> utenti;

	public List<Assignment> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Assignment> utenti) {
		this.utenti = utenti;
	}

	@Column(name="modello")
	private String modello;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="cpu")
	private String cpu;
	
	@Column(name="ram")
	private int ram;
	
	@Column(name="HD")
	private String _HD;
	
	@Column(name="SN")
	private String _SN;
	
	@Column(name="note")
	private String note;
	
	@Column(name="SO")
	private String _SO;

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String get_HD() {
		return _HD;
	}

	public void set_HD(String _HD) {
		this._HD = _HD;
	}

	public String get_SN() {
		return _SN;
	}

	public void set_SN(String _SN) {
		this._SN = _SN;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String get_SO() {
		return _SO;
	}

	public void set_SO(String _SO) {
		this._SO = _SO;
	}
}
