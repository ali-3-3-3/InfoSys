/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package session.stateless;

import entity.Record;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author aliya
 */
@Remote
public interface RecordSessionBeanRemote {

    public List<Record> retrieveAllRecords();
    
}
