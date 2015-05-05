
package com.appschallenge.emergency.business.dto;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;




public class AlerteDTO extends EmergencyDTO {


	
	private int idAlerte;

	
	private Date dateEnvoi;

	
	private String localisationEmX;

	
	private String localisationEmY;

	private short statut;



	private SituationDTO situation;


	private List<PieceJointeDTO> pieceJointes;

	
	private List<SuiviAlerteDTO> suiviAlertes;



	public int getIdAlerte() {
		return this.idAlerte;
	}

	public void setIdAlerte(int idAlerte) {
		this.idAlerte = idAlerte;
	}

	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public String getLocalisationEmX() {
		return this.localisationEmX;
	}

	public void setLocalisationEmX(String localisationEmX) {
		this.localisationEmX = localisationEmX;
	}

	public String getLocalisationEmY() {
		return this.localisationEmY;
	}

	public void setLocalisationEmY(String localisationEmY) {
		this.localisationEmY = localisationEmY;
	}

	public short getStatut() {
		return this.statut;
	}

	public void setStatut(short statut) {
		this.statut = statut;
	}

	public SituationDTO getSituation() {
		return this.situation;
	}

	public void setSituation(SituationDTO situation) {
		this.situation = situation;
	}

	public List<PieceJointeDTO> getPieceJointes() {
		return this.pieceJointes;
	}

	public void setPieceJointes(List<PieceJointeDTO> pieceJointes) {
		this.pieceJointes = pieceJointes;
	}

	
	public List<SuiviAlerteDTO> getSuiviAlertes() {
		return this.suiviAlertes;
	}

	public void setSuiviAlertes(List<SuiviAlerteDTO> suiviAlertes) {
		this.suiviAlertes = suiviAlertes;
	}


}