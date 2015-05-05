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


public class RecepteursSituationDTO extends EmergencyDTO {
	

	private Date dateCreation;


	private Date dateModification;


	private RecepteursSituationPKDTO id;

	
	private SituationDTO situation;

	
	private UserDTO user;


	public Date getDateCreation() {
		return this.dateCreation;
	}

	public Date getDateModification() {
		return this.dateModification;
	}

	public RecepteursSituationPKDTO getId() {
		return this.id;
	}

	public SituationDTO getSituation() {
		return this.situation;
	}

	public UserDTO getUser() {
		return this.user;
	}

	public void setDateCreation(final Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setDateModification(final Date dateModification) {
		this.dateModification = dateModification;
	}

	public void setId(final RecepteursSituationPKDTO id) {
		this.id = id;
	}

	public void setSituation(final SituationDTO situation) {
		this.situation = situation;
	}

	public void setUser(final UserDTO user) {
		this.user = user;
	}

}