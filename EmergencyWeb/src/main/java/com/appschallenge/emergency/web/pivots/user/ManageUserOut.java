package com.appschallenge.emergency.web.pivots.user;

<<<<<<< HEAD
import java.io.Serializable;

=======
>>>>>>> origin/master
import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.dto.UserDTO;

/**
 * Sortie de manageUser
<<<<<<< HEAD
 *
 * @author elmehdiharabida
 *
 */
public class ManageUserOut implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -6713281515507601984L;
=======
 * 
 * @author elmehdiharabida
 *
 */
public class ManageUserOut {
>>>>>>> origin/master
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
