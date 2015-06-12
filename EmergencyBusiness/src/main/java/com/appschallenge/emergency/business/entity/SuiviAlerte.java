package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the suivi_alerte database table.
 *
 */
@Entity
@Table(name = "suivi_alerte")
@NamedQuery(name = "SuiviAlerte.findAll", query = "SELECT s FROM SuiviAlerte s")
public class SuiviAlerte implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Alerte
	@ManyToOne
	@JoinColumn(name = "id_alerte", insertable = false, updatable = false)
	private Alerte alerte;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_maj")
	private Date dateMaj;

	@Column(name = "etat_suivi")
	private short etatSuivi;

	@EmbeddedId
	private SuiviAlertePK id;

	@Column(name = "localisation_re_x")
	private String localisationReX;

	@Column(name = "localisation_re_y")
	private String localisationReY;

	// bi-directional many-to-one association to User
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_recepteur", insertable = false, updatable = false)
	private User user;

	public SuiviAlerte() {
	}

	public Alerte getAlerte() {
		return this.alerte;
	}

	public Date getDateMaj() {
		return this.dateMaj;
	}

	public short getEtatSuivi() {
		return this.etatSuivi;
	}

	public SuiviAlertePK getId() {
		return this.id;
	}

	public String getLocalisationReX() {
		return this.localisationReX;
	}

	public String getLocalisationReY() {
		return this.localisationReY;
	}

	public User getUser() {
		return this.user;
	}

	public void setAlerte(final Alerte alerte) {
		this.alerte = alerte;
	}

	public void setDateMaj(final Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public void setEtatSuivi(final short etatSuivi) {
		this.etatSuivi = etatSuivi;
	}

	public void setId(final SuiviAlertePK id) {
		this.id = id;
	}

	public void setLocalisationReX(final String localisationReX) {
		this.localisationReX = localisationReX;
	}

	public void setLocalisationReY(final String localisationReY) {
		this.localisationReY = localisationReY;
	}

	public void setUser(final User user) {
		this.user = user;
	}

}