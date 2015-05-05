package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IManageAlerte {
	@Transactional
	AlerteDTO creerAlerte(AlerteDTO user) throws EmergencyException;

	@Transactional
	AlerteDTO updateAlerte(AlerteDTO alerteDTO) throws EmergencyException;

}
