package com.appschallenge.emergency.web.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.service.IManageSituation;
import com.appschallenge.emergency.business.util.EmergencyConstants;
import com.appschallenge.emergency.business.util.EmergencyException;
import com.appschallenge.emergency.web.pivots.situation.ManageSituationIn;
import com.appschallenge.emergency.web.pivots.situation.ManageSituationOut;


@Component
@Path("/emergency")
public class EmergencySituationWS {

	@Autowired
	private IManageSituation manageSituationService;

	/**
	 * Creates a Situation
	 *
	 * @return
	 */
	@POST
	@Path("/manageSituation")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ManageSituationOut manageSituation(final ManageSituationIn manageSituationIn) {
		final ManageSituationOut manageSituationOut = new ManageSituationOut();
		try {
			switch (manageSituationIn.getCodeFonction()) {
			case 0:
				// creer Situation
				manageSituationOut.setSituationDTO(manageSituationService
						.creerSituation(manageSituationIn.getSituationDTO()));
				break;

			case 1:
				// update Situation
				manageSituationOut.setSituationDTO(manageSituationService
						.updateSituation(manageSituationIn.getSituationDTO()));
				break;
			default:
				throw new EmergencyException(EmergencyConstants.USRCREA0001);
			}
		} catch (final EmergencyException e) {
			final EmergencyAnomalieDTO anomalie = new EmergencyAnomalieDTO();
			anomalie.setCodeAnomalie(e.getExceptionCode());
			anomalie.setLibelleAnomalie(e.getExceptionMessage());
			manageSituationOut.setAnomalie(anomalie);
		}
		return manageSituationOut;
	}

}
