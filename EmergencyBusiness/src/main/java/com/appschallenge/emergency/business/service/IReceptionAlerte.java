package com.appschallenge.emergency.business.service;

import com.appschallenge.emergency.business.dto.AlerteRecue;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IReceptionAlerte {

	/**
	 * telephone de la personne qui a recu l'alerte
	 * 
	 * @param idAlerte
	 * @param telephone
	 * @return
	 * @throws EmergencyException
	 */
	AlerteRecue recevoirAlerte(final int idAlerte, final String telephone)
			throws EmergencyException;

}
