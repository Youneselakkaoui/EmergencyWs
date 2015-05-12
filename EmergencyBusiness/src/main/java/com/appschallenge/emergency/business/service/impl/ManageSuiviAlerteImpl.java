package com.appschallenge.emergency.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.ISuiviAlerteDao;
import com.appschallenge.emergency.business.dto.SuiviAlerteDTO;
import com.appschallenge.emergency.business.entity.SuiviAlerte;
import com.appschallenge.emergency.business.service.IManageSuiviAlerte;
import com.appschallenge.emergency.business.util.EmergencyException;

@Component
public class ManageSuiviAlerteImpl implements IManageSuiviAlerte {
	@Autowired
	@Qualifier("dozer.Mapper")
	Mapper mapper;

	@Autowired
	ISuiviAlerteDao suiviAlerteDao;

	@Override
	public SuiviAlerteDTO creerSuiviAlerte(final SuiviAlerteDTO suiviAlerteDTO) {
		final SuiviAlerte suiviAlerte = mapper.map(suiviAlerteDTO, SuiviAlerte.class);
		suiviAlerteDao.create(suiviAlerte);

		final SuiviAlerteDTO suiviAlerteDTOout = mapper.map(suiviAlerte, SuiviAlerteDTO.class);
		return suiviAlerteDTOout;
	}



	@Override
	public SuiviAlerteDTO updateSuiviAlerte(final SuiviAlerteDTO suiviAlerteDTO) throws EmergencyException {
		final SuiviAlerte suiviAlerte = mapper.map(suiviAlerteDTO, SuiviAlerte.class);
		suiviAlerteDao.update(suiviAlerte);

		final SuiviAlerteDTO suiviAlerteDTOout = mapper.map(suiviAlerte, SuiviAlerteDTO.class);
		return suiviAlerteDTOout;
	}

}
