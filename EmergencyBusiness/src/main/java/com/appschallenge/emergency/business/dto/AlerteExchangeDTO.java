package com.appschallenge.emergency.business.dto;

import java.util.ArrayList;
import java.util.List;

public class AlerteExchangeDTO {

	private AlerteDTO alerte;
	private List<UserDTO> users;

	public AlerteDTO getAlerte() {
		return alerte;
	}

	public List<UserDTO> getUsers() {
		if (users == null) {
			users = new ArrayList<UserDTO>();
		}
		return users;
	}

	public void setAlerte(final AlerteDTO alerte) {
		this.alerte = alerte;
	}

	public void setUsers(final List<UserDTO> users) {
		this.users = users;
	}
}
