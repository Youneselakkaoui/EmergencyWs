package com.appschallenge.emergency.web.pivots.user;

import com.appschallenge.emergency.business.dto.UserDTO;

/**
 * Entree de manageUser
 * 
 * @author elmehdiharabida
 *
 */
public class ManageUserIn {
	/**
	 * code fonction 0 pour creer et 1 pour update
	 */
	private short codeFonction;
	/**
	 * Objet user a creer ou mettre a jour
	 */
	private UserDTO userDTO;

	public short getCodeFonction() {
		return codeFonction;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setCodeFonction(final short codeFonction) {
		this.codeFonction = codeFonction;
	}

	public void setUserDTO(final UserDTO userDTO) {
		this.userDTO = userDTO;
	}
}
