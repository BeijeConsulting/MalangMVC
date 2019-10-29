package it.beije.controller.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "computer")
public class Computer {

	
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

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
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
	
	@Column(name="sn")
	private String sn;
	
	@Column(name="note")
	private String note;
	
	@Column(name="so")
	private String so;
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("marca : ").append(marca).append('\n');
		builder.append("modello : ").append(modello).append('\n');
		builder.append("cpu : ").append(cpu).append('\n');
		return builder.toString();
	}
	
}
