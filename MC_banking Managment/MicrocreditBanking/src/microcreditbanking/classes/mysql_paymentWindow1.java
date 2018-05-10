/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package microcreditbanking.classes;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricky Islam
 */
public class mysql_paymentWindow1 extends javax.swing.JFrame {

    /**
     * Creates new form deposite
     */
    public mysql_paymentWindow1() {
        initComponents();
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
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(null);
        jPanel1.add(jTextField8);
        jTextField8.setBounds(240, 430, 210, 40);

        jLabel10.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Still Paid : ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(90, 430, 140, 42);

        jButton3.setFont(new java.awt.Font("Arabic Typesetting", 1, 30)); // NOI18N
        jButton3.setText("Refresh Fields");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(40, 570, 190, 50);

        jButton2.setFont(new java.awt.Font("Arabic Typesetting", 1, 30)); // NOI18N
        jButton2.setText("Save Transaction");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(250, 570, 210, 50);
        jPanel1.add(jTextField6);
        jTextField6.setBounds(240, 490, 210, 40);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5);
        jTextField5.setBounds(240, 370, 210, 40);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(240, 310, 210, 40);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(240, 250, 210, 40);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(240, 190, 210, 40);

        jLabel9.setFont(new java.awt.Font("Arabic Typesetting", 1, 32)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Payment Amount:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 490, 220, 38);

        jLabel7.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Loan Amount:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 370, 174, 42);

        jLabel6.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customer's Name: ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 310, 240, 42);

        jLabel5.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Account Number: ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 250, 230, 40);

        jLabel4.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date: ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 190, 74, 40);

        jButton1.setFont(new java.awt.Font("Arabic Typesetting", 1, 24)); // NOI18N
        jButton1.setText("Generate Detail");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(480, 70, 170, 40);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(300, 70, 160, 40);

        jLabel3.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Loan Number: ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 70, 270, 40);

        jLabel2.setFont(new java.awt.Font("Arabic Typesetting", 1, 48)); // NOI18N
        jLabel2.setText("Payment Window");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(240, 10, 320, 56);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microcreditbanking/image/m_background.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -20, 730, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         String id = jTextField1.getText() ;
        
if (id.isEmpty()) {
    
    JOptionPane.showMessageDialog(null, "Fill Up The Fields Correctly !!! ");
}

else {
             try {
                 Class.forName("com.mysql.jdbc.Driver") ;
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
             }
       Connection con = null ;
             try {
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "" );
             } catch (SQLException ex) {
                 Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
             }
       Statement st = null;
             try {
                 st = con.createStatement();
             } catch (SQLException ex) {
                 Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
             }
       ResultSet rs = null ;
             try {
                 rs =  st.executeQuery("SELECT * FROM loan where loan_id = "+id);
                 while (rs.next()) {
                    
                     String v = rs.getString("account_num") ;
                  String b = rs.getString("name") ;
                  String c = rs.getString("amount") ;
                    String m  = rs.getString("still_paid") ;
               
int day, month, year ;
int second, minute, hour ;
GregorianCalendar date = new  GregorianCalendar ( ) ;
day = date.get (Calendar.DAY_OF_MONTH) ;
month = date.get(Calendar.MONTH) ;
year = date.get(Calendar.YEAR) ;

second = date.get(Calendar.SECOND) ;
minute = date.get(Calendar.MINUTE) ;
hour = date.get(Calendar.HOUR) ;

String currentDate = (" " + day + " - " + (month+1) +" - " + year );

                                                         

    jTextField2.setText (currentDate) ;  
     jTextField3.setText (v) ;    
      jTextField4.setText (b) ;    
       jTextField5.setText (c) ;
       jTextField8.setText (m) ;
 
             
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
             }
            
    
    
    
}    
       
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String id = jTextField1.getText() ;
        String date = jTextField2.getText () ;
        String ac = jTextField3.getText () ;
         String name  = jTextField4.getText () ;
         String amount = jTextField5.getText() ;
         String still_paid = jTextField8.getText() ;
         
         String payment = jTextField6.getText() ;
                        
                    
                     double latest_payment = Float.parseFloat(payment) ;
                     double old_payment = Float.parseFloat(still_paid) ;
                          
                     double sum = latest_payment + old_payment ;
                     
                     String payment_amount = String.valueOf(sum) ; // final will be updated to database

   // String iMode = (String) jComboBox1.getSelectedItem() ;
                          
       
        if ((payment.isEmpty()))   {
          
        JOptionPane.showMessageDialog(null, "Please Fill Up All The Fields !!! "); 
      } 
      else {
        

              try {
                 Class.forName("com.mysql.jdbc.Driver") ;
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
             }
       Connection con = null ;
             try {
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "" );
             } catch (SQLException ex) {
                 Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
             }
//       Statement st = null;
//             try {
//                 st = con.createStatement();
//             } catch (SQLException ex) {
//                 Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
//             }
//       ResultSet rs = null ;
//             try {
//                 rs =  st.executeQuery(" update loan set still_paid = 'payment_amount' where loan_id = " +id);
//
//             } catch (SQLException ex) {
//                 Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
//             }
//            
    
   String query = "update loan set still_paid = ? where loan_id = ?" ;
            try {
                PreparedStatement ps = con.prepareStatement(query) ;
                  ps.setString(1, payment_amount);
                   ps.setString(2, id);
                   ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) { 
                Logger.getLogger(mysql_paymentWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }   
        
          JOptionPane.showMessageDialog(null, "Transactin Completed !");

         jTextField1.setText(null);
           jTextField2.setText(null);
              jTextField3.setText(null);
                 jTextField5.setText(null);
                
               
                          jTextField4.setText(null);
                    
                             jTextField6.setText(null);
                        
                             
                             
                             dispose () ;
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
                jTextField1.setText (null) ;
          jTextField2.setText (null) ;
            jTextField3.setText (null) ;
              jTextField4.setText (null) ;  
                jTextField5.setText (null) ;
                jTextField6.setText (null) ;
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void payment_chart () throws ClassNotFoundException, SQLException {
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
            java.util.logging.Logger.getLogger(mysql_paymentWindow1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mysql_paymentWindow1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mysql_paymentWindow1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mysql_paymentWindow1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mysql_paymentWindow1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
