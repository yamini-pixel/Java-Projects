/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package neu.oncampusams.financeadministration.Finance;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import neu.oncampusams.campusadministration.CampusAdmin.*;
import neu.oncampusams.databaseConnection.JDBCConnection;
import neu.oncampusams.systemadministration.SystemAdmin.Login;

/**
 *
 * @author Yamini Manral
 */
public class FinanceAdmin extends javax.swing.JFrame {

    FinAdminInfoDirectory faidir = new FinAdminInfoDirectory();

    String emailID;

    /**
     * Creates new form Warden1
     */
    public FinanceAdmin() {
        initComponents();
        populateQueryTable();
    }

    public FinanceAdmin(String eid) {
        initComponents();
        emailID = eid; //passing the value of emailid
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campus = new javax.swing.JComboBox<>();
        viewIncome1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        finBuilding = new javax.swing.JTable();
        viewIncome = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFinQuery = new javax.swing.JTable();
        txtQueryId = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        jcbStatus = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finance Administrator Portal");
        setMaximumSize(new java.awt.Dimension(1060, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/oncampusams/images/neulogo1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 160));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Location:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 90, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Northeastern University");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 270, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("On-Campus Accommodation");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 270, -1));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEmail.setText("email");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 230, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Welcome!");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 270, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Management System");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 270, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 160));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Select the campus for which you want to see expenses");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 400, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("View details of income by student rent and meal plans:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 410, 40));

        campus.setBackground(new java.awt.Color(242, 242, 242));
        campus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        campus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boston", "Charlotte", "San Francisco", "Seattle", "Silicon Valley", "Portland (Maine)", "Toronto", "Vancouver", "London" }));
        campus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campusActionPerformed(evt);
            }
        });
        jPanel3.add(campus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 240, 40));

        viewIncome1.setBackground(new java.awt.Color(0, 0, 0));
        viewIncome1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        viewIncome1.setForeground(new java.awt.Color(255, 255, 255));
        viewIncome1.setText("Export as PDF");
        viewIncome1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewIncome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewIncome1ActionPerformed(evt);
            }
        });
        jPanel3.add(viewIncome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 120, 40));

        finBuilding.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        finBuilding.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Campus", "Total Income"
            }
        ));
        jScrollPane4.setViewportView(finBuilding);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 120));

        viewIncome.setBackground(new java.awt.Color(0, 0, 0));
        viewIncome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        viewIncome.setForeground(new java.awt.Color(255, 255, 255));
        viewIncome.setText("View");
        viewIncome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewIncomeActionPerformed(evt);
            }
        });
        jPanel3.add(viewIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 90, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 530, 380));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/oncampusams/images/finanace_bg.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 500));

        jTabbedPane1.addTab("Income", new javax.swing.ImageIcon(getClass().getResource("/neu/oncampusams/images/salary.png")), jPanel2); // NOI18N

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFinQuery.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblFinQuery.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblFinQuery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Query ID", "Raised By", "Status", "Description", "Note"
            }
        ));
        jScrollPane2.setViewportView(tblFinQuery);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 770, 110));

        txtQueryId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel5.add(txtQueryId, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 120, 40));

        txtNote.setColumns(20);
        txtNote.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNote.setRows(5);
        jScrollPane3.setViewportView(txtNote);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 230, 90));

        jcbStatus.setBackground(new java.awt.Color(204, 204, 204));
        jcbStatus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Under review", "Processed" }));
        jcbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbStatusActionPerformed(evt);
            }
        });
        jPanel5.add(jcbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 250, 40));

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update Query");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 140, 40));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Status");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 110, 40));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Query ID");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 110, 40));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Note");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 110, 40));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 850, 450));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/oncampusams/images/finanace_bg.jpg"))); // NOI18N
        jLabel5.setText("jLabel4");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 500));

        jTabbedPane1.addTab("Resolve Query", new javax.swing.ImageIcon(getClass().getResource("/neu/oncampusams/images/solved.png")), jPanel4); // NOI18N

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1060, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int a = JOptionPane.showConfirmDialog(null, "Do you really wanna logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void campusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campusActionPerformed

    private void jcbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbStatusActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int queryId = Integer.parseInt(txtQueryId.getText());
        String note = txtNote.getText();
        String status = jcbStatus.getSelectedItem().toString();
        faidir.updateQueryTable(note, status, queryId);

        DefaultTableModel model = (DefaultTableModel) tblFinQuery.getModel();
        model.setRowCount(0);

        populateQueryTable();
        txtQueryId.setText(" ");
        txtNote.setText(" ");
        jcbStatus.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void viewIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewIncomeActionPerformed
        // TODO add your handling code here:
        String Campus = (String) campus.getSelectedItem();
        String Expenses;
        DefaultTableModel model = (DefaultTableModel) finBuilding.getModel();
        model.setRowCount(0);
        try {
            Connection connection = JDBCConnection.Connect();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT Expenses, campus FROM oncampusamsdb.incomeview where campus = '" + Campus + "';");

            //push column values to the table fields
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                Campus = rs.getString(1);
                Expenses = rs.getString(2);
                String[] row = {Campus, Expenses};
                model.addRow(row);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_viewIncomeActionPerformed

    private void viewIncome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewIncome1ActionPerformed
        // TODO add your handling code here:

        String datefrom = "Campus";
        String dateto = "Total Income";

        MessageFormat header = new MessageFormat("Report of  Campus " + datefrom + " Total Income " + dateto);
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try {
            finBuilding.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch (Exception e) {
            e.getMessage();

        }
    }//GEN-LAST:event_viewIncome1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FinanceAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinanceAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinanceAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinanceAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinanceAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> campus;
    private javax.swing.JTable finBuilding;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JTable tblFinQuery;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JTextField txtQueryId;
    private javax.swing.JButton viewIncome;
    private javax.swing.JButton viewIncome1;
    // End of variables declaration//GEN-END:variables

    public void SetEmailID() {
        lblEmail.setText(emailID);
    }

    public void populateQueryTable() {
        Connection connection = JDBCConnection.Connect();
        try {
            Statement statement = (Statement) connection.createStatement();
            String sql = "SELECT * FROM oncampusamsdb.financequerytable";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String queryId = rs.getString(1);
                String raisedBy = rs.getString(2);
                String status = rs.getString(3);
                String description = rs.getString(4);
                String note = rs.getString(5);

                String tbData[] = {queryId, raisedBy, status, description, note};
                DefaultTableModel tblModel = (DefaultTableModel) tblFinQuery.getModel();
                tblModel.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccomodationAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}