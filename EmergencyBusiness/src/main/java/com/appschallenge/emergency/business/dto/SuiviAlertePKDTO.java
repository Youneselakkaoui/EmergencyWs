package com.appschallenge.emergency.business.dto;

import java.io.Serializable;
import javax.persistence.*;


public class SuiviAlertePKDTO extends EmergencyDTO  {

	private static final long serialVersionUID = 1L;

	private String idRecepteur;


	private int idAlerte;


	public String getIdRecepteur() {
		return this.idRecepteur;
	}
	public void setIdRecepteur(String idRecepteur) {
		this.idRecepteur = idRecepteur;
	}
	public int getIdAlerte() {
		return this.idAlerte;
	}
	public void setIdAlerte(int idAlerte) {
		this.idAlerte = idAlerte;
	}

	
}