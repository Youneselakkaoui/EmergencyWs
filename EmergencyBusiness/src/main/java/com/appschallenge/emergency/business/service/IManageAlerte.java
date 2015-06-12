package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.dto.AlerteExchangeDTO;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IManageAlerte {
	@Transactional
	AlerteDTO creerAlerte(AlerteDTO alerte) throws EmergencyException;

	@Transactional
	AlerteDTO findAlerte(int alerteId) throws EmergencyException;

	@Transactional
	AlerteExchangeDTO firstAlert(AlerteDTO alerteDTO) throws EmergencyException;

	AlerteDTO notify(AlerteExchangeDTO exchange);

	@Transactional
	AlerteDTO retryAlert(AlerteDTO alerteDTO) throws EmergencyException;

	@Transactional
	AlerteDTO updateAlerte(AlerteDTO alerteDTO) throws EmergencyException;

}
