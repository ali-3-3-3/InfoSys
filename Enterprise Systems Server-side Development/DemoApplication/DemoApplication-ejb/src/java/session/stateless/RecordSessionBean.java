/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package session.stateless;

import entity.Record;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.sql.DataSource;

/**
 *
 * @author aliya
 */
@Stateless
public class RecordSessionBean implements RecordSessionBeanRemote, RecordSessionBeanLocal {

    @Resource(name = "demoApplicationDataSource")
    private DataSource demoApplicationDataSource;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Record> retrieveAllRecords() {
        List<Record> records = new ArrayList<>();
        String sql = "SELECT * FROM record ORDER BY RECORDID ASC;";
        try {
            Connection connection
                    = demoApplicationDataSource.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    records.add(new Record(resultSet.getLong("RECORDID"), resultSet.getString("RECORDNAME")));
                } while (resultSet.next());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return records;
    }
}
