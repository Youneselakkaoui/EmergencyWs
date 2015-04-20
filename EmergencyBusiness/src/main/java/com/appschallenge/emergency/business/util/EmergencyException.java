package com.appschallenge.emergency.business.util;

import java.io.Serializable;
import java.util.ResourceBundle;

public class EmergencyException extends Exception implements Serializable {

	private static final ResourceBundle RESOURCE;
	/**
	 *
	 */
	private static final long serialVersionUID = 4998168297661625163L;
	static {
		RESOURCE = ResourceBundle
				.getBundle(EmergencyConstants.MESSAGE_ERREUR_FILE);
	}
	private String exceptionCode;

	private String exceptionMessage;

	public EmergencyException(final String exceptionCode) {
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = RESOURCE.getString(exceptionCode);

	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionCode(final String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public void setExceptionMessage(final String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
