package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the alerte database table.
 *
 */
@Entity
@NamedQuery(name = "Alerte.findAll", query = "SELECT a FROM Alerte a")
public class Alerte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_envoi")
	private Date dateEnvoi;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alerte")
	private int idAlerte;

	@Column(name = "localisation_em_x")
	private String localisationEmX;

	@Column(name = "localisation_em_y")
	private String localisationEmY;

	// bi-directional many-to-one association to PieceJointe
	@OneToMany(mappedBy = "alerte")
	private List<PieceJointe> pieceJointes;

	// bi-directional many-to-one association to Situation
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_situation")
	private Situation situation;

	private short statut;

	// bi-directional many-to-one association to SuiviAlerte
	@OneToMany(mappedBy = "alerte", cascade = CascadeType.PERSIST)
	private List<SuiviAlerte> suiviAlertes;

	public Alerte() {
	}

	public PieceJointe addPieceJointe(final PieceJointe pieceJointe) {
		getPieceJointes().add(pieceJointe);
		pieceJointe.setAlerte(this);

		return pieceJointe;
	}

	public SuiviAlerte addSuiviAlerte(final SuiviAlerte suiviAlerte) {
		getSuiviAlertes().add(suiviAlerte);
		suiviAlerte.setAlerte(this);

		return suiviAlerte;
	}

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

	public List<PieceJointe> getPieceJointes() {
		return this.pieceJointes;
	}

	public Situation getSituation() {
		return this.situation;
	}

	public short getStatut() {
		return this.statut;
	}

	public List<SuiviAlerte> getSuiviAlertes() {
		return this.suiviAlertes;
	}

	public PieceJointe removePieceJointe(final PieceJointe pieceJointe) {
		getPieceJointes().remove(pieceJointe);
		pieceJointe.setAlerte(null);

		return pieceJointe;
	}

	public SuiviAlerte removeSuiviAlerte(final SuiviAlerte suiviAlerte) {
		getSuiviAlertes().remove(suiviAlerte);
		suiviAlerte.setAlerte(null);

		return suiviAlerte;
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

	public void setPieceJointes(final List<PieceJointe> pieceJointes) {
		this.pieceJointes = pieceJointes;
	}

	public void setSituation(final Situation situation) {
		this.situation = situation;
	}

	public void setStatut(final short statut) {
		this.statut = statut;
	}

	public void setSuiviAlertes(final List<SuiviAlerte> suiviAlertes) {
		this.suiviAlertes = suiviAlertes;
	}

}