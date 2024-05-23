package User;

import Package.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Yamini Manral
 */
public class CreateUser {

    
    //NOT NULL CHECKS DONE
    //DATA VALIDATION DONE
    //THIS CLASS IS FOR CREATING USERS FROM SYS ADMIN, HOSPITAL ADMIN AND COMMUNITY ADMIN INTERFACES. ADDS TO PERSONDIRECTOR TABLE.
    
    
    //system admin --> hospital admin creation --> add hospital admin
    //community admin --> hospital admin creation --> add hospital admin
    //system admin --> doctor tab --> add new doctor
    public static void NewUser(String role, String username, String password, String name, String cid, String hid) {
        Boolean match = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,}$"); //Minimum eight characters, at least one uppercase letter, one lowercase letter and one number
        if (match!=true){
           JOptionPane.showMessageDialog(null, "Enter a valid password! Minimum four characters, at least one uppercase letter, one lowercase letter and one number "); 
        }
        else if(username.equals("")){
            JOptionPane.showMessageDialog(null,"Enter a username!");
        }else if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Enter a name!");
        }else{
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (name.equals("") || username.equals("") || name.equals("") ) {
                JOptionPane.showMessageDialog(null, "Please enter whole details!");
            } else {
            String query2 = "insert into hospital.persondirectory (role, username, password, name, communityid, hospitalid) values (?,?,?,?,?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query2);
//            preparedStmt.setString(1, personid);
            preparedStmt.setString(1, role);
            preparedStmt.setString(2, username);
            preparedStmt.setString(3, password);
            preparedStmt.setString(4, name);
//            preparedStmt.setString(5, house);
            preparedStmt.setString(5, cid);

            preparedStmt.setString(6, hid);

            preparedStmt.execute();

            JOptionPane.showMessageDialog(null, "New user registered!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }}
    }

    //system admin --> community admin tab --> add admin
    public static void AddNewCommunityAdmin(String role, String username, String password, String name, String cid) {
        NewUser(role, username, password, name, cid, null);

    }

        //system admin --> delete HA and CA
    //community admin --> hospital admin tab --> delete HA
    public static void DeleteUser(String username) {
        try {
            Connection connection = ConnectionProvider.Connect();
            Statement statement = connection.createStatement();

            if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a name to delete!");
            } else {
                String query1 = "delete from hospital.persondirectory where username= '" + username + "' ";
                statement.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "User deleted!");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
