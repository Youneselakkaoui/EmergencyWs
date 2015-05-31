package com.appschallenge.emergency.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.appschallenge.emergency.business.dao.IAlerteDao;
import com.appschallenge.emergency.business.dto.AlerteRecue;
import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.entity.Alerte;
import com.appschallenge.emergency.business.service.INotificationSender;
import com.appschallenge.emergency.business.service.IReceptionAlerte;
import com.appschallenge.emergency.business.util.EmergencyConstants;
import com.appschallenge.emergency.business.util.EmergencyException;

/**
 *
 * @author elmehdiharabida
 *
 */
public class ReceptionAlerteImpl implements IReceptionAlerte {
	@Autowired
	IAlerteDao alerteDao;

	@Autowired
	@Qualifier("dozer.Mapper")
	Mapper mapper;
	@Autowired
	INotificationSender notificationSender;

	@Override
	/**
	 *
	 */
	public AlerteRecue recevoirAlerte(final int idAlerte, final String telephone)
			throws EmergencyException {
		AlerteRecue alerteRecue;
		final Alerte alerte = alerteDao.find(idAlerte);

		alerteRecue = mapper.map(alerte, AlerteRecue.class);
		final UserDTO recepteur = mapper.map(alerteDao.find(telephone),
				UserDTO.class);
		final UserDTO emetteur = mapper.map(alerte.getSituation().getUser(),
				UserDTO.class);
		notificationSender.sendReceiptConfirmation(emetteur, recepteur);
		if (alerte == null) {
			throw new EmergencyException(EmergencyConstants.ALERTEREC001);
		}

		return alerteRecue;
	}

}
