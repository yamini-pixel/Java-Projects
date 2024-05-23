/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.Doctor;

import Package.ConnectionProvider;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yamini Manral
 */
public class Doctor {

    //NOT NULL CHECKS DONE
    
    
    //SYSTEM ADMIN --> DOCTOR --> ADD A NEW DOCTOR 
    //hospital admin --> doctor tab --> create a new doctor
    public static void CreateDoctor(String name, String hospitalid) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (hospitalid.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a value to proceed!");

            }
            String query = "insert into hospital.doctordirectory (name, hospitalid) values (?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, hospitalid);
            preparedStmt.execute();

            JOptionPane.showMessageDialog(null, "Doctor added successfully!");
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

//system admin --> doctor tab --> view DOCTOR Table
    public static void ReadAllDoctor(DefaultTableModel model) {
        String id;
        String name;
        String hospital;

        model.setRowCount(0);
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select persondirectory.personid, persondirectory.name, hospitaldirectory.name from hospital.persondirectory, hospital.hospitaldirectory "
                    + "WHERE hospitaldirectory.hospitalid = persondirectory.hospitalid "
                    + "AND role = 'Doctor'";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
//            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                hospital = rs.getString(3);
                String[] row = {id, name, hospital};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //COMMUNITY ADMIN --> DOCTOR TAB --> VIEW DOCTORS
    public static void ReadDoctorCommunity(DefaultTableModel model, String cid) {
        String id, name, hospital, community;
        model.setRowCount(0);
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select persondirectory.personid, persondirectory.name, hospitaldirectory.name, communitydirectory.name from hospital.persondirectory, hospital.communitydirectory, hospital.hospitaldirectory "
                    + "WHERE persondirectory.hospitalid = hospitaldirectory.hospitalid AND hospitaldirectory.communityid = communitydirectory.communityid "
                    + "AND communitydirectory.communityid ='" + cid + "' AND role = 'Doctor'";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                hospital = rs.getString(3);
                community = rs.getString(4);
                String[] row = {id, name, hospital, community};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //SYSTEM ADMIN --> DOCTOR -->DELETE DOCTOR
    //hospital admin --> doctor tab -->delete doctor button
//    community admin --> doctor tab --> delete doctor
    public static void DeleteDoctor(String id) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a value to delete!");

            }else {
            String query1 = "delete from hospital.persondirectory where personid = '" + id + "' ";
            statement.executeUpdate(query1);

            JOptionPane.showMessageDialog(null, "Doctor deleted successfully!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
