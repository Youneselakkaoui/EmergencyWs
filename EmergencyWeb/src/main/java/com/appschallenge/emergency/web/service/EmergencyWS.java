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
import com.appschallenge.emergency.business.util.EmergencyException;
import com.appschallenge.emergency.web.pivots.user.ManageUserIn;
import com.appschallenge.emergency.web.pivots.user.ManageUserOut;

@Component
@Path("/emergency")
public class EmergencyWS {

	@Autowired
	private IManageUser creerUserService;

	/**
	 * Creates a user
	 *
	 * @return
	 */
	@POST
	@Path("/createUser")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ManageUserOut manageUser(final ManageUserIn manageUserIn) {
		final ManageUserOut manageUserOut = new ManageUserOut();
		try {
			switch (manageUserIn.getCodeFonction()) {
			case 0:
				manageUserOut.setUserDTO(creerUserService
						.creerUser(manageUserIn.getUserDTO()));
				break;
			case 1:
				manageUserOut.setUserDTO(creerUserService
						.creerUser(manageUserIn.getUserDTO()));
				break;
			default:
				throw new EmergencyException();
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
