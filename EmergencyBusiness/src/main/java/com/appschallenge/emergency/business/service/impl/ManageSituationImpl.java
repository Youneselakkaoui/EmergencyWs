package com.appschallenge.emergency.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.ISituationDao;
import com.appschallenge.emergency.business.dto.SituationDTO;
import com.appschallenge.emergency.business.entity.Situation;
import com.appschallenge.emergency.business.service.IManageSituation;
import com.appschallenge.emergency.business.util.EmergencyException;

@Component
public class ManageSituationImpl implements IManageSituation {
	@Autowired
	@Qualifier("dozer.Mapper")
	Mapper mapper;

	@Autowired
	ISituationDao situationDao;

	@Override
	public SituationDTO creerSituation(final SituationDTO situationDTO) {
		final Situation situation = mapper.map(situationDTO, Situation.class);
		situationDao.create(situation);

		final SituationDTO situationDTOout = mapper.map(situation, SituationDTO.class);
		return situationDTOout;
	}


	
	@Override
	public SituationDTO findSituation(final int idSituation) {

		final Situation situation = situationDao.find(idSituation);

		final SituationDTO situationDTOout = mapper.map(situation, SituationDTO.class);
		return situationDTOout;
	}

	@Override
	public SituationDTO updateSituation(final SituationDTO situationDTO) throws EmergencyException {
		final Situation situation = mapper.map(situationDTO, Situation.class);
		situationDao.update(situation);

		final SituationDTO situationDTOout = mapper.map(situation, SituationDTO.class);
		return situationDTOout;
	}

}
