/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author aliya
 */
public class Record implements Serializable {

    public Record() {
    }

    public Record(Long recordId, String recordName) {
        this.recordId = recordId;
        this.recordName = recordName;
    }
    
    private Long recordId;
    private String recordName;

    /**
     * @return the recordId
     */
    public Long getRecordId() {
        return recordId;
    }

    /**
     * @param recordId the recordId to set
     */
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    /**
     * @return the recordName
     */
    public String getRecordName() {
        return recordName;
    }

    /**
     * @param recordName the recordName to set
     */
    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }
    
    
}
