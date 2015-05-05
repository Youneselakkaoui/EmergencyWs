package com.appschallenge.emergency.business.dto;

import java.io.Serializable;
import javax.persistence.*;


public class RecepteursSituationPKDTO  {



	private String idRecepteur;

	
	private int idSituation;


	public String getIdRecepteur() {
		return this.idRecepteur;
	}
	public void setIdRecepteur(String idRecepteur) {
		this.idRecepteur = idRecepteur;
	}
	public int getIdSituation() {
		return this.idSituation;
	}
	public void setIdSituation(int idSituation) {
		this.idSituation = idSituation;
	}

	
}