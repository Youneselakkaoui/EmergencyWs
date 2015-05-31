package com.appschallenge.emergency.business.dto;

import java.util.Date;

public class AlerteRecue {
	private Date dateEnvoi;

	private int idAlerte;

	private String localisationEmX;

	private String localisationEmY;

	private SituationRecue situation;
	private short statut;

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public int getIdAlerte() {
		return idAlerte;
	}

	public String getLocalisationEmX() {
		return localisationEmX;
	}

	public String getLocalisationEmY() {
		return localisationEmY;
	}

	public SituationRecue getSituation() {
		return situation;
	}

	public short getStatut() {
		return statut;
	}

	public void setDateEnvoi(final Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public void setIdAlerte(final int idAlerte) {
		this.idAlerte = idAlerte;
	}

	public void setLocalisationEmX(final String localisationEmX) {
		this.localisationEmX = localisationEmX;
	}

	public void setLocalisationEmY(final String localisationEmY) {
		this.localisationEmY = localisationEmY;
	}

	public void setSituation(final SituationRecue situation) {
		this.situation = situation;
	}

	public void setStatut(final short statut) {
		this.statut = statut;
	}

}
