package com.appschallenge.emergency.web.pivots.user;

import java.io.Serializable;

import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.dto.UserDTO;

/**
 * Sortie de manageUser
 *
 * @author elmehdiharabida
 *
 */
public class ManageUserOut implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -6713281515507601984L;
	/**
	 * eventuelle anomalie
	 */
	private EmergencyAnomalieDTO anomalie;
	/**
	 * Donnees utilisateur
	 */
	private UserDTO userDTO;

	public EmergencyAnomalieDTO getAnomalie() {
		return anomalie;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setAnomalie(final EmergencyAnomalieDTO anomalie) {
		this.anomalie = anomalie;
	}

	public void setUserDTO(final UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
