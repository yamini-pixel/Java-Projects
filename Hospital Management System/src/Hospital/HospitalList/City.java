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
public class City {
    //this class is made for performing CRUD on citydirectory table 
    //data validation //not null checks done OK
    
    
    //system admin --> city tab --> create a city
    public static void CreateCity(String name){
        try{
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
if (name.equals("") ) {
                JOptionPane.showMessageDialog(null, "Please enter details to update!");
            } else {
            String query = "insert into hospital.citydirectory (cityname) values (?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.execute();
            
            JOptionPane.showMessageDialog(null, "City added!");
}
            connection.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    //system admin --> city tab --> update city
    public static void UpdateCity(String id, String name) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (id.equals("") ) {
                JOptionPane.showMessageDialog(null, "Please enter details to update!");
            } else {
                String query = "update hospital.citydirectory set cityname = ? where cityid = ?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, name);
                preparedStmt.setString(2, id);
                preparedStmt.execute();
                JOptionPane.showMessageDialog(null, "City updated successfully!");

            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //system admin --> city tab --> view city
    
    public static void ReadAllCity(DefaultTableModel model) {

        String cityid;
        String name;
        model.setRowCount(0);
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select citydirectory.cityid, citydirectory.cityname from hospital.citydirectory";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                cityid = rs.getString(1);
                name = rs.getString(2);
                String[] row = {cityid, name};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //system admin --> city tab --> delete city
     public static void DeleteCity(String id) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a City ID to delete!");
            } else {
                String query1 = "delete from hospital.citydirectory where cityid = '" + id + "' ";
                statement.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "City deleted!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
