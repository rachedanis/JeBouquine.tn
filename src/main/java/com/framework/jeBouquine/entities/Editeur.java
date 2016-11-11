package com.framework.jeBouquine.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Editeur {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EDITEUR_ID")
	private int id;
	@Column(name="NOM_EDITEUR") 
	private String nom;
	@Column(name="PRESENTATION_EDITEUR")
	private String presentation;
	
	@ManyToMany
	//(mappedBy="editeurs")
	private Collection<Ouvrage> auteur= new ArrayList<Ouvrage>();
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	
	
	
	

	


}
