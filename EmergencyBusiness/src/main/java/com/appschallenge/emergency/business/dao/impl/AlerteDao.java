package com.appschallenge.emergency.business.dao.impl;

import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IAlerteDao;
import com.appschallenge.emergency.business.entity.Alerte;

@Component("AlerteDao")
public class AlerteDao extends GenericDaoImpl<Alerte> implements IAlerteDao {

}
