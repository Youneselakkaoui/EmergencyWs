package com.appschallenge.emergency.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IAlerteDao;
import com.appschallenge.emergency.business.dao.ISituationDao;
import com.appschallenge.emergency.business.dao.ISuiviAlerteDao;
import com.appschallenge.emergency.business.dao.IUserDao;
import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.dto.AlerteExchangeDTO;
import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.entity.Alerte;
import com.appschallenge.emergency.business.entity.Situation;
import com.appschallenge.emergency.business.entity.SuiviAlerte;
import com.appschallenge.emergency.business.entity.SuiviAlertePK;
import com.appschallenge.emergency.business.entity.User;
import com.appschallenge.emergency.business.service.IManageAlerte;
import com.appschallenge.emergency.business.service.INotificationSender;
import com.appschallenge.emergency.business.util.EmergencyException;

@Component
public class ManageAlerteImpl implements IManageAlerte {
	@Autowired
	IAlerteDao alerteDao;

	@Autowired
	@Qualifier("dozer.Mapper")
	Mapper mapper;

	@Autowired
	INotificationSender notificationService;

	@Autowired
	ISituationDao situationDao;

	@Autowired
	ISuiviAlerteDao suiviAlerteDao;

	@Autowired
	IUserDao userDao;

	@Override
	public AlerteDTO creerAlerte(final AlerteDTO alerteDTO) {
		final Alerte alerte = mapper.map(alerteDTO, Alerte.class);
		alerteDao.create(alerte);

		final AlerteDTO alerteDTOout = mapper.map(alerte, AlerteDTO.class);
		return alerteDTOout;
	}

	@Override
	public AlerteDTO findAlerte(final int alerteId) throws EmergencyException {
		AlerteDTO alerteDTOout = null;
		final Alerte alerte = alerteDao.find(alerteId);
		if (alerte != null) {
			alerteDTOout = mapper.map(alerte, AlerteDTO.class);
		}
		return alerteDTOout;
	}

	@Override
	public AlerteExchangeDTO firstAlert(final AlerteDTO alerteDTO)
			throws EmergencyException {
		final Alerte alerte = mapper.map(alerteDTO, Alerte.class);
		final Situation s = alerte.getSituation();
		s.setIdSituation(0);
		s.setAlertes(new ArrayList<Alerte>());
		s.getAlertes().add(alerte);

		// enregistrer situation
		// situationDao.create(alerte.getSituation());
		// enregistrer recepteurs
		// for (final String recepteur : alerteDTO.getSituation()
		// .getRecepteursSituations()) {
		// // enregistrer alerte
		// final RecepteursSituation recepteurSituation = new
		// RecepteursSituation();
		// recepteurSituation.setSituation(alerte.getSituation());
		// final RecepteursSituationPK pk = new RecepteursSituationPK();
		// pk.setIdRecepteur(recepteur);
		// recepteurSituation.setId(pk);
		// recepteurDao.create(recepteurSituation);
		// // enregistrer les recepteurs ayant installe l'application
		// // notifier les recepteurs par notification GCM
		// }
		// situationDao.create(alerte.getSituation());
		final Alerte out = alerteDao.create(alerte);

		System.out.println(out);
		final List<UserDTO> users = new ArrayList<UserDTO>();
		if ((alerteDTO.getSituation() != null)
				&& (alerteDTO.getSituation().getRecepteursSituations() != null)) {
			for (final String recepteur : alerteDTO.getSituation()
					.getRecepteursSituations()) {
				final User user = userDao.find(recepteur);
				if (user != null) {

					final SuiviAlerte suivi = new SuiviAlerte();
					suivi.setAlerte(alerte);
					suivi.setUser(user);
					final SuiviAlertePK pk = new SuiviAlertePK();
					pk.setIdAlerte(alerte.getIdAlerte());
					pk.setIdRecepteur(user.getTelephone());
					suivi.setId(pk);
					suiviAlerteDao.create(suivi);
					users.add(mapper.map(user, UserDTO.class));
				}
			}
		}

		final AlerteExchangeDTO exchange = new AlerteExchangeDTO();
		exchange.setAlerte(mapper.map(alerte, AlerteDTO.class));
		exchange.setUsers(users);

		// notify(exchange);
		return exchange;
	}

	@Override
	public AlerteDTO notify(final AlerteExchangeDTO exchange) {
		if (exchange.getUsers().size() > 0) {
			notificationService.sendNotification(exchange.getUsers(),
					exchange.getAlerte());
		}
		return exchange.getAlerte();
	}

	@Override
	public AlerteDTO retryAlert(final AlerteDTO alerteDTO)
			throws EmergencyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlerteDTO updateAlerte(final AlerteDTO alerteDTO)
			throws EmergencyException {
		final Alerte alerte = mapper.map(alerteDTO, Alerte.class);
		// ???????
		alerteDao.update(alerte);

		final AlerteDTO alerteDTOout = mapper.map(alerte, AlerteDTO.class);
		return alerteDTOout;
	}

}
