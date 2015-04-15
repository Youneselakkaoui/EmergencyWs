package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String telephone;

	@Lob
	@Column(name="autres_infos")
	private String autresInfos;

	private short cholesterol;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private short diabete;

	@Column(name="group_sanguin")
	private short groupSanguin;

	private String nom;

	private String prenom;

	private short sexe;

	//bi-directional many-to-one association to RecepteursSituation
	@OneToMany(mappedBy="user")
	private List<RecepteursSituation> recepteursSituations;

	//bi-directional many-to-one association to Situation
	@OneToMany(mappedBy="user")
	private List<Situation> situations;

	//bi-directional many-to-one association to SuiviAlerte
	@OneToMany(mappedBy="user")
	private List<SuiviAlerte> suiviAlertes;

	public User() {
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAutresInfos() {
		return this.autresInfos;
	}

	public void setAutresInfos(String autresInfos) {
		this.autresInfos = autresInfos;
	}

	public short getCholesterol() {
		return this.cholesterol;
	}

	public void setCholesterol(short cholesterol) {
		this.cholesterol = cholesterol;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public short getDiabete() {
		return this.diabete;
	}

	public void setDiabete(short diabete) {
		this.diabete = diabete;
	}

	public short getGroupSanguin() {
		return this.groupSanguin;
	}

	public void setGroupSanguin(short groupSanguin) {
		this.groupSanguin = groupSanguin;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public short getSexe() {
		return this.sexe;
	}

	public void setSexe(short sexe) {
		this.sexe = sexe;
	}

	public List<RecepteursSituation> getRecepteursSituations() {
		return this.recepteursSituations;
	}

	public void setRecepteursSituations(List<RecepteursSituation> recepteursSituations) {
		this.recepteursSituations = recepteursSituations;
	}

	public RecepteursSituation addRecepteursSituation(RecepteursSituation recepteursSituation) {
		getRecepteursSituations().add(recepteursSituation);
		recepteursSituation.setUser(this);

		return recepteursSituation;
	}

	public RecepteursSituation removeRecepteursSituation(RecepteursSituation recepteursSituation) {
		getRecepteursSituations().remove(recepteursSituation);
		recepteursSituation.setUser(null);

		return recepteursSituation;
	}

	public List<Situation> getSituations() {
		return this.situations;
	}

	public void setSituations(List<Situation> situations) {
		this.situations = situations;
	}

	public Situation addSituation(Situation situation) {
		getSituations().add(situation);
		situation.setUser(this);

		return situation;
	}

	public Situation removeSituation(Situation situation) {
		getSituations().remove(situation);
		situation.setUser(null);

		return situation;
	}

	public List<SuiviAlerte> getSuiviAlertes() {
		return this.suiviAlertes;
	}

	public void setSuiviAlertes(List<SuiviAlerte> suiviAlertes) {
		this.suiviAlertes = suiviAlertes;
	}

	public SuiviAlerte addSuiviAlerte(SuiviAlerte suiviAlerte) {
		getSuiviAlertes().add(suiviAlerte);
		suiviAlerte.setUser(this);

		return suiviAlerte;
	}

	public SuiviAlerte removeSuiviAlerte(SuiviAlerte suiviAlerte) {
		getSuiviAlertes().remove(suiviAlerte);
		suiviAlerte.setUser(null);

		return suiviAlerte;
	}

}