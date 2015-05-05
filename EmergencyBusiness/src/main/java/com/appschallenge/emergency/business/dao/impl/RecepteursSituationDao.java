package com.appschallenge.emergency.business.dao.impl;

import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IRecepteursSituationDao;
import com.appschallenge.emergency.business.entity.RecepteursSituation;

@Component("RecepteursSituationDao")
public class RecepteursSituationDao extends GenericDaoImpl<RecepteursSituation> implements IRecepteursSituationDao {

}
