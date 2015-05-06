package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.SuiviAlerteDTO;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IManageSuiviAlerte {
	@Transactional
	SuiviAlerteDTO creerSuiviAlerte(SuiviAlerteDTO suiviAlerteDTO) throws EmergencyException;

	@Transactional
	SuiviAlerteDTO updateSuiviAlerte(SuiviAlerteDTO suiviAlerteDTO) throws EmergencyException;

}
