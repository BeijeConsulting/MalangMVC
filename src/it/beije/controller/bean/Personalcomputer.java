package it.beije.controller.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
	@Table(name = "computer")

	public class Personalcomputer {

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
		private String ram;
		
		
		@Column(name="hd")
		private String hd;
		
		@Column(name="serial_number")
		private String serial_number;
		
		@Column(name="note")
		private String note;
		
		@Column(name="so")
		private String so;
		
		
		
		
		
		
		
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



