package com.appschallenge.emergency.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IUserDao;
import com.appschallenge.emergency.business.entity.User;
import com.appschallenge.emergency.business.service.ICreateUser;

@Component
public class CreateUser implements ICreateUser {
	@Autowired
	IUserDao userDao;

	@Override
	public User creerUser(final String telephone) {
		final User user = new User();
		user.setTelephone("0665642637");
		user.setPrenom("Mehdi");
		userDao.create(user);
		return null;
	}

}
