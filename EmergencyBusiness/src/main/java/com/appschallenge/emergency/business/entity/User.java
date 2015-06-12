package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the user database table.
 *
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	@Column(name = "autres_infos")
	private String autresInfos;

	private short cholesterol;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance")
	private Date dateNaissance;

	private short diabete;

	@Column(name = "digits_id")
	private BigInteger digitsId;

	@Column(name = "gcm_device_id")
	private String gcmDeviceId;

	@Column(name = "group_sanguin")
	private short groupSanguin;

	private String nom;

	private String prenom;

	// @OneToMany(mappedBy = "user")
	// private List<RecepteursSituation> recepteursSituations;

	private short sexe;

	// bi-directional many-to-one association to RecepteursSituation
	@OneToMany(mappedBy = "user")
	private List<Situation> situations;
	@OneToMany(mappedBy = "user")
	private List<SuiviAlerte> suiviAlertes;

	@Id
	private String telephone;

	// bi-directional many-to-one association to Situation
	public User() {
	}

	// bi-directional many-to-one association to SuiviAlerte
	// public RecepteursSituation addRecepteursSituation(
	// final RecepteursSituation recepteursSituation) {
	// getRecepteursSituations().add(recepteursSituation);
	// recepteursSituation.setUser(this);
	//
	// return recepteursSituation;
	// }

	public Situation addSituation(final Situation situation) {
		getSituations().add(situation);
		situation.setUser(this);

		return situation;
	}

	public SuiviAlerte addSuiviAlerte(final SuiviAlerte suiviAlerte) {
		getSuiviAlertes().add(suiviAlerte);
		suiviAlerte.setUser(this);

		return suiviAlerte;
	}

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

	public BigInteger getDigitsId() {
		return digitsId;
	}

	public String getGcmDeviceId() {
		return gcmDeviceId;
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

	// public List<RecepteursSituation> getRecepteursSituations() {
	// return this.recepteursSituations;
	// }

	public short getSexe() {
		return this.sexe;
	}

	public List<Situation> getSituations() {
		return this.situations;
	}

	public List<SuiviAlerte> getSuiviAlertes() {
		return this.suiviAlertes;
	}

	public String getTelephone() {
		return this.telephone;
	}

	// public RecepteursSituation removeRecepteursSituation(
	// final RecepteursSituation recepteursSituation) {
	// getRecepteursSituations().remove(recepteursSituation);
	// recepteursSituation.setUser(null);
	//
	// return recepteursSituation;
	// }

	public Situation removeSituation(final Situation situation) {
		getSituations().remove(situation);
		situation.setUser(null);

		return situation;
	}

	public SuiviAlerte removeSuiviAlerte(final SuiviAlerte suiviAlerte) {
		getSuiviAlertes().remove(suiviAlerte);
		suiviAlerte.setUser(null);

		return suiviAlerte;
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

	public void setDigitsId(final BigInteger digitsId) {
		this.digitsId = digitsId;
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

	// public void setRecepteursSituations(
	// final List<RecepteursSituation> recepteursSituations) {
	// this.recepteursSituations = recepteursSituations;
	// }

	public void setSexe(final short sexe) {
		this.sexe = sexe;
	}

	public void setSituations(final List<Situation> situations) {
		this.situations = situations;
	}

	public void setSuiviAlertes(final List<SuiviAlerte> suiviAlertes) {
		this.suiviAlertes = suiviAlertes;
	}

	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}

}