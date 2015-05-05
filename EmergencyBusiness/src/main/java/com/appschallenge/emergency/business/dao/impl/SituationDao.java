package com.appschallenge.emergency.business.dao.impl;

import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.ISituationDao;
import com.appschallenge.emergency.business.entity.Situation;

@Component("SituationDao")
public class SituationDao extends GenericDaoImpl<Situation> implements ISituationDao {

}
