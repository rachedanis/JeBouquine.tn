package com.framework.jeBouquine.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;


@Entity
public class Compte {
	@EmbeddedId
	private CompteId id;
	@NotEmpty(message ="please enter your last name")
	private String nom;
	@NotEmpty(message ="please enter your first name")
	private String prenom;
	@Email
	private String email;
	@NotEmpty(message ="please enter your adress")
	private String adresse;
	@NumberFormat
	private String numTel;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public CompteId getId() {
		return id;
	}
	public void setId(CompteId id) {
		this.id = id;
	}
	
	
	

}
