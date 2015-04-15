package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the alerte database table.
 * 
 */
@Entity
@NamedQuery(name="Alerte.findAll", query="SELECT a FROM Alerte a")
public class Alerte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_alerte")
	private int idAlerte;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_envoi")
	private Date dateEnvoi;

	@Column(name="localisation_em_x")
	private String localisationEmX;

	@Column(name="localisation_em_y")
	private String localisationEmY;

	private short statut;

	//bi-directional many-to-one association to Situation
	@ManyToOne
	@JoinColumn(name="id_situation")
	private Situation situation;

	//bi-directional many-to-one association to PieceJointe
	@OneToMany(mappedBy="alerte")
	private List<PieceJointe> pieceJointes;

	//bi-directional many-to-one association to SuiviAlerte
	@OneToMany(mappedBy="alerte")
	private List<SuiviAlerte> suiviAlertes;

	public Alerte() {
	}

	public int getIdAlerte() {
		return this.idAlerte;
	}

	public void setIdAlerte(int idAlerte) {
		this.idAlerte = idAlerte;
	}

	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public String getLocalisationEmX() {
		return this.localisationEmX;
	}

	public void setLocalisationEmX(String localisationEmX) {
		this.localisationEmX = localisationEmX;
	}

	public String getLocalisationEmY() {
		return this.localisationEmY;
	}

	public void setLocalisationEmY(String localisationEmY) {
		this.localisationEmY = localisationEmY;
	}

	public short getStatut() {
		return this.statut;
	}

	public void setStatut(short statut) {
		this.statut = statut;
	}

	public Situation getSituation() {
		return this.situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public List<PieceJointe> getPieceJointes() {
		return this.pieceJointes;
	}

	public void setPieceJointes(List<PieceJointe> pieceJointes) {
		this.pieceJointes = pieceJointes;
	}

	public PieceJointe addPieceJointe(PieceJointe pieceJointe) {
		getPieceJointes().add(pieceJointe);
		pieceJointe.setAlerte(this);

		return pieceJointe;
	}

	public PieceJointe removePieceJointe(PieceJointe pieceJointe) {
		getPieceJointes().remove(pieceJointe);
		pieceJointe.setAlerte(null);

		return pieceJointe;
	}

	public List<SuiviAlerte> getSuiviAlertes() {
		return this.suiviAlertes;
	}

	public void setSuiviAlertes(List<SuiviAlerte> suiviAlertes) {
		this.suiviAlertes = suiviAlertes;
	}

	public SuiviAlerte addSuiviAlerte(SuiviAlerte suiviAlerte) {
		getSuiviAlertes().add(suiviAlerte);
		suiviAlerte.setAlerte(this);

		return suiviAlerte;
	}

	public SuiviAlerte removeSuiviAlerte(SuiviAlerte suiviAlerte) {
		getSuiviAlertes().remove(suiviAlerte);
		suiviAlerte.setAlerte(null);

		return suiviAlerte;
	}

}