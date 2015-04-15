package com.appschallenge.emergency.business.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the piece_jointe database table.
 * 
 */
@Entity
@Table(name="piece_jointe")
@NamedQuery(name="PieceJointe.findAll", query="SELECT p FROM PieceJointe p")
public class PieceJointe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_piece_jointe")
	private int idPieceJointe;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation")
	private Date dateCreation;

	private String type;

	private String url;

	//bi-directional many-to-one association to Alerte
	@ManyToOne
	@JoinColumn(name="id_alerte")
	private Alerte alerte;

	public PieceJointe() {
	}

	public int getIdPieceJointe() {
		return this.idPieceJointe;
	}

	public void setIdPieceJointe(int idPieceJointe) {
		this.idPieceJointe = idPieceJointe;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Alerte getAlerte() {
		return this.alerte;
	}

	public void setAlerte(Alerte alerte) {
		this.alerte = alerte;
	}

}