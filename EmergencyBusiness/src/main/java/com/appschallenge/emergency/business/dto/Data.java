package com.appschallenge.emergency.business.dto;

import java.io.Serializable;

public class Data implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1030152478250347388L;
	private String notificatioType;
	private String requestObjectId;

	public String getNotificatioType() {
		return notificatioType;
	}

	public String getRequestObjectId() {
		return requestObjectId;
	}

	public void setNotificatioType(final String notificatioType) {
		this.notificatioType = notificatioType;
	}

	public void setRequestObjectId(final String requestObjectId) {
		this.requestObjectId = requestObjectId;
	}

}
