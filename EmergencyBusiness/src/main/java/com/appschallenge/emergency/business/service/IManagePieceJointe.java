package com.appschallenge.emergency.business.service;

import javax.transaction.Transactional;

import com.appschallenge.emergency.business.dto.PieceJointeDTO;
import com.appschallenge.emergency.business.util.EmergencyException;

public interface IManagePieceJointe {
	@Transactional
	PieceJointeDTO creerPieceJointe(PieceJointeDTO pieceJointe) throws EmergencyException;

	@Transactional
	PieceJointeDTO updatePieceJointe(PieceJointeDTO pieceJointeDTO) throws EmergencyException;

}
