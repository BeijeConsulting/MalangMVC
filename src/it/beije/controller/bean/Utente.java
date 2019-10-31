package it.beije.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

@Entity
@Table(name="utenti")
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;

	@Column (name="cognome")
	private String cognome;
	
	@Column (name="nome")
	private String nome;
	
	@Column (name="email")
	private String email;
	
	@OneToMany
	private List<UtenteComputer> rel;
	
	@Transient
	private List<Computer> pcs=new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<UtenteComputer> getRel() {
		return rel;
	}

	public void setRel(List<UtenteComputer> rel) {
		this.rel = rel;
	}

	public List<Computer> getPcs() {
		return pcs;
	}

	public void setPcs(List<Computer> pcs) {
		this.pcs = pcs;
	}

	public Utente() {
		
	}
	
	public Utente(String nome,String cognome,String email) {
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getInsertQuery() {
		StringBuilder builder=new StringBuilder("INSERT INTO rubrica (nome,cognome,email,telefono) VALUES ('");
		builder.append(nome+"','");
		builder.append(cognome+"','");
		builder.append(email+"','");
		System.out.println(builder.toString());
		return builder.toString();
	}
	
	public void updateComputerList() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MalangMVC");
		EntityManager entityManager = factory.createEntityManager();
		
		TypedQuery<Computer> query;
		
		pcs.clear();
		
		if (rel!=null)
		for (UtenteComputer r:rel) {
			query=entityManager.createQuery("Select c FROM Computer c WHERE c.id='"+r.getIdComputer()+"'",Computer.class);
			pcs.add(query.getSingleResult());
		}
	}
	
}
