/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.Person;

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
public class House {
//only community admin can do crud on house class/table
    
    //COMMUNITY ADMIN --> HOUSE INFO --> ADD NEW HOUSE
    public static void AddHouse(String name, String communityid) {

        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            if (name.equals("") ) {
                JOptionPane.showMessageDialog(null, "Please enter details!");
            } else {
            String query = "INSERT INTO hospital.houselist (name, communityid) VALUES ( ?,?)";
            PreparedStatement preparedStmt1 = connection.prepareStatement(query);
            preparedStmt1.setString(1, name);
            preparedStmt1.setString(2, communityid);
            preparedStmt1.execute();

            JOptionPane.showMessageDialog(null, "House added successfully!");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void DeleteHouse(String houseid) {

        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            if (houseid.equals("") ) {
                JOptionPane.showMessageDialog(null, "Please enter ID to delete!");
            } else {
            String query = "delete from hospital.houselist where houseid = ?";
            PreparedStatement preparedStmt1 = connection.prepareStatement(query);
            preparedStmt1.setString(1, houseid);
            preparedStmt1.execute();

            JOptionPane.showMessageDialog(null, "House deleted successfully!");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void ViewHouse(DefaultTableModel model, String cid){
        String id;
        String name;
        model.setRowCount(0);
        
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select houselist.houseid, houselist.name from hospital.houselist WHERE communityid ='" + cid + "'";
            
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
    
}
