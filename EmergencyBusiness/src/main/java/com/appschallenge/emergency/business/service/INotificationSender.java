package com.appschallenge.emergency.business.service;

import java.util.List;

import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.dto.UserDTO;

public interface INotificationSender {
	void sendNotification(List<UserDTO> users, AlerteDTO alerte);

	void sendReceiptConfirmation(UserDTO demandeur, UserDTO recepteur);

}
