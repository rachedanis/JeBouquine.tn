package com.framework.jeBouquine.dao;

import java.util.Collection;

import com.framework.jeBouquine.entities.Ouvrage;
import com.framework.jeBouquine.genericRepositry.GenericRepository;

public interface OuvrageDao{
	
	
	public Ouvrage findById(String id);
	public Collection<Ouvrage> findByCategorie(String categorie);
	public Collection<Ouvrage> findByAutheur(String autheur); 
	public Collection<Ouvrage> findByTitre(String titre);
	public Collection<Ouvrage> findByKeyWord(String keyWord);
	public void saveOrupdate(Ouvrage ouvrage);
	public void delete(Ouvrage ouvrage);
	

}
