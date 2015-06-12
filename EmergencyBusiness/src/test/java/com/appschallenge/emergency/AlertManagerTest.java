package com.appschallenge.emergency;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appschallenge.emergency.business.dao.IAlerteDao;
import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.google.gson.Gson;

@ContextConfiguration(locations = { "classpath:/META-INF/spring-test/business-components-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AlertManagerTest {
	@Autowired
	IAlerteDao alerteDao;
	@Autowired
	Mapper mapper;

	@Test
	public void testAlerte() {
		final AlerteDTO alerteDTOout = mapper.map(alerteDao.find(1),
				AlerteDTO.class);
		// final Alerte alerte = alerteDao.find(1);
		final Gson jsonMaker = new Gson();
		System.out.println(jsonMaker.toJson(alerteDTOout));
	}

}
