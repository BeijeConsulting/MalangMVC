package it.beije.controller.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "utente_computer")

	public class Usercomputer {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;	
		
		
		@Column(name="id_utente")
		private String id_utente;
		
		@Column(name="id_computer")
		private String id_computer;
		
		@Column(name="data_consegna")
		private String data_consegna ;
		
		@Column(name="data_restituzione")
		private String data_restituzione;
		
		@Column(name="note")
		private String note;
		
		
		public int getId() {
			return id;
		}


		public void setId(int id) {
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


		public String getData_consegna() {
			return data_consegna;
		}


		public void setData_consegna(String data_consegna) {
			this.data_consegna = data_consegna;
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
			builder.append(" id_utente: ").append(id_utente).append('\n');
			builder.append("id_computer : ").append(id_computer).append('\n');
			builder.append("data_consegna : ").append(data_consegna).append('\n');
			builder.append("data_restituzione : ").append(data_restituzione).append('\n');
			builder.append("note : ").append(note).append('\n');
			
			
			return builder.toString();
		}
		
		
		
		
		
		
		

}
