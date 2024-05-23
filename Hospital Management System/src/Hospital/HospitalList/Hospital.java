/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.HospitalList;

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
public class Hospital {
    
    ////this class is made for performing CRUD on hospitaldirectory table 
    //com admin and sys admin are doing these actions

//SYSTEM ADMIN --> HOSPITAL --> ADD NEW HOSPITAL
    public static void CreateHospital(String name, String community) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter details!");
            } else {
                String query = "insert into hospital.hospitaldirectory (name, communityid) values (?,?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, name);
                preparedStmt.setString(2, community);
                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Hospital successfully added!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //SYSTEM ADMIN -->HOSPITAL -->UPDATE HOSPITAL
    //community admin -->hospital tab --> update hospital
    public static void UpdateHospital(String id, String name, String communityid) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (id.equals("") || name.equals("") || communityid.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter details to update!");
            } else {
                String query = "update hospital.hospitaldirectory set name = ?, communityid = ? where hospitalid = ?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, name);
                preparedStmt.setString(2, communityid);
                preparedStmt.setString(3, id);
                preparedStmt.execute();
                JOptionPane.showMessageDialog(null, "Hospital updated successfully!");

            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //PATIENT --> view nearest doctors
    public static void ReadHospitalDoctorCommunity(DefaultTableModel model, String cid) {

        String hid;
        String did;
        String hname;
        String dname;
        String cname;
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select hospitaldirectory.hospitalid, hospitaldirectory.name, persondirectory.personid, persondirectory.name, communitydirectory.name, communitydirectory.communityid from hospital.hospitaldirectory, hospital.persondirectory, hospital.communitydirectory "
                    + "WHERE persondirectory.role= 'Doctor' and persondirectory.hospitalid = hospitaldirectory.hospitalid AND hospitaldirectory.communityid = communitydirectory.communityid AND communitydirectory.communityid ='" + cid + "'";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                hid = rs.getString(1);
                hname = rs.getString(2);
                did = rs.getString(3);
                dname = rs.getString(4);
                cname = rs.getString(5);
                String[] row = {hid, hname, did, dname, cname};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //SYSTEM ADMIN --> HOSPITAL --> DELETE HOSPITAL BUTTON
    public static void DeleteHospital(String id) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a hospital ID to delete!");
            } else {
                String query1 = "delete from hospital.hospitaldirectory where hospitalid = '" + id + "' ";
                statement.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Hospital deleted!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //community admin --> hospital admin tab --> view HA
    public static void ReadHospitalAdmin(DefaultTableModel model, String cid) {
        String personid;
        String name;
        String hospitalid;
        model.setRowCount(0);
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select persondirectory.personid, persondirectory.username, persondirectory.hospitalid "
                    + "from hospital.persondirectory "
                    + "WHERE persondirectory.communityid = '" + cid + "' and role = 'Hospital Admin'";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                personid = rs.getString(1);
                name = rs.getString(2);
                hospitalid = rs.getString(3);
                String[] row = {personid, name, hospitalid};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //system admin --> hospital tab --> view hospitals TABLE
    public static void ReadAllHospital(DefaultTableModel model) {

        String hid;
        String hname;
        String cname;
        model.setRowCount(0);
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select hospitaldirectory.hospitalid, hospitaldirectory.name, communitydirectory.name from hospital.hospitaldirectory, hospital.communitydirectory "
                    + "WHERE hospitaldirectory.communityid = communitydirectory.communityid";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                hid = rs.getString(1);
                hname = rs.getString(2);
                cname = rs.getString(3);
                String[] row = {hid, hname, cname};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
