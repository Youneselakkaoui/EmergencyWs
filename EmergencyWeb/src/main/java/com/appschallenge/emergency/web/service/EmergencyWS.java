package com.appschallenge.emergency.web.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.service.IManageUser;

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
	public UserDTO createUser(final UserDTO userDTO) {
		return creerUserService.creerUser(userDTO);
	}

}
