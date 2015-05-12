package com.appschallenge.emergency.web.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.service.IManageAlerte;
import com.appschallenge.emergency.business.service.IManageUser;
import com.appschallenge.emergency.business.util.EmergencyConstants;
import com.appschallenge.emergency.business.util.EmergencyException;
import com.appschallenge.emergency.web.pivots.alerte.ManageAlerteIn;
import com.appschallenge.emergency.web.pivots.alerte.ManageAlerteOut;
import com.appschallenge.emergency.web.pivots.user.ManageUserIn;
import com.appschallenge.emergency.web.pivots.user.ManageUserOut;

@Component
@Path("/emergencyAlerte")
public class EmergencyAlerteWS {

	@Autowired
	private IManageAlerte manageAlerteService;

	/**
	 * Creates a Alerte
	 *
	 * @return
	 */
	@POST
	@Path("/manageAlerte")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ManageAlerteOut manageAlerte(final ManageAlerteIn manageAlerteIn) {
		final ManageAlerteOut manageAlerteOut = new ManageAlerteOut();
		try {
			switch (manageAlerteIn.getCodeFonction()) {
			case 0:
				// creer Alerte
				manageAlerteOut.setAlerteDTO(manageAlerteService
						.creerAlerte(manageAlerteIn.getAlerteDTO()));
				break;

			case 1:
				// update Alerte
				manageAlerteOut.setAlerteDTO(manageAlerteService
						.updateAlerte(manageAlerteIn.getAlerteDTO()));
				break;
			default:
				throw new EmergencyException(EmergencyConstants.USRCREA0001);
			}
		} catch (final EmergencyException e) {
			final EmergencyAnomalieDTO anomalie = new EmergencyAnomalieDTO();
			anomalie.setCodeAnomalie(e.getExceptionCode());
			anomalie.setLibelleAnomalie(e.getExceptionMessage());
			manageAlerteOut.setAnomalie(anomalie);
		}
		return manageAlerteOut;
	}

}
