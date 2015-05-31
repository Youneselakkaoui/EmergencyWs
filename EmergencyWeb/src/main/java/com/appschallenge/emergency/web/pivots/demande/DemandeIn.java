package com.appschallenge.emergency.web.pivots.demande;

import com.appschallenge.emergency.business.dto.UserDTO;

public class DemandeIn {
	private String notificatioType;
	private String requestObjectId;
	private UserDTO user;

	public String getNotificatioType() {
		return notificatioType;
	}

	public String getRequestObjectId() {
		return requestObjectId;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setNotificatioType(final String notificatioType) {
		this.notificatioType = notificatioType;
	}

	public void setRequestObjectId(final String requestObjectId) {
		this.requestObjectId = requestObjectId;
	}

	public void setUser(final UserDTO user) {
		this.user = user;
	}

}
