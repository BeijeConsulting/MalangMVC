package it.beije.model;


public class Utente {

	private String cognome;
	private String nome;
	private String email;
	private String telefono;
	
	public Utente() {
		
	}
	
	public Utente(String nome,String cognome,String email,String telefono) {
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.telefono=telefono;
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
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getInsertQuery() {
		StringBuilder builder=new StringBuilder("INSERT INTO rubrica (nome,cognome,email,telefono) VALUES ('");
		builder.append(nome+"','");
		builder.append(cognome+"','");
		builder.append(email+"','");
		builder.append(telefono+"')");
		System.out.println(builder.toString());
		return builder.toString();
	}
	
	public boolean isValid() {
		if (cognome != null || nome != null)
		{
			if (email.contains("@")) {
				for (char ch:telefono.toCharArray())
				{
					if (!((ch>='0'&&(ch<='9'))||(ch==' ')||(ch=='+')))
					{
						return false;
					}
				}
				return true;
			}
			return false;
		}
		return false;
	}
	
	public String toString() {
		return nome+'\n'+cognome+'\n'+telefono+'\n'+email;
	}
	
}
