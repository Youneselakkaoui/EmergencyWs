package com.appschallenge.emergency.business.dao.impl;

import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IUserDao;
import com.appschallenge.emergency.business.entity.User;

@Component("UserDao")
public class UserDao extends GenericDaoImpl<User> implements IUserDao {

}
