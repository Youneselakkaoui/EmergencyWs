package com.appschallenge.emergency.business.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String autresInfos;

	private short cholesterol;

	private Date dateNaissance;

	private short diabete;

	private short groupSanguin;

	private String nom;

	private String prenom;

	private short sexe;

	private String telephone;

	public String getAutresInfos() {
		return this.autresInfos;
	}

	public short getCholesterol() {
		return this.cholesterol;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public short getDiabete() {
		return this.diabete;
	}

	public short getGroupSanguin() {
		return this.groupSanguin;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public short getSexe() {
		return this.sexe;
	}

	public String getTelephone() {
		return this.telephone;
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