package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the suivi_alerte database table.
 * 
 */
@Embeddable
public class SuiviAlertePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_recepteur", insertable=false, updatable=false)
	private String idRecepteur;

	@Column(name="id_alerte", insertable=false, updatable=false)
	private int idAlerte;

	public SuiviAlertePK() {
	}
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SuiviAlertePK)) {
			return false;
		}
		SuiviAlertePK castOther = (SuiviAlertePK)other;
		return 
			this.idRecepteur.equals(castOther.idRecepteur)
			&& (this.idAlerte == castOther.idAlerte);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRecepteur.hashCode();
		hash = hash * prime + this.idAlerte;
		
		return hash;
	}
}