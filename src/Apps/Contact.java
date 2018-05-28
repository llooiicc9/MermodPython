package Apps;

import java.io.Serializable;


//SMB
public class Contact implements Serializable{

	private String nom;
	private String prenom;
	private String telephone;
	private String adresse;
	private String mail;
	
	public Contact(String nom, String prenom, String telephone, String adresse, String mail) {
		
		this.nom=nom;
		this.prenom=prenom;
		this.telephone=telephone;
		this.adresse=adresse;
		this.mail=mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
