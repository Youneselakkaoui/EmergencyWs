package com.appschallenge.emergency.web.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.entity.User;
import com.appschallenge.emergency.business.service.ICreateUser;

@Component
@Path("/emergency")
public class EmergencyWS {

	@Autowired
	private ICreateUser creerUserService;

	/************************************ READ ************************************/
	/**
	 * Returns all resources (podcasts) from the database
	 *
	 * @return
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public User createUser() {
		return creerUserService.creerUser("0000");
	}

}
