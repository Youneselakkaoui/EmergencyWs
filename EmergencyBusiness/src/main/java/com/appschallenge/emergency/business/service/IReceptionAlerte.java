package com.appschallenge.emergency.business.service;

import java.util.List;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.AlerteRecue;
import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IReceptionAlerte {

	@Transactional
	UserDTO accuserReception(final int idAlerte, final String telephone)
			throws EmergencyException;

	/**
	 * telephone de la personne qui a recu l'alerte
	 *
	 * @param idAlerte
	 * @param telephone
	 * @return
	 * @throws EmergencyException
	 */
	@Transactional
	AlerteRecue recevoirAlerte(final int idAlerte, final String telephone)
			throws EmergencyException;

	@Transactional
	List<AlerteRecue> synchroniserAlerte(final UserDTO user)
			throws EmergencyException;

}
