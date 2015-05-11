package com.appschallenge.emergency.web.pivots.situation;


	

import java.io.Serializable;

import com.appschallenge.emergency.business.dto.SituationDTO;

/**
 * Entree de manageSituation
 *
 * @author elmehdiharabida
 *
 */
public class ManageSituationIn implements Serializable {
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
    private SituationDTO situationDTO;
    
    public short getCodeFonction() {
        return codeFonction;
    }
    
    public SituationDTO getSituationDTO() {
        return situationDTO;
    }
    
    public void setCodeFonction(final short codeFonction) {
        this.codeFonction = codeFonction;
    }
    
    public void setSituationDTO(final SituationDTO situationDTO) {
        this.situationDTO = situationDTO;
    }
    
    // public Locale getLocale() {
    // return locale;
    // }
    //
    // public void setLocale(Locale locale) {
    // this.locale = locale;
    // }

}
