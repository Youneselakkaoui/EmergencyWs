package com.appschallenge.emergency.web.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.service.IReceptionAlerte;
import com.appschallenge.emergency.business.util.EmergencyException;
import com.appschallenge.emergency.web.pivots.demande.DemandeIn;
import com.appschallenge.emergency.web.pivots.demande.DemandeOut;

@Component
@Path("/emergencyReceiveAlert")
public class EmergencyReceiveAlert {
	@Autowired
	IReceptionAlerte serviceReceptionAlerte;

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
}
