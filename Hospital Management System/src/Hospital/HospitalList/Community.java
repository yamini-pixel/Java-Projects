/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.HospitalList;

import Package.ConnectionProvider;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yamini Manral
 */
public class Community {

    //this class is made for performing CRUD on Communitydirectory table 
    //not related to community admin, refer to persondirectory table in DB and createUser class here
    //data validation done OK not null checks
    
    //system admin --> community tab --> create new community
    public static void CreateCommunity(String name, String cityid) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            if ( name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a name to proceed!");
            } else {
            String query = "insert into hospital.communitydirectory (name, cityid) values (?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, cityid);
            preparedStmt.execute();

            JOptionPane.showMessageDialog(null, "Community successfully added!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//system admin--> community tab --> view table of community
    public static void ReadAllCommunity(DefaultTableModel model) {

        String id;
        String name;
        String city;
        model.setRowCount(0);
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();
            String query = "select communitydirectory.communityid, communitydirectory.name, citydirectory.cityname from hospital.communitydirectory, hospital.citydirectory "
                    + "WHERE communitydirectory.cityid = citydirectory.cityid";
            ResultSet rs = statement.executeQuery(query);

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                city = rs.getString(3);
                String[] row = {id, name, city};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//system admin --> community tab -->delete community
    public static void DeleteCommunity(String id) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (id == null) {
                JOptionPane.showMessageDialog(null, "Please enter a community ID to proceed!");
            } else {
                String query1 = "delete from hospital.communitydirectory where communityid = '" + id + "' ";
                statement.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Community deleted!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //system admin --> community tab --> update community
    public static void UpdateCommunity(String id, String name, String cityid) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (id.equals("") || name.equals("") || cityid.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter details to update!");
            } else {
                String query = "update hospital.communitydirectory set name = ?, cityid = ? where communityid = ?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, name);
                preparedStmt.setString(2, cityid);
                preparedStmt.setString(3, id);
                preparedStmt.execute();
                JOptionPane.showMessageDialog(null, "Community updated successfully!");

            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
