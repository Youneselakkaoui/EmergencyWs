package com.appschallenge.emergency.web.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.service.IReceptionAlerte;
import com.appschallenge.emergency.business.util.EmergencyException;
import com.appschallenge.emergency.web.pivots.demande.DemandeIn;
import com.appschallenge.emergency.web.pivots.demande.DemandeOut;
import com.appschallenge.emergency.web.pivots.demande.SyncAlertesOut;
import com.appschallenge.emergency.web.pivots.user.ManageUserIn;
import com.appschallenge.emergency.web.pivots.user.ManageUserOut;

@Component
@Path("/emergencyReceiveAlert")
public class EmergencyReceiveAlert {
	@Autowired
	IReceptionAlerte serviceReceptionAlerte;

	@POST
	@Path("/accuseAlerte")
	@Produces({ MediaType.APPLICATION_JSON })
	public ManageUserOut accuserReception(
			@QueryParam("alerteId") final int alerteId,
			@QueryParam("telephone") final String telephone) {
		final ManageUserOut userOut = new ManageUserOut();
		try {
			final UserDTO userDTO = serviceReceptionAlerte.accuserReception(
					alerteId, telephone);
			userOut.setUserDTO(userDTO);
			return userOut;
		} catch (final EmergencyException e) {
			final EmergencyAnomalieDTO anomalie = new EmergencyAnomalieDTO();
			anomalie.setCodeAnomalie(e.getExceptionCode());
			anomalie.setLibelleAnomalie(e.getExceptionMessage());
			userOut.setAnomalie(anomalie);
			e.printStackTrace();
		}
		return userOut;
	}

	/**
	 * Creates a Situation
	 *
	 * @return
	 */
	@POST
	@Path("/recevoirAlerte")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public DemandeOut manageSituation(final DemandeIn demandeIn) {
		final DemandeOut demandeOut = new DemandeOut();
		try {
			if ((demandeIn == null)
					|| StringUtils.isEmpty(demandeIn.getRequestObjectId())) {
				throw new EmergencyException(null);
			}

			demandeOut.setAlerte(serviceReceptionAlerte.recevoirAlerte(Integer
					.valueOf(demandeIn.getRequestObjectId()), demandeIn
					.getUser().getTelephone()));

		} catch (final EmergencyException e) {
			final EmergencyAnomalieDTO anomalie = new EmergencyAnomalieDTO();
			anomalie.setCodeAnomalie(e.getExceptionCode());
			anomalie.setLibelleAnomalie(e.getExceptionMessage());
			demandeOut.setAnomalie(anomalie);
		}
		return demandeOut;
	}

	@POST
	@Path("/syncAlertes")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public SyncAlertesOut synchroniserAlertes(final ManageUserIn user) {
		final SyncAlertesOut syncAlertesOut = new SyncAlertesOut();

		try {
			if ((user == null) || (user.getUserDTO() == null)) {
				throw new EmergencyException(null);
			}
			syncAlertesOut.setAlerte(serviceReceptionAlerte
					.synchroniserAlerte(user.getUserDTO()));
		} catch (final EmergencyException e) {
			final EmergencyAnomalieDTO anomalie = new EmergencyAnomalieDTO();
			anomalie.setCodeAnomalie(e.getExceptionCode());
			anomalie.setLibelleAnomalie(e.getExceptionMessage());
			syncAlertesOut.setAnomalie(anomalie);
		}

		return syncAlertesOut;
	}
}
