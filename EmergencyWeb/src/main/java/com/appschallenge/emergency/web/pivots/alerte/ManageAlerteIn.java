package com.appschallenge.emergency.web.pivots.alerte;


	

import java.io.Serializable;

import com.appschallenge.emergency.business.dto.AlerteDTO;


/**
 * Entree de manageSituation
 *
 * @author elmehdiharabida
 *
 */
public class ManageAlerteIn implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -354734881571599956L;
    
    /**
     * code fonction 0 pour creer et 1 pour update
     */
    private short codeFonction;
    // A voir
    // /**
    // * locale
    // */
    // private Locale locale;
    /**
     * Objet Situation a creer ou mettre a jour
     */
    private AlerteDTO alerteDTO;
    
    public short getCodeFonction() {
        return codeFonction;
    }
    
    public AlerteDTO getAlerteDTO() {
        return alerteDTO;
    }
    
    public void setCodeFonction(final short codeFonction) {
        this.codeFonction = codeFonction;
    }
    
    public void setAlerteDTO(final AlerteDTO alerteDTO) {
        this.alerteDTO = alerteDTO;
    }
    
    // public Locale getLocale() {
    // return locale;
    // }
    //
    // public void setLocale(Locale locale) {
    // this.locale = locale;
    // }

}
