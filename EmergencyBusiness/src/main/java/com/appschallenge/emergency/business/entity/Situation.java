package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the situation database table.
 * 
 */
@Entity
@NamedQuery(name="Situation.findAll", query="SELECT s FROM Situation s")
public class Situation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_situation")
	private int idSituation;

	@Lob
	private String message;

	@Column(name="pieces_jointes")
	private short piecesJointes;

	private String titre;

	@Column(name="type_envoi")
	private short typeEnvoi;

	//bi-directional many-to-one association to Alerte
	@OneToMany(mappedBy="situation")
	private List<Alerte> alertes;

	//bi-directional many-to-one association to RecepteursSituation
	@OneToMany(mappedBy="situation")
	private List<RecepteursSituation> recepteursSituations;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_emetteur")
	private User user;

	public Situation() {
	}

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

	public List<Alerte> getAlertes() {
		return this.alertes;
	}

	public void setAlertes(List<Alerte> alertes) {
		this.alertes = alertes;
	}

	public Alerte addAlerte(Alerte alerte) {
		getAlertes().add(alerte);
		alerte.setSituation(this);

		return alerte;
	}

	public Alerte removeAlerte(Alerte alerte) {
		getAlertes().remove(alerte);
		alerte.setSituation(null);

		return alerte;
	}

	public List<RecepteursSituation> getRecepteursSituations() {
		return this.recepteursSituations;
	}

	public void setRecepteursSituations(List<RecepteursSituation> recepteursSituations) {
		this.recepteursSituations = recepteursSituations;
	}

	public RecepteursSituation addRecepteursSituation(RecepteursSituation recepteursSituation) {
		getRecepteursSituations().add(recepteursSituation);
		recepteursSituation.setSituation(this);

		return recepteursSituation;
	}

	public RecepteursSituation removeRecepteursSituation(RecepteursSituation recepteursSituation) {
		getRecepteursSituations().remove(recepteursSituation);
		recepteursSituation.setSituation(null);

		return recepteursSituation;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}