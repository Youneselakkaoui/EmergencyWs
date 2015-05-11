package com.appschallenge.emergency.web.pivots.alerte;

import java.io.Serializable;

import com.appschallenge.emergency.business.dto.AlerteDTO;
import com.appschallenge.emergency.business.dto.EmergencyAnomalieDTO;


/**
 * Sortie de manageUser
 *
 * @author elmehdiharabida
 *
 */
public class ManageAlerteOut implements Serializable {
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
    private AlerteDTO alerteDTO;
    
    public EmergencyAnomalieDTO getAnomalie() {
        return anomalie;
    }
    
    public AlerteDTO getAlerteDTO() {
        return alerteDTO;
    }
    
    public void setAnomalie(final EmergencyAnomalieDTO anomalie) {
        this.anomalie = anomalie;
    }
    
    public void setAlerteDTO(final AlerteDTO alertDTO) {
        this.alerteDTO = alerteDTO;
    }
    
}
