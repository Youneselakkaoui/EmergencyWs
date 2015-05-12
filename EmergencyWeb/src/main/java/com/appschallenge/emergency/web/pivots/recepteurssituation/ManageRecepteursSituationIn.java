package com.appschallenge.emergency.web.pivots.recepteurssituation;


import java.io.Serializable;

import com.appschallenge.emergency.business.dto.RecepteursSituationDTO;

/**
 * Entree de manageUser
 *
 * @author elmehdiharabida
 *
 */
public class ManageRecepteursSituationIn implements Serializable {
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
     * Objet RecepteursSituation a creer ou mettre a jour
     */
    private RecepteursSituationDTO recepteursSituationDTO;
    
    public short getCodeFonction() {
        return codeFonction;
    }
    
    public RecepteursSituationDTO getRecepteursSituationDTO() {
        return recepteursSituationDTO;
    }
    
    public void setCodeFonction(final short codeFonction) {
        this.codeFonction = codeFonction;
    }
    
    public void setRecepteursSituationDTO(final RecepteursSituationDTO recepteursSituationDTO) {
        this.recepteursSituationDTO = recepteursSituationDTO;
    }
    
 
    
}
