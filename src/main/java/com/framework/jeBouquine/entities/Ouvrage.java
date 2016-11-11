package com.framework.jeBouquine.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ouvrage {
	
	@Id
	@Column(name="OUVRAGE_ID")
	
	private String id;
	private String nom;
	private String genre ;
	private String categorie;
	private int  prix;
	private String nbrPages;
	private int  noteClient;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Auteur> auteurs= new ArrayList<Auteur>();
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Editeur> editeurs= new ArrayList<Editeur>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getNbrPages() {
		return nbrPages;
	}
	public void setNbrPages(String nbrPages) {
		this.nbrPages = nbrPages;
	}
	public int getNoteClient() {
		return noteClient;
	}
	public void setNoteClient(int noteClient) {
		this.noteClient = noteClient;
	}
	
	public Collection<Auteur> getAuteur() {
		return auteurs;
	}
	public void setAuteur(Collection<Auteur> auteurs) {
		this.auteurs = auteurs;
	}
	
	public Collection<Editeur> getEditeur() {
		return editeurs;
	}
	public void setEditeur(Collection<Editeur> editeurs) {
		this.editeurs = editeurs;
	}

	
	
	

}
