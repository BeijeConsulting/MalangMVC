package it.beije.controller.bean;

import org.springframework.stereotype.Component;

public class Computer {
	private String id;
	private String modello;
	private String marca;
	private String cpu;
	private String ram;
	private String hd;
	private String serial_number;
	private String note;
	private String so;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id : ").append(id).append('\n');
		builder.append("modello : ").append(modello).append('\n');
		builder.append("marca : ").append(marca).append('\n');
		builder.append("cpu : ").append(cpu).append('\n');
		builder.append("ram : ").append(ram).append('\n');
		builder.append("hd : ").append(hd).append('\n');
		builder.append("serial_number : ").append(serial_number).append('\n');
		builder.append("note : ").append(note).append('\n');
		builder.append("so : ").append(so).append('\n');
		
		return builder.toString();
	}
}
