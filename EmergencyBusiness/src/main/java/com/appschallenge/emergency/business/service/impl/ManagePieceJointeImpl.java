package com.appschallenge.emergency.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.appschallenge.emergency.business.dao.IPieceJointeDao;
import com.appschallenge.emergency.business.dto.PieceJointeDTO;
import com.appschallenge.emergency.business.entity.PieceJointe;
import com.appschallenge.emergency.business.service.IManagePieceJointe;
import com.appschallenge.emergency.business.util.EmergencyException;

@Component
public class ManagePieceJointeImpl implements IManagePieceJointe {
	@Autowired
	@Qualifier("dozer.PieceJointeMapper")
	Mapper mapper;

	@Autowired
	IPieceJointeDao pieceJointeDao;

	@Override
	public PieceJointeDTO creerPieceJointe(final PieceJointeDTO pieceJointeDTO) {
		final PieceJointe pieceJointe = mapper.map(pieceJointeDTO, PieceJointe.class);
		pieceJointeDao.create(pieceJointe);

		final PieceJointeDTO pieceJointeDTOout = mapper.map(pieceJointe, PieceJointeDTO.class);
		return pieceJointeDTOout;
	}



	@Override
	public PieceJointeDTO updatePieceJointe(final PieceJointeDTO pieceJointeDTO) throws EmergencyException {
		final PieceJointe pieceJointe = mapper.map(pieceJointeDTO, PieceJointe.class);
		pieceJointeDao.update(pieceJointe);

		final PieceJointeDTO pieceJointeDTOout = mapper.map(pieceJointe, PieceJointeDTO.class);
		return pieceJointeDTOout;
	}

}
