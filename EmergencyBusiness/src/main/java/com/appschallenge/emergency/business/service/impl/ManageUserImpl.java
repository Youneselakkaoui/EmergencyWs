package com.appschallenge.emergency.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IUserDao;
import com.appschallenge.emergency.business.dto.UserDTO;
import com.appschallenge.emergency.business.entity.User;
import com.appschallenge.emergency.business.service.IManageUser;
import com.appschallenge.emergency.business.util.EmergencyException;

@Component
public class ManageUserImpl implements IManageUser {
	@Autowired
	@Qualifier("dozer.Mapper")
	Mapper mapper;

	@Autowired
	IUserDao userDao;

	@Override
	public UserDTO creerUser(final UserDTO userDTO) {
		final User user = mapper.map(userDTO, User.class);
		userDao.create(user);

		final UserDTO userDTOout = mapper.map(user, UserDTO.class);
		return userDTOout;
	}

	@Override
	public UserDTO findUser(final String telephone) {

		final User user = userDao.find(telephone);

		final UserDTO userDTOout = mapper.map(user, UserDTO.class);
		return userDTOout;
	}

	@Override
	public UserDTO updateUser(final UserDTO userDTO) throws EmergencyException {
		final User user = mapper.map(userDTO, User.class);
		userDao.update(user);

		final UserDTO userDTOout = mapper.map(user, UserDTO.class);
		return userDTOout;
	}

}
