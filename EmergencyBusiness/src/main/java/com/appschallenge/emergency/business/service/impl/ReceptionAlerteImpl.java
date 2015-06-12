package com.appschallenge.emergency.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IAlerteDao;
import com.appschallenge.emergency.business.dao.ISuiviAlerteDao;
import com.appschallenge.emergency.business.dao.IUserDao;
import com.appschallenge.emergency.business.dto.AlerteRecue;
import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.entity.Alerte;
import com.appschallenge.emergency.business.entity.SuiviAlerte;
import com.appschallenge.emergency.business.entity.User;
import com.appschallenge.emergency.business.service.INotificationSender;
import com.appschallenge.emergency.business.service.IReceptionAlerte;
import com.appschallenge.emergency.business.util.EmergencyConstants;
import com.appschallenge.emergency.business.util.EmergencyException;

/**
 *
 * @author elmehdiharabida
 *
 */
@Component
public class ReceptionAlerteImpl implements IReceptionAlerte {
	@Autowired
	IAlerteDao alerteDao;
	@Autowired
	@Qualifier("dozer.Mapper")
	Mapper mapper;

	@Autowired
	INotificationSender notificationSender;
	@Autowired
	ISuiviAlerteDao suiviAlerteDao;
	@Autowired
	IUserDao userDao;

	@Override
	public UserDTO accuserReception(final int idAlerte, final String telephone)
			throws EmergencyException {
		UserDTO returnedValue = null;
		boolean ok = false;
		final Alerte alerte = alerteDao.find(idAlerte);
		if (alerte != null) {
			final List<SuiviAlerte> suiviAlerte = alerte.getSuiviAlertes();
			for (final SuiviAlerte suivi : suiviAlerte) {
				if (telephone.equals(suivi.getUser().getTelephone())) {
					suivi.setDateMaj(new Date());
					suiviAlerteDao.update(suivi);
					ok = true;
					break;
				}
			}

			if (ok) {
				final User recepteur = userDao.find(telephone);

				notificationSender.sendReceiptConfirmation(mapper.map(alerte
						.getSituation().getUser(), UserDTO.class), mapper.map(
								recepteur, UserDTO.class));
				returnedValue = mapper.map(recepteur, UserDTO.class);
			}
		}

		return returnedValue;
	}

	@Override
	/**
	 *
	 */
	public AlerteRecue recevoirAlerte(final int idAlerte, final String telephone)
			throws EmergencyException {
		AlerteRecue alerteRecue;
		final Alerte alerte = alerteDao.find(idAlerte);
		if (alerte == null) {
			throw new EmergencyException(EmergencyConstants.ALERTEREC001);
		}
		alerteRecue = mapper.map(alerte, AlerteRecue.class);
		final UserDTO recepteur = mapper.map(alerteDao.find(idAlerte),
				UserDTO.class);
		final UserDTO emetteur = mapper.map(alerte.getSituation().getUser(),
				UserDTO.class);
		notificationSender.sendReceiptConfirmation(emetteur, recepteur);

		return alerteRecue;
	}

	@Override
	public List<AlerteRecue> synchroniserAlerte(final UserDTO user)
			throws EmergencyException {
		final List<AlerteRecue> alertes = new ArrayList<AlerteRecue>();
		final User userEntity = userDao.find(user.getTelephone());
		if (userEntity != null) {
			final List<SuiviAlerte> suivi = userEntity.getSuiviAlertes();
			for (final SuiviAlerte suiviAlerte : suivi) {
				if (suiviAlerte.getDateMaj() == null) {
					alertes.add(mapper.map(suiviAlerte.getAlerte(),
							AlerteRecue.class));
				}
			}

		}
		return alertes;
	}
}
