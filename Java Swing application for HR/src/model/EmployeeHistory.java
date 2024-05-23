/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Yamini Manral
 */
public class EmployeeHistory {
   
    private ArrayList<Employees> history; //history is the array used for storing information of the employees, image is for storing image of employee
    
    
    public EmployeeHistory(){ //default constructor
        
        this.history = new ArrayList<Employees>(); //new employee details will be stored through this code
        
    }
    //getter and stter for history

    public ArrayList<Employees> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Employees> history) {
        this.history = history;
    }

   //add new employee for save button
    public Employees addNewEmployee(){
        Employees newEmployee = new Employees();
        history.add(newEmployee);
        return newEmployee;
    }

//delete employee
    public void deleteEmployee(Employees emp) {
        history.remove(emp);
    }

    public void setPhoto(String valueOf) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIcon(ImageIcon image) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getPhoto(String path) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

  
