package it.beije.controller.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="computer")
public class Computer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="modello")
	private String modello;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="cpu")
	private String cpu;
	
	@Column(name="ram")
	private int ram;
	
	@Column(name="hd")
	private String hd;
	
	@Column(name="serial_number", unique=true)
	private String serialNumber;
	
	@Column(name="so")
	private String so;
	
	@Column(name="note")
	private String note;
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Transient
	private List<Utente> users;
	
	@OneToMany
	private List<UtenteComputer> rel;
	
	public List<UtenteComputer> getRel() {
		return rel;
	}

	public void setRel(List<UtenteComputer> rel) {
		this.rel = rel;
	}

	public List<Utente> getUsers() {
		return users;
	}

	public void setUsers(List<Utente> users) {
		this.users = users;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Computer [marca=\" + marca + \",modello=" + modello + ",  so=" + so + "]";
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}
}
