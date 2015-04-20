package com.appschallenge.emergency.web.pivots.user;

<<<<<<< HEAD
import java.io.Serializable;

=======
>>>>>>> origin/master
import com.appschallenge.emergency.business.dto.UserDTO;

/**
 * Entree de manageUser
<<<<<<< HEAD
 *
 * @author elmehdiharabida
 *
 */
public class ManageUserIn implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -354734881571599956L;
=======
 * 
 * @author elmehdiharabida
 *
 */
public class ManageUserIn {
>>>>>>> origin/master
	/**
	 * code fonction 0 pour creer et 1 pour update
	 */
	private short codeFonction;
<<<<<<< HEAD
	// A voir
	// /**
	// * locale
	// */
	// private Locale locale;
=======
>>>>>>> origin/master
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
<<<<<<< HEAD

	// public Locale getLocale() {
	// return locale;
	// }
	//
	// public void setLocale(Locale locale) {
	// this.locale = locale;
	// }
=======
>>>>>>> origin/master
}
