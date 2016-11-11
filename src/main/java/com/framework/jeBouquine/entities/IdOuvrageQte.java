package com.framework.jeBouquine.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IdOuvrageQte  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OUVRAGEQTE_ID")
	private int id;
	private String ouvrageId;
	private int quantite;
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getOuvrageId() {
		return ouvrageId;
	}
	public void setOuvrageId(String ouvrageId) {
		this.ouvrageId = ouvrageId;
	}
	

}
