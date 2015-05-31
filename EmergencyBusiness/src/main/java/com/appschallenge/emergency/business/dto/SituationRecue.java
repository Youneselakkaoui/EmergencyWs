package com.appschallenge.emergency.business.dto;

public class SituationRecue {
	private int idSituation;
	private String message;
	private short piecesJointes;
	private String titre;
	private short typeEnvoi;
	private UserRecu user;

	public int getIdSituation() {
		return idSituation;
	}

	public String getMessage() {
		return message;
	}

	public short getPiecesJointes() {
		return piecesJointes;
	}

	public String getTitre() {
		return titre;
	}

	public short getTypeEnvoi() {
		return typeEnvoi;
	}

	public UserRecu getUser() {
		return user;
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

	public void setTitre(final String titre) {
		this.titre = titre;
	}

	public void setTypeEnvoi(final short typeEnvoi) {
		this.typeEnvoi = typeEnvoi;
	}

	public void setUser(final UserRecu user) {
		this.user = user;
	}
}
