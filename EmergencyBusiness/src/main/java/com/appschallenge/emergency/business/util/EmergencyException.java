package com.appschallenge.emergency.business.util;

import java.io.Serializable;

public class EmergencyException extends Exception implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4998168297661625163L;
	private String exceptionCode;
	private String exceptionMessage;

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
