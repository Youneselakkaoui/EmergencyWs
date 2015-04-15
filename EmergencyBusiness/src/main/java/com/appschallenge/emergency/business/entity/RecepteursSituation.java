package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import java.util.Date;

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
 * The persistent class for the recepteurs_situation database table.
 *
 */
@Entity
@Table(name = "recepteurs_situation")
@NamedQuery(name = "RecepteursSituation.findAll", query = "SELECT r FROM RecepteursSituation r")
public class RecepteursSituation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_creation")
	private Date dateCreation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modification")
	private Date dateModification;

	@EmbeddedId
	private RecepteursSituationPK id;

	// bi-directional many-to-one association to Situation
	@ManyToOne
	@JoinColumn(name = "id_situation", insertable = false, updatable = false)
	private Situation situation;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "id_recepteur", insertable = false, updatable = false)
	private User user;

	public RecepteursSituation() {
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public Date getDateModification() {
		return this.dateModification;
	}

	public RecepteursSituationPK getId() {
		return this.id;
	}

	public Situation getSituation() {
		return this.situation;
	}

	public User getUser() {
		return this.user;
	}

	public void setDateCreation(final Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setDateModification(final Date dateModification) {
		this.dateModification = dateModification;
	}

	public void setId(final RecepteursSituationPK id) {
		this.id = id;
	}

	public void setSituation(final Situation situation) {
		this.situation = situation;
	}

	public void setUser(final User user) {
		this.user = user;
	}

}