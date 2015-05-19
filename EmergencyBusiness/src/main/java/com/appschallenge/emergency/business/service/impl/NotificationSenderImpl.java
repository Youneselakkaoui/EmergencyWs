package com.appschallenge.emergency.business.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.dto.NotificationDTO;
import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.service.INotificationSender;

@Component
public class NotificationSenderImpl implements INotificationSender {

	private NotificationDTO buildNotification(final List<UserDTO> users,
			final AlerteDTO alerte) {
		final NotificationDTO notification = new NotificationDTO();
		for (final UserDTO user : users) {
			notification.getRegistration_ids().add(user.getGcmDeviceId());
		}

		return notification;
	}

	@Override
	public void sendNotification(final List<UserDTO> users,
			final AlerteDTO alerte) {
		final NotificationDTO notification = buildNotification(users, alerte);
		try {

			final URL url = new URL("https://android.googleapis.com//gcm/send");
			final HttpsURLConnection conn = (HttpsURLConnection) url
					.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization",
					"key=AIzaSyBsz95tNNCthHl19-q98xRmRqPDuMBZb0g");

			final String input = "{\"registration_ids\" : [\"APA91bEwYi1XroVhR0QUygYErhHWLBOtMtz9eO8XfiphBnwCO42bx-p1yUWwAYd6zp19I-zjwbRsL5nW4YT5bOId-_73bW6WvJQLLKwCla0dExPk8lsk9Rn59Y5qFVHTgWpyVfEJ58DkaRRShlFuW22_M7yH76Sz7A\"],\"data\" : {\"Nick\" : \"Mario\",\"Text\" : \"great match!\",\"Room\" : \"PortugalVSDenmark\",},}";

			final OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

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

}
