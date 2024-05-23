/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.Encounter;

import Package.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Yamini Manral
 */
public class VitalSigns {
    
    
    //doctor --> add/update vital signs
    public static void AddVitalSigns(String eid, String hr, String bp, String diagnosis, String status){
        //no int hr and bp because int cannot be converted to string
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "UPDATE hospital.encounterdirectory SET hr = ?, bp = ?, diagnosis = ?, status = ? WHERE encounterid = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, hr);
            preparedStmt.setString(2, bp);
            preparedStmt.setString(3, diagnosis);
            preparedStmt.setString(4, status);
            preparedStmt.setString(5, eid);
            preparedStmt.execute();

            JOptionPane.showMessageDialog(null, "Vital Signs added successfully!");
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    
}
