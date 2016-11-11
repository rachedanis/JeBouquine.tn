package com.framework.jeBouquine.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Panier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PANIER_ID")
	private int id;
	@Embedded
	private CompteId compteId;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<IdOuvrageQte> listofIdQte = new ArrayList<IdOuvrageQte>();
	public CompteId getCompteId() {
		return compteId;
	}
	public void setCompteId(CompteId compteId) {
		this.compteId = compteId;
	}
	public Collection<IdOuvrageQte> getListofIdQte() {
		return listofIdQte;
	}
	public void setListofIdQte(Collection<IdOuvrageQte> listofIdQte) {
		this.listofIdQte = listofIdQte;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
