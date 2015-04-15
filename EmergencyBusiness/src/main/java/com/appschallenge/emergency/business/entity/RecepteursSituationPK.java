package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the recepteurs_situation database table.
 * 
 */
@Embeddable
public class RecepteursSituationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_recepteur", insertable=false, updatable=false)
	private String idRecepteur;

	@Column(name="id_situation", insertable=false, updatable=false)
	private int idSituation;

	public RecepteursSituationPK() {
	}
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RecepteursSituationPK)) {
			return false;
		}
		RecepteursSituationPK castOther = (RecepteursSituationPK)other;
		return 
			this.idRecepteur.equals(castOther.idRecepteur)
			&& (this.idSituation == castOther.idSituation);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRecepteur.hashCode();
		hash = hash * prime + this.idSituation;
		
		return hash;
	}
}