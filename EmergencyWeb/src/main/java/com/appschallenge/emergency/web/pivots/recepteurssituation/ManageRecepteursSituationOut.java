package com.appschallenge.emergency.web.pivots.recepteurssituation;

import java.io.Serializable;

import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;
import com.appschallenge.emergency.business.dto.RecepteursSituationDTO;

/**
 * Sortie de manageRecepteursSituation
 *
 * @author elmehdiharabida
 *
 */
public class ManageRecepteursSituationOut implements Serializable {
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
    private RecepteursSituationDTO recepteursSituationDTO;
    
    public EmergencyAnomalieDTO getAnomalie() {
        return anomalie;
    }
    
    public RecepteursSituationDTO getRecepteursSituationDTO() {
        return recepteursSituationDTO;
    }
    
    public void setAnomalie(final EmergencyAnomalieDTO anomalie) {
        this.anomalie = anomalie;
    }
    
    public void setRecepteursSituationDTO(final RecepteursSituationDTO recepteursSituationDTO) {
        this.recepteursSituationDTO = recepteursSituationDTO;
    }
    
}
