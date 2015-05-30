package com.appschallenge.emergency.business.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Objet notification a envoyer au sevice GCM
 *
 * @author elmehdiharabida
 *
 */
public class NotificationDTO {
	private Data data;
	private List<String> registration_ids;

	public Data getData() {
		if (data == null) {
			data = new Data();
		}
		return data;
	}

	public List<String> getRegistration_ids() {
		if (registration_ids == null) {
			registration_ids = new ArrayList<String>();
		}
		return registration_ids;
	}

	public void setData(final Data data) {
		this.data = data;
	}

	public void setRegistration_ids(final List<String> registration_ids) {
		this.registration_ids = registration_ids;
	}

}
