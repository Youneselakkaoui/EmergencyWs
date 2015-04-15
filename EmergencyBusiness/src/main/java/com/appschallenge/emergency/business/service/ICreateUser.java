package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.entity.User;

public interface ICreateUser {
	@Transactional
	User creerUser(String telephone);

}
