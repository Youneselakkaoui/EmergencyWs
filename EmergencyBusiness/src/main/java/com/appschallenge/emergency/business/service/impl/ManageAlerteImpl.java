package com.appschallenge.emergency.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IAlerteDao;
import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.entity.Alerte;
import com.appschallenge.emergency.business.service.IManageAlerte;
import com.appschallenge.emergency.business.util.EmergencyException;

@Component
public class ManageAlerteImpl implements IManageAlerte {
	@Autowired
	@Qualifier("dozer.AlerteMapper")
	Mapper mapper;

	@Autowired
	IAlerteDao alerteDao;

	@Override
	public AlerteDTO creerAlerte(final AlerteDTO alerteDTO) {
		final Alerte alerte = mapper.map(alerteDTO, Alerte.class);
		alerteDao.create(alerte);

		final AlerteDTO alerteDTOout = mapper.map(alerte, AlerteDTO.class);
		return alerteDTOout;
	}



	@Override
	public AlerteDTO updateAlerte(final AlerteDTO alerteDTO) throws EmergencyException {
		final Alerte alerte = mapper.map(alerteDTO, Alerte.class);
		alerteDao.update(alerte);

		final AlerteDTO alerteDTOout = mapper.map(alerte, AlerteDTO.class);
		return alerteDTOout;
	}

}
