package com.appschallenge.emergency.web.pivots.alerte;

import java.io.Serializable;

import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;

/**
 * Sortie de manageUser
 *
 * @author elmehdiharabida
 *
 */
public class ManageAlerteOut implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -6713281515507601984L;
	/**
	 * Donnees utilisateur
	 */
	private AlerteDTO alerteDTO;
	/**
	 * eventuelle anomalie
	 */
	private EmergencyAnomalieDTO anomalie;

	public AlerteDTO getAlerteDTO() {
		return alerteDTO;
	}

	public EmergencyAnomalieDTO getAnomalie() {
		return anomalie;
	}

	public void setAlerteDTO(final AlerteDTO alerteDTO) {
		this.alerteDTO = alerteDTO;
	}

	public void setAnomalie(final EmergencyAnomalieDTO anomalie) {
		this.anomalie = anomalie;
	}

}
