package com.appschallenge.emergency.business.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.dto.Data;
import com.appschallenge.emergency.business.dto.NotificationDTO;
import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.service.INotificationSender;
import com.appschallenge.emergency.business.util.EmergencyConstants;
import com.google.gson.Gson;

@Component
public class NotificationSenderImpl implements INotificationSender {

	private String buildNotification(final List<UserDTO> users,
			final AlerteDTO alerte) {
		final NotificationDTO notification = new NotificationDTO();
		for (final UserDTO user : users) {
			notification.getRegistration_ids().add(user.getGcmDeviceId());
		}
		notification.getData().setNotificatioType(
				EmergencyConstants.NOTIFICATION_ALERTE);
		notification.getData().setRequestObjectId(
				String.valueOf(alerte.getIdAlerte()));
		final Gson jsonMaker = new Gson();
		return jsonMaker.toJson(notification);
	}

	@Override
	public void sendNotification(final List<UserDTO> users,
			final AlerteDTO alerte) {
		final String jsonRequest = buildNotification(users, alerte);
		sendNotification(jsonRequest);

	}

	private void sendNotification(final String jsonRequest) {
		try {

			final URL url = new URL("https://android.googleapis.com//gcm/send");
			final HttpsURLConnection conn = (HttpsURLConnection) url
					.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization",
					"key=AIzaSyBsz95tNNCthHl19-q98xRmRqPDuMBZb0g");
			// final JsonObject notificationToSend = new JsonObject();

			// final String input =
			// "{\"registration_ids\" : [\"APA91bEwYi1XroVhR0QUygYErhHWLBOtMtz9eO8XfiphBnwCO42bx-p1yUWwAYd6zp19I-zjwbRsL5nW4YT5bOId-_73bW6WvJQLLKwCla0dExPk8lsk9Rn59Y5qFVHTgWpyVfEJ58DkaRRShlFuW22_M7yH76Sz7A\"],\"data\" : {\"Nick\" : \"Mario\",\"Text\" : \"great match!\",\"Room\" : \"PortugalVSDenmark\",},}";

			final OutputStream os = conn.getOutputStream();
			os.write(jsonRequest.getBytes());
			os.flush();

			// if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			// throw new RuntimeException("Failed : HTTP error code : "
			// + conn.getResponseCode());
			// }

			final BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (final MalformedURLException e) {

			e.printStackTrace();

		} catch (final IOException e) {

			e.printStackTrace();

		}
	}

	@Override
	public void sendReceiptConfirmation(final UserDTO demandeur,
			final UserDTO recepteur) {
		final NotificationDTO notification = new NotificationDTO();
		final List<String> emetteurGCMId = new ArrayList<String>();
		emetteurGCMId.add(demandeur.getGcmDeviceId());
		notification.setRegistration_ids(emetteurGCMId);
		notification.setData(new Data());
		notification.getData().setNotificatioType(
				EmergencyConstants.NOTIFICATION_AR_ALERTE);
		notification.getData().setRequestObjectId(recepteur.getTelephone());
		final Gson jsonMaker = new Gson();
		sendNotification(jsonMaker.toJson(notification));
	}

}
