package com.framework.jeBouquine.app;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;


import com.framework.jeBouquine.dao.OuvrageDao;

import com.framework.jeBouquine.entities.Auteur;
import com.framework.jeBouquine.entities.Editeur;
import com.framework.jeBouquine.entities.Ouvrage;

public class TestApp {
	
	@Autowired 
	private  OuvrageDao ouvrageDao;
	
	

	public OuvrageDao getOuvrageDao() {
		return ouvrageDao;
	}



	public void setOuvrageDao(OuvrageDao ouvrageDao) {
		this.ouvrageDao = ouvrageDao;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		Collection<Auteur> auteurs = new ArrayList<Auteur>();
		Collection<Ouvrage> ouvrages = new ArrayList<Ouvrage>();
		
		Auteur auteur = new Auteur();
		//auteur.setId(1);
		auteur.setNom("rached");
		auteur.setPrenom("anis");
		
		
		auteur.setPresentation("né le 10/1993");
		auteurs.add(auteur);
		
		//
		Collection<Editeur> editeurs = new ArrayList<Editeur>();
		Editeur editeur = new Editeur();
		//editeur.setId(1);
		editeur.setNom("editeur1");
		editeur.setPresentation("description editeur ici  ");
		editeurs.add(editeur);
		Ouvrage ouvrage = new Ouvrage();
		
		ouvrage.setAuteur(auteurs);
		ouvrage.setCategorie("categorie");
		ouvrage.setEditeur(editeurs);
		ouvrage.setGenre("genre1");
		ouvrage.setId("1");
		ouvrage.setNbrPages("200");
		ouvrage.setNom("titre1");
		ouvrage.setNoteClient(10);
		ouvrage.setPrix(200);
		ouvrages.add(ouvrage);
		auteur.setListOfOuvrages(ouvrages);
		
	TestApp testApp = new TestApp();
	testApp.getOuvrageDao().saveOrupdate(ouvrage);
		

	}

}
