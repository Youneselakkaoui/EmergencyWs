package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IManageUser {
	@Transactional
	UserDTO creerUser(UserDTO user) throws EmergencyException;

}
