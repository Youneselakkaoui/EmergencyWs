package com.appschallenge.emergency.web.pivots.demande;

import com.appschallenge.emergency.business.dto.AlerteRecue;
import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;

public class DemandeOut {

	private AlerteRecue alerte;
	private EmergencyAnomalieDTO anomalie;

	public AlerteRecue getAlerte() {
		return alerte;
	}

	public EmergencyAnomalieDTO getAnomalie() {
		return anomalie;
	}

	public void setAlerte(final AlerteRecue alerte) {
		this.alerte = alerte;
	}

	public void setAnomalie(final EmergencyAnomalieDTO anomalie) {
		this.anomalie = anomalie;
	}

}
