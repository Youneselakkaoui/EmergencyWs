package com.appschallenge.emergency.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IRecepteursSituationDao;
import com.appschallenge.emergency.business.dto.RecepteursSituationDTO;
import com.appschallenge.emergency.business.entity.RecepteursSituation;
import com.appschallenge.emergency.business.service.IManageRecepteursSituation;
import com.appschallenge.emergency.business.util.EmergencyException;

@Component
public class ManageRecepteursSituationImpl implements IManageRecepteursSituation {
	@Autowired
	@Qualifier("dozer.RecepteursSituationMapper")
	Mapper mapper;

	@Autowired
	IRecepteursSituationDao recepteursSituationDao;

	@Override
	public RecepteursSituationDTO creerRecepteursSituation(final RecepteursSituationDTO recepteursSituationDTO) {
		final RecepteursSituation recepteursSituation = mapper.map(recepteursSituationDTO, RecepteursSituation.class);
		recepteursSituationDao.create(recepteursSituation);

		final RecepteursSituationDTO recepteursSituationDTOout = mapper.map(recepteursSituation, RecepteursSituationDTO.class);
		return recepteursSituationDTOout;
	}

	
	@Override
	public RecepteursSituationDTO updateRecepteursSituation(final RecepteursSituationDTO recepteursSituationDTO) throws EmergencyException {
		final RecepteursSituation recepteursSituation = mapper.map(recepteursSituationDTO, RecepteursSituation.class);
		recepteursSituationDao.update(recepteursSituation);

		final RecepteursSituationDTO recepteursSituationDTOout = mapper.map(recepteursSituation, RecepteursSituationDTO.class);
		return recepteursSituationDTOout;
	}

}
