/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.Encounter;

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
public class Encounter {


    //PATIENT --> BOOK APPOINTMENT
    public static void BookAppointment(String doctor, String patient, String date, String reason) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "insert into hospital.encounterdirectory (doctorid, patientid, datetime, reason) values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, doctor);
            preparedStmt.setString(2, patient);
//            preparedStmt.setString(3, hospital);
            preparedStmt.setString(3, date);
            preparedStmt.setString(4, reason);
//            preparedStmt.setString(6, time);

            preparedStmt.execute();

            JOptionPane.showMessageDialog(null, "Appointment booked successfully!");
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //DOCTOR --> view appointments
    public static void ReadAppointment(DefaultTableModel model, String personid) {
        
        String patient, pid, date, reason, status;
        model.setRowCount(0);
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select encounterdirectory.encounterid, persondirectory.name, encounterdirectory.status, encounterdirectory.datetime, encounterdirectory.reason "
                    + "from hospital.encounterdirectory, hospital.persondirectory "
                    + "WHERE encounterdirectory.patientid = persondirectory.personid "
                    + "AND encounterdirectory.doctorid ='" + personid + "'";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                pid = rs.getString(1);
                patient = rs.getString(2);
                date = rs.getString(4);
                status = rs.getString(3);
                reason = rs.getString(5);
                String[] row = {pid, patient, status, date, reason};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    //PATIENT --> VIEW HISTORY
    public static void VisitHistory(DefaultTableModel model, String personid){
        String eid, hr, bp, diagnosis, status;
        model.setRowCount(0);
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select encounterdirectory.encounterid, encounterdirectory.hr, encounterdirectory.bp, encounterdirectory.diagnosis, encounterdirectory.status "
                    + "from hospital.encounterdirectory " //order matters
                    + "WHERE encounterdirectory.patientid ='" + personid + "'";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                eid = rs.getString(1);
                hr = rs.getString(2);
                bp = rs.getString(3);
                diagnosis = rs.getString(4);
                status = rs.getString(5);
                String[] row = {eid, hr, bp, diagnosis, status};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void CancelAppointment(String eid){
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (eid.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a visit ID to delete!");
            } else {
                String query1 = "delete from hospital.encounterdirectory where encounterid = '" + eid + "' ";
                statement.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Appointment cancelled!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}
