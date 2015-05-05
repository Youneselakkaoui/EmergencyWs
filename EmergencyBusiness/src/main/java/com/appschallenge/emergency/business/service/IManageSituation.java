package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.SituationDTO;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IManageSituation {
	@Transactional
	SituationDTO creerSituation(SituationDTO situation) throws EmergencyException;

	
	@Transactional
	SituationDTO updateSituation(SituationDTO situationDTO) throws EmergencyException;

}
