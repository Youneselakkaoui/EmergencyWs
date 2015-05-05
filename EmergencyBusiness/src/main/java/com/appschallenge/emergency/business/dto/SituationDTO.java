package com.appschallenge.emergency.business.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;




public class SituationDTO extends EmergencyDTO {
	

	private int idSituation;


	private String message;


	private short piecesJointes;

	private String titre;

	private short typeEnvoi;

	
	
	private List<AlerteDTO> alertes;

	
	private List<RecepteursSituationDTO> recepteursSituations;


	private UserDTO user;


	public int getIdSituation() {
		return this.idSituation;
	}

	public void setIdSituation(int idSituation) {
		this.idSituation = idSituation;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public short getPiecesJointes() {
		return this.piecesJointes;
	}

	public void setPiecesJointes(short piecesJointes) {
		this.piecesJointes = piecesJointes;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public short getTypeEnvoi() {
		return this.typeEnvoi;
	}

	public void setTypeEnvoi(short typeEnvoi) {
		this.typeEnvoi = typeEnvoi;
	}

	public List<AlerteDTO> getAlertes() {
		return this.alertes;
	}

	public void setAlertes(List<AlerteDTO> alertes) {
		this.alertes = alertes;
	}

	

	public List<RecepteursSituationDTO> getRecepteursSituations() {
		return this.recepteursSituations;
	}

	public void setRecepteursSituations(List<RecepteursSituationDTO> recepteursSituations) {
		this.recepteursSituations = recepteursSituations;
	}


	public UserDTO getUser() {
		return this.user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}