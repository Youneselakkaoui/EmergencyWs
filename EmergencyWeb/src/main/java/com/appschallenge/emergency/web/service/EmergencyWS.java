package com.appschallenge.emergency.web.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.service.IManageUser;
import com.appschallenge.emergency.business.util.EmergencyConstants;
import com.appschallenge.emergency.business.util.EmergencyException;
import com.appschallenge.emergency.web.pivots.user.ManageUserIn;
import com.appschallenge.emergency.web.pivots.user.ManageUserOut;

@Component
@Path("/emergencyUser")
public class EmergencyWS {

	@Autowired
	private IManageUser manageUserService;

	/**
	 * Creates a user
	 *
	 * @return
	 */
	@POST
	@Path("/manageUser")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ManageUserOut manageUser(final ManageUserIn manageUserIn) {
		final ManageUserOut manageUserOut = new ManageUserOut();
		try {
			switch (manageUserIn.getCodeFonction()) {
			case 0:
				// creer user
				manageUserOut.setUserDTO(manageUserService
						.creerUser(manageUserIn.getUserDTO()));
				break;

			case 1:
				// update user
				manageUserOut.setUserDTO(manageUserService
						.updateUser(manageUserIn.getUserDTO()));
				break;
			default:
				throw new EmergencyException(EmergencyConstants.USRCREA0001);
			}
		} catch (final EmergencyException e) {
			final EmergencyAnomalieDTO anomalie = new EmergencyAnomalieDTO();
			anomalie.setCodeAnomalie(e.getExceptionCode());
			anomalie.setLibelleAnomalie(e.getExceptionMessage());
			manageUserOut.setAnomalie(anomalie);
		}

		return manageUserOut;
	}

}
