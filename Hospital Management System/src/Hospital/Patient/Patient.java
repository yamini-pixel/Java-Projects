/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.Patient;

import Hospital.Person.*;
import Package.ConnectionProvider;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;

/**
 *
 * @author Yamini Manral
 */
public class Patient {

    //DATA VALIDATION AND PASSWORD CHECKS
    //PATIENT REGISTRATION PAGE
    public static void CreatePatient(String role, String username, String password, String name, String cid, String hid) {
        Boolean match = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,}$"); //Minimum eight characters, at least one uppercase letter, one lowercase letter and one number
        if (match != true) {
            JOptionPane.showMessageDialog(null, "Enter a valid password! Minimum four characters, at least one uppercase letter, one lowercase letter and one number.");
        } else if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter a username!");
        } else if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter a name!");
        } else {
            try {
                Connection connection = ConnectionProvider.Connect();
                Statement statement = connection.createStatement();
                String query = "INSERT INTO hospital.persondirectory ( role, username, password, name, communityid, houseid) VALUES ( ?,?,?,?,?,?)";
                PreparedStatement preparedStmt1 = connection.prepareStatement(query);
                preparedStmt1.setString(1, role);
                preparedStmt1.setString(2, username);
                preparedStmt1.setString(3, password);
                preparedStmt1.setString(4, name);
                preparedStmt1.setString(5, cid);
                preparedStmt1.setString(6, hid);
                preparedStmt1.execute();

                JOptionPane.showMessageDialog(null, "Patient added successfully!");

                connection.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

//system admin --> patient tab --> view patient table
    public static void ReadAllPatient(DefaultTableModel model) {

        String id;
        String name;
        model.setRowCount(0);
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select persondirectory.personid,  persondirectory.name from hospital.persondirectory WHERE role = 'Patient'";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                String[] row = {id, name};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


//system admin --> patient tab --> delete patient
    public static void DeletePatient(String id) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a Patient ID to proceed!");
            } else{
                String query2 = "delete from hospital.persondirectory where personid = '" + id + "' AND role = 'Patient' ";
                statement.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Patient deleted!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    

    //hopsital admin ==>patient tab ==> update patient hospital ID
    public static void UpdatePatient(String username, String hospitalid) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter details to update!");
            } else {
                String query = "update hospital.persondirectory set hospitalid = ? where username = ?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, hospitalid);
                preparedStmt.setString(2, username);

                preparedStmt.execute();
                JOptionPane.showMessageDialog(null, "Patient details updated!");

            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
