package it.beije.controller;

public class ControlloDati{

public static String controlloTel(String telefono) {
	int count=0;
	if (telefono!="")
	{
	if (telefono.charAt(0)=='+'||telefono.charAt(0)=='3')
	{
		for (int i=1; i<telefono.length();i++) {
			for (char c='0'; c<='9';c++) {
				char temp=telefono.charAt(i);
				if (temp=='+') count++;
				if (temp>'9' && temp!=' ' && temp!='+')
				{
					return null;
				}
			}
		}
		if(count>1) return null;
		return telefono;
	}
	else
	{
		return null;
	}
	}
	return null;
}

public static String controlloMail(String email){
	email=email.trim();
	int count=0;
	int count2=0;
	for (int i=0;i<email.length();i++) {
		if (email.charAt(i)=='@') {
			count++;
			for(int j = 0 ; j<email.length(); j++) {
				if(email.charAt(j)=='.') {
					count2++;
				}
			}
		}
	}
	if (count==1&&count2==1) return email;

	else return null;
}

public static String controlloNome(String nome) {
	if(nome.equals("")||nome.contains("  ")||nome.equals(" ")) {
		return null;
	}
	else
		return nome;
}

public static String controlloCognome(String cognome) {
	if (cognome.equals("")||cognome.contains("  ")||cognome.equals(" ")) {
		return null;
	}
	else
		return cognome;
}
}
