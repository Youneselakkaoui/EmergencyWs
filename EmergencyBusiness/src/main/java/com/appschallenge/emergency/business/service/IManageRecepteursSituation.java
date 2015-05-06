package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.RecepteursSituationDTO;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IManageRecepteursSituation {
	@Transactional
	RecepteursSituationDTO creerRecepteursSituation(RecepteursSituationDTO recepteursSituation) throws EmergencyException;

	@Transactional
	RecepteursSituationDTO updateRecepteursSituation(RecepteursSituationDTO recepteursSituationDTO) throws EmergencyException;

}
