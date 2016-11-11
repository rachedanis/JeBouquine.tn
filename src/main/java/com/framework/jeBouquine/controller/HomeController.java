package com.framework.jeBouquine.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.framework.jeBouquine.dao.OuvrageDao;
import com.framework.jeBouquine.entities.Auteur;
import com.framework.jeBouquine.entities.Editeur;
import com.framework.jeBouquine.entities.Ouvrage;
import com.framework.jeBouquine.formModel.KeyWord;

 @org.springframework.stereotype.Controller
 
public class HomeController {
	 @Autowired
	 OuvrageDao ouvrageDao;
	 
		@ModelAttribute("searchKeyWord")
	 	public KeyWord addKeyWord()
	 	{
	 		return new KeyWord();
	 	}
	
		
		
		 @RequestMapping(value = "/home", method = RequestMethod.POST)
		    public String doSearchKeyWord( @ModelAttribute("searchKeyWord")KeyWord keyWord,Model model) {
			 
			 	//model.addAttribute("ouvrage",ouvrageDao.findById(" "));
			
		     
		       
		        return "searchKeyWord";
		    }
		 
	 
		@RequestMapping(value = "/home", method = RequestMethod.GET)
		public String viewHome(Model model)  {
			// TODO Auto-generated method stub
			
		//model.addAttribute("searchKeyWord", new KeyWord());
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
				ouvrageDao.saveOrupdate(ouvrage);
			
			return "homePage";	
		}
		 
 
 
 
}
