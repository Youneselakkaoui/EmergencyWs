package com.appschallenge.emergency.web.pivots.demande;

import com.appschallenge.emergency.business.dto.UserDTO;

public class DemandeIn {
	private String notificationType;
	private String requestObjectId;
	/**
	 * demandeur d'informations
	 */
	private UserDTO user;

	public String getNotificationType() {
		return notificationType;
	}

	public String getRequestObjectId() {
		return requestObjectId;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setNotificationType(final String notificatioType) {
		this.notificationType = notificatioType;
	}

	public void setRequestObjectId(final String requestObjectId) {
		this.requestObjectId = requestObjectId;
	}

	public void setUser(final UserDTO user) {
		this.user = user;
	}

}
