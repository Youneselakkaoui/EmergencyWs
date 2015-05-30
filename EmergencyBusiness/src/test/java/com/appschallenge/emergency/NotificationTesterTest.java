package com.appschallenge.emergency;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.dto.SituationDTO;
import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.service.IManageUser;
import com.appschallenge.emergency.business.service.INotificationSender;

@ContextConfiguration(locations = { "classpath:/META-INF/spring-test/business-components-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationTesterTest {

	@Autowired
	INotificationSender notificationSender;
	@Autowired
	IManageUser userManager;

	@Test
	public void notifyPhone() {
		final List<UserDTO> users = new ArrayList<UserDTO>();
		users.add(userManager.findUser("+212660318974"));
		users.add(userManager.findUser("+212665642637"));
		final AlerteDTO alerte = new AlerteDTO();
		alerte.setSituation(new SituationDTO());
		alerte.getSituation().setMessage("au secours");
		alerte.setIdAlerte(0);
		// alerte.set
		notificationSender.sendNotification(users, alerte);

	}

}
