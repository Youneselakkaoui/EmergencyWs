package com.appschallenge.emergency.web.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.service.IManageRecepteursSituation;
import com.appschallenge.emergency.business.util.EmergencyConstants;
import com.appschallenge.emergency.business.util.EmergencyException;
import com.appschallenge.emergency.web.pivots.recepteurssituation.ManageRecepteursSituationIn;
import com.appschallenge.emergency.web.pivots.recepteurssituation.ManageRecepteursSituationOut;


@Component
@Path("/emergency")
public class EmergencyRecepteursSituationWS {

	@Autowired
	private IManageRecepteursSituation manageRecepteursSituationService;

	/**
	 * Creates a RecepteursSituation
	 *
	 * @return
	 */
	@POST
	@Path("/manageRecepteursSituation")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ManageRecepteursSituationOut manageRecepteursSituation(final ManageRecepteursSituationIn manageRecepteursSituationIn) {
		final ManageRecepteursSituationOut manageRecepteursSituationOut = new ManageRecepteursSituationOut();
		try {
			switch (manageRecepteursSituationIn.getCodeFonction()) {
			case 0:
				// creer RecepteursSituation
				manageRecepteursSituationOut.setRecepteursSituationDTO(manageRecepteursSituationService
						.creerRecepteursSituation(manageRecepteursSituationIn.getRecepteursSituationDTO()));
				break;

			case 1:
				// update RecepteursSituation
				manageRecepteursSituationOut.setRecepteursSituationDTO(manageRecepteursSituationService
						.updateRecepteursSituation(manageRecepteursSituationIn.getRecepteursSituationDTO()));
				break;
			default:
				throw new EmergencyException(EmergencyConstants.USRCREA0001);
			}
		} catch (final EmergencyException e) {
			final EmergencyAnomalieDTO anomalie = new EmergencyAnomalieDTO();
			anomalie.setCodeAnomalie(e.getExceptionCode());
			anomalie.setLibelleAnomalie(e.getExceptionMessage());
			manageRecepteursSituationOut.setAnomalie(anomalie);
		}
		return manageRecepteursSituationOut;
	}

}
