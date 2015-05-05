package com.appschallenge.emergency.business.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;



public class PieceJointeDTO extends EmergencyDTO  {


	private int idPieceJointe;


	private Date dateCreation;

	private String type;

	private String url;

	private AlerteDTO alerte;



	public int getIdPieceJointe() {
		return this.idPieceJointe;
	}

	public void setIdPieceJointe(int idPieceJointe) {
		this.idPieceJointe = idPieceJointe;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public AlerteDTO getAlerte() {
		return this.alerte;
	}

	public void setAlerte(AlerteDTO alerte) {
		this.alerte = alerte;
	}

}