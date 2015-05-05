package com.appschallenge.emergency.business.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class SuiviAlerteDTO extends EmergencyDTO  {



	private AlerteDTO alerte;

	
	private Date dateMaj;


	private short etatSuivi;


	private SuiviAlertePKDTO id;


	private String localisationReX;


	private String localisationReY;

	private UserDTO user;



	public AlerteDTO getAlerte() {
		return this.alerte;
	}

	public Date getDateMaj() {
		return this.dateMaj;
	}

	public short getEtatSuivi() {
		return this.etatSuivi;
	}

	public SuiviAlertePKDTO getId() {
		return this.id;
	}

	public String getLocalisationReX() {
		return this.localisationReX;
	}

	public String getLocalisationReY() {
		return this.localisationReY;
	}

	public UserDTO getUser() {
		return this.user;
	}

	public void setAlerte(final AlerteDTO alerte) {
		this.alerte = alerte;
	}

	public void setDateMaj(final Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public void setEtatSuivi(final short etatSuivi) {
		this.etatSuivi = etatSuivi;
	}

	public void setId(final SuiviAlertePKDTO id) {
		this.id = id;
	}

	public void setLocalisationReX(final String localisationReX) {
		this.localisationReX = localisationReX;
	}

	public void setLocalisationReY(final String localisationReY) {
		this.localisationReY = localisationReY;
	}

	public void setUser(final UserDTO user) {
		this.user = user;
	}

}