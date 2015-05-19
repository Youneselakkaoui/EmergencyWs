package com.appschallenge.emergency;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.service.INotificationSender;

@ContextConfiguration(locations = { "classpath:/META-INF/spring-test/business-components-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationTesterTest {

	@Autowired
	INotificationSender notificationSender;

	@Test
	public void notifyPhone() {
		notificationSender.sendNotification(new ArrayList<UserDTO>(), null);

	}

}
