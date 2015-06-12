package com.appschallenge.emergency.business.dto;

import java.util.Date;
import java.util.List;

public class AlerteDTO extends EmergencyDTO {

	/**
	 *
	 */
	private static final long serialVersionUID = -4490330550041785545L;

	private Date dateEnvoi;

	private int idAlerte;

	private String localisationEmX;

	private String localisationEmY;

	private List<PieceJointeDTO> pieceJointes;

	private SituationDTO situation;

	private short statut;

	// private List<SuiviAlerteDTO> suiviAlertes;

	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public int getIdAlerte() {
		return this.idAlerte;
	}

	public String getLocalisationEmX() {
		return this.localisationEmX;
	}

	public String getLocalisationEmY() {
		return this.localisationEmY;
	}

	// public List<PieceJointeDTO> getPieceJointes() {
	// return this.pieceJointes;
	// }

	public List<PieceJointeDTO> getPieceJointes() {
		return pieceJointes;
	}

	public SituationDTO getSituation() {
		return this.situation;
	}

	// public List<SuiviAlerteDTO> getSuiviAlertes() {
	// return this.suiviAlertes;
	// }

	public short getStatut() {
		return this.statut;
	}

	// public List<SuiviAlerteDTO> getSuiviAlertes() {
	// return suiviAlertes;
	// }

	public void setDateEnvoi(final Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public void setIdAlerte(final int idAlerte) {
		this.idAlerte = idAlerte;
	}

	// public void setPieceJointes(final List<PieceJointeDTO> pieceJointes) {
	// this.pieceJointes = pieceJointes;
	// }

	public void setLocalisationEmX(final String localisationEmX) {
		this.localisationEmX = localisationEmX;
	}

	public void setLocalisationEmY(final String localisationEmY) {
		this.localisationEmY = localisationEmY;
	}

	public void setPieceJointes(final List<PieceJointeDTO> pieceJointes) {
		this.pieceJointes = pieceJointes;
	}

	public void setSituation(final SituationDTO situation) {
		this.situation = situation;
	}

	public void setStatut(final short statut) {
		this.statut = statut;
	}

	// public void setSuiviAlertes(final List<SuiviAlerteDTO> suiviAlertes) {
	// this.suiviAlertes = suiviAlertes;
	// }

	// public void setSuiviAlertes(final List<SuiviAlerteDTO> suiviAlertes) {
	// this.suiviAlertes = suiviAlertes;
	// }

}