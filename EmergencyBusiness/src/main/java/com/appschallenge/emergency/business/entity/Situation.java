package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the situation database table.
 *
 */
@Entity
@NamedQuery(name = "Situation.findAll", query = "SELECT s FROM Situation s")
public class Situation implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Alerte
	@OneToMany(mappedBy = "situation", cascade = CascadeType.PERSIST)
	private List<Alerte> alertes;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_situation")
	private int idSituation;

	@Lob
	private String message;

	@Column(name = "pieces_jointes")
	private short piecesJointes;

	// bi-directional many-to-one association to RecepteursSituation
	@OneToMany(mappedBy = "situation")
	private List<RecepteursSituation> recepteursSituations;

	private String titre;

	@Column(name = "type_envoi")
	private short typeEnvoi;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "id_emetteur")
	private User user;

	public Situation() {
	}

	public Alerte addAlerte(final Alerte alerte) {
		getAlertes().add(alerte);
		alerte.setSituation(this);

		return alerte;
	}

	public RecepteursSituation addRecepteursSituation(
			final RecepteursSituation recepteursSituation) {
		getRecepteursSituations().add(recepteursSituation);
		recepteursSituation.setSituation(this);

		return recepteursSituation;
	}

	public List<Alerte> getAlertes() {
		return this.alertes;
	}

	public int getIdSituation() {
		return this.idSituation;
	}

	public String getMessage() {
		return this.message;
	}

	public short getPiecesJointes() {
		return this.piecesJointes;
	}

	public List<RecepteursSituation> getRecepteursSituations() {
		return this.recepteursSituations;
	}

	public String getTitre() {
		return this.titre;
	}

	public short getTypeEnvoi() {
		return this.typeEnvoi;
	}

	public User getUser() {
		return this.user;
	}

	public Alerte removeAlerte(final Alerte alerte) {
		getAlertes().remove(alerte);
		alerte.setSituation(null);

		return alerte;
	}

	public RecepteursSituation removeRecepteursSituation(
			final RecepteursSituation recepteursSituation) {
		getRecepteursSituations().remove(recepteursSituation);
		recepteursSituation.setSituation(null);

		return recepteursSituation;
	}

	public void setAlertes(final List<Alerte> alertes) {
		this.alertes = alertes;
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
			final List<RecepteursSituation> recepteursSituations) {
		this.recepteursSituations = recepteursSituations;
	}

	public void setTitre(final String titre) {
		this.titre = titre;
	}

	public void setTypeEnvoi(final short typeEnvoi) {
		this.typeEnvoi = typeEnvoi;
	}

	public void setUser(final User user) {
		this.user = user;
	}

}