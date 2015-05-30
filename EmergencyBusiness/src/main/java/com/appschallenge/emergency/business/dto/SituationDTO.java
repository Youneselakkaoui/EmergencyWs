package com.appschallenge.emergency.business.dto;

import java.util.List;

public class SituationDTO extends EmergencyDTO {

	private int idSituation;

	private String message;

	private short piecesJointes;

	private List<RecepteursSituationDTO> recepteursSituations;

	private String titre;

	private short typeEnvoi;

	private UserDTO user;

	public int getIdSituation() {
		return this.idSituation;
	}

	public String getMessage() {
		return this.message;
	}

	public short getPiecesJointes() {
		return this.piecesJointes;
	}

	public List<RecepteursSituationDTO> getRecepteursSituations() {
		return this.recepteursSituations;
	}

	public String getTitre() {
		return this.titre;
	}

	public short getTypeEnvoi() {
		return this.typeEnvoi;
	}

	public UserDTO getUser() {
		return this.user;
	}

	public void setIdSituation(final int idSituation) {
		this.idSituation = idSituation;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public void setPiecesJointes(final short piecesJointes) {
		this.piecesJointes = piecesJointes;
	}

	public void setRecepteursSituations(
			final List<RecepteursSituationDTO> recepteursSituations) {
		this.recepteursSituations = recepteursSituations;
	}

	public void setTitre(final String titre) {
		this.titre = titre;
	}

	public void setTypeEnvoi(final short typeEnvoi) {
		this.typeEnvoi = typeEnvoi;
	}

	public void setUser(final UserDTO user) {
		this.user = user;
	}

}