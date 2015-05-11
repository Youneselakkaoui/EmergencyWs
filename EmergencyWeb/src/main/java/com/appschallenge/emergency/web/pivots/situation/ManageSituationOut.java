package com.appschallenge.emergency.web.pivots.situation;

import java.io.Serializable;

import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.dto.SituationDTO;
import com.appschallenge.emergency.business.dto.UserDTO;

/**
 * Sortie de manageUser
 *
 * @author elmehdiharabida
 *
 */
public class ManageSituationOut implements Serializable {
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
    private SituationDTO situationDTO;
    
    public EmergencyAnomalieDTO getAnomalie() {
        return anomalie;
    }
    
    public SituationDTO getSituationDTO() {
        return situationDTO;
    }
    
    public void setAnomalie(final EmergencyAnomalieDTO anomalie) {
        this.anomalie = anomalie;
    }
    
    public void setUserDTO(final UserDTO userDTO) {
        this.situationDTO = situationDTO;
    }
    
}
