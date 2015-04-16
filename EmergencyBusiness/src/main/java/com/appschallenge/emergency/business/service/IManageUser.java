package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.UserDTO;

public interface IManageUser {
	@Transactional
	UserDTO creerUser(UserDTO user);

}
