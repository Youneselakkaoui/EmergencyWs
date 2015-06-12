package com.appschallenge.emergency.web.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.service.IManageAlerte;
import com.appschallenge.emergency.business.util.EmergencyConstants;
import com.appschallenge.emergency.business.util.EmergencyException;
import com.appschallenge.emergency.web.pivots.alerte.ManageAlerteIn;
import com.appschallenge.emergency.web.pivots.alerte.ManageAlerteOut;

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
	@Path("/alert")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ManageAlerteOut alert(final ManageAlerteIn manageAlerteIn) {
		final ManageAlerteOut manageAlerteOut = new ManageAlerteOut();
		try {
			switch (manageAlerteIn.getCodeFonction()) {
			case 0:
				// creer Alerte
				manageAlerteOut.setAlerteDTO(manageAlerteService
						.notify(manageAlerteService.firstAlert(manageAlerteIn
								.getAlerteDTO())));
				break;

			case 1:
				// update Alerte
				manageAlerteOut.setAlerteDTO(manageAlerteService
						.retryAlert(manageAlerteIn.getAlerteDTO()));
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

	@GET
	@Path("/findAlerte")
	@Produces({ MediaType.APPLICATION_JSON })
	public ManageAlerteOut manageAlerte(
			@QueryParam("alerteId") final int alerteId) {
		final ManageAlerteOut manageAlerteOut = new ManageAlerteOut();

		try {

			final AlerteDTO alerteDTO = manageAlerteService
					.findAlerte(alerteId);
			manageAlerteOut.setAlerteDTO(alerteDTO);

		} catch (final EmergencyException e) {
			final EmergencyAnomalieDTO anomalie = new EmergencyAnomalieDTO();
			anomalie.setCodeAnomalie(e.getExceptionCode());
			anomalie.setLibelleAnomalie(e.getExceptionMessage());
			manageAlerteOut.setAnomalie(anomalie);
		}
		return manageAlerteOut;
	}

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
