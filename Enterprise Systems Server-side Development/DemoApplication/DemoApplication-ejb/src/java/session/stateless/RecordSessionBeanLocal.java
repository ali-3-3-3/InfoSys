/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package session.stateless;

import entity.Record;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aliya
 */
@Local
public interface RecordSessionBeanLocal {
    public List<Record> retrieveAllRecords();
}
