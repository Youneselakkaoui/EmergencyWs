package com.appschallenge.emergency.business.dto;

import java.util.ArrayList;
import java.util.List;

import com.appschallenge.emergency.business.entity.Alerte;

/**
 * Objet notification a envoyer au sevice GCM
 *
 * @author elmehdiharabida
 *
 */
public class NotificationDTO {
	private Alerte data;
	private List<String> registration_ids;

	public Alerte getData() {
		return data;
	}

	public List<String> getRegistration_ids() {
		if (registration_ids == null) {
			return new ArrayList<String>();
		}
		return registration_ids;
	}

	public void setData(final Alerte data) {
		this.data = data;
	}

	public void setRegistration_ids(final List<String> registration_ids) {
		this.registration_ids = registration_ids;
	}

}
