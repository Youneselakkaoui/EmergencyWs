package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IManageUser {
	@Transactional
	UserDTO creerUser(UserDTO user) throws EmergencyException;

	@Transactional
	UserDTO findUser(String telephone) throws EmergencyException;

	@Transactional
	UserDTO updateUser(UserDTO userDTO) throws EmergencyException;

}
