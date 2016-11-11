package com.framework.jeBouquine.entities;



import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Auteur {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AUTEUR_ID")
	private int id;
	@Column(name="NOM_AUTEUR") 
	private String nom;
	@Column(name="PRENOM_AUTEUR")
	private String prenom;
	@Column(name="PRESENTATION_AUTEUR")
	private String presentation;
	
	@ManyToMany
	//(mappedBy="auteurs")
	private Collection<Ouvrage> listOfOuvrages= new ArrayList<Ouvrage>();
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
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Collection<Ouvrage> getListOfOuvrages() {
		return listOfOuvrages;
	}
	public void setListOfOuvrages(Collection<Ouvrage> listOfOuvrages) {
		this.listOfOuvrages = listOfOuvrages;
	}

	
	

	
}
