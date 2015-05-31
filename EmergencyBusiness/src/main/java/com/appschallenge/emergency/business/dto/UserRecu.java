package com.appschallenge.emergency.business.dto;

import java.util.Date;

public class UserRecu {
	private String autresInfos;
	private short cholesterol;
	private Date dateNaissance;
	private short diabete;
	private String gcmDeviceId;
	private short groupSanguin;
	private String nom;
	private String prenom;
	private short sexe;
	private String telephone;

	public String getAutresInfos() {
		return autresInfos;
	}

	public short getCholesterol() {
		return cholesterol;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public short getDiabete() {
		return diabete;
	}

	public String getGcmDeviceId() {
		return gcmDeviceId;
	}

	public short getGroupSanguin() {
		return groupSanguin;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public short getSexe() {
		return sexe;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setAutresInfos(final String autresInfos) {
		this.autresInfos = autresInfos;
	}

	public void setCholesterol(final short cholesterol) {
		this.cholesterol = cholesterol;
	}

	public void setDateNaissance(final Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setDiabete(final short diabete) {
		this.diabete = diabete;
	}

	public void setGcmDeviceId(final String gcmDeviceId) {
		this.gcmDeviceId = gcmDeviceId;
	}

	public void setGroupSanguin(final short groupSanguin) {
		this.groupSanguin = groupSanguin;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public void setSexe(final short sexe) {
		this.sexe = sexe;
	}

	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}
}
