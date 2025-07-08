/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demoapplicationclient;

import entity.Record;
import java.util.List;
import javax.ejb.EJB;
import session.stateless.RecordSessionBeanRemote;

/**
 *
 * @author aliya
 */
public class Main {

    @EJB
    private static RecordSessionBeanRemote recordSessionBeanRemote;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Record> records = recordSessionBeanRemote.retrieveAllRecords();
        
        for(Record record:records){
            System.out.println("recordId: " + record.getRecordId() + "; recordName" + record.getRecordName());
        }
        
    }
    
}
