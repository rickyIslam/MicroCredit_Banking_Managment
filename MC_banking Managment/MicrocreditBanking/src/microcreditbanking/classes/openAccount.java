/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package microcreditbanking.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricky Islam
 */
public class openAccount extends javax.swing.JFrame {

    /**
     * Creates new form openAccount
     */
    public openAccount() {
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
        jTextField10 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextField9 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField10);
        jTextField10.setBounds(1020, 480, 190, 30);

        jLabel16.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel16.setText("Current Loan: ");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(820, 480, 190, 42);

        jButton3.setFont(new java.awt.Font("Arabic Typesetting", 1, 28)); // NOI18N
        jButton3.setText("Generate Here !!!");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(520, 120, 210, 80);

        jButton2.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jButton2.setText("<<Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(710, 550, 210, 80);

        jButton1.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jButton1.setText("Save Information >>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(930, 550, 290, 80);

        jRadioButton2.setFont(new java.awt.Font("Arabic Typesetting", 1, 28)); // NOI18N
        jRadioButton2.setText("Female");
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(1110, 280, 93, 30);

        jRadioButton1.setFont(new java.awt.Font("Arabic Typesetting", 1, 28)); // NOI18N
        jRadioButton1.setText("Male");
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(1020, 280, 90, 30);
        jPanel1.add(jTextField9);
        jTextField9.setBounds(1020, 420, 190, 30);
        jPanel1.add(jTextField8);
        jTextField8.setBounds(1020, 370, 190, 30);
        jPanel1.add(jTextField7);
        jTextField7.setBounds(1020, 320, 190, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(290, 280, 60, 30);

        jLabel15.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel15.setText("Name Of First Nominee: ");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(700, 370, 330, 42);

        jLabel14.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel14.setText("Current Balance: ");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(790, 420, 220, 42);

        jLabel13.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel13.setText("Annual Income: ");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(810, 320, 202, 42);

        jLabel12.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel12.setText("Account Type: ");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(820, 220, 200, 42);

        jLabel11.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel11.setText("Sex: ");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(950, 280, 60, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(290, 490, 220, 150);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6);
        jTextField6.setBounds(290, 440, 220, 30);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5);
        jTextField5.setBounds(290, 380, 220, 30);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(290, 330, 220, 30);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Current_Account", "Savings_Account ", "Fixed_Deposite ", " ", " " }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox4);
        jComboBox4.setBounds(1020, 220, 190, 30);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", " " }));
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(440, 280, 70, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(360, 280, 70, 30);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(290, 220, 220, 30);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(290, 170, 220, 30);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(290, 120, 220, 30);

        jLabel10.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel10.setText("Full Address: ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(110, 500, 170, 42);

        jLabel9.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel9.setText("National ID Number: ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 440, 269, 42);

        jLabel8.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel8.setText("Occupation: ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(120, 380, 160, 42);

        jLabel7.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel7.setText("Phone Number: ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 330, 200, 42);

        jLabel6.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel6.setText("Date Of Birth: ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 280, 190, 30);

        jLabel5.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel5.setText("Customer Name: ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 220, 220, 42);

        jLabel4.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel4.setText("Account Number: ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 160, 230, 42);

        jLabel3.setFont(new java.awt.Font("Arabic Typesetting", 1, 36)); // NOI18N
        jLabel3.setText("Current Date: ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 110, 180, 42);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 52)); // NOI18N
        jLabel2.setText("Create New Account");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(400, 40, 580, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microcreditbanking/image/heat-wide.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1350, 680);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         String date  = jTextField1.getText() ;
         String ac = jTextField2.getText() ;
          String name = jTextField3.getText() ;
           String birth  ;
            String phone = jTextField4.getText() ;
             String occupation = jTextField5.getText() ;
              String nid = jTextField6.getText() ;
               String address = jTextArea1.getText() ;
                String  sex = null ;
                 String  marriage = null ;
                  String income = jTextField7.getText() ;
                   String nominee  = jTextField8.getText() ;
                    String balance = jTextField9.getText() ;
                    String loan = jTextField10.getText() ;
                    String type = (String) jComboBox4.getSelectedItem() ;
                   String key = null ; 
           
                 
                   if (type.matches("Savings_Account ")) {
                        key = "2" ;
                    }
                 
                    if (type.matches("Current_Account")) {
                       key = "1" ;  
                    }
               
                  if (type.matches("Fixed_Deposite ")){
                        key = "3" ;
                    }
   
                
       if (jRadioButton1.isSelected()){
           sex = "Male" ;
       } 
         if (jRadioButton2.isSelected()){
           sex = "Female" ;
       }

              String bdate = (String) jComboBox1.getSelectedItem() ;
        String bmonth = (String) jComboBox2.getSelectedItem() ;
        String byear = (String) jComboBox3.getSelectedItem() ;
         
       birth  = (" " + bdate + " - " + bmonth +" - " + byear ); 
       
       
        if ((date.isEmpty() || ac.isEmpty() || name.isEmpty() || birth.isEmpty() || phone.isEmpty() || occupation.isEmpty() || nid.isEmpty() || address.isEmpty() || sex.isEmpty() || type.isEmpty() || income.isEmpty() || nominee.isEmpty() || loan.isEmpty() || balance.isEmpty()))   {
          
        JOptionPane.showMessageDialog(null, "Please Fill Up All The Fields !!! "); 
      } 
      else {
        
   
 
 
 
 
   try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shunno");

Statement stmt=con.createStatement();
stmt.executeQuery ("INSERT INTO customer " + " VALUES (' "+date+" ', '"+ac+"', '"+name+"', '"+birth+"', '"+phone+"',' "+occupation+" ', '"+nid+"', '"+address+"', '"+sex+"', '"+type+"', '"+key+"', ' "+income+" ', '"+nominee+"', '"+balance+"' , '"+loan+"')");  

//stmt.executeQuery("insert into customer values (?,?,?,?,?,?,?,?,?,?,?,?,?) " );
//
//stmt.setString (1, date) ;
con.close();

  JOptionPane.showMessageDialog(null, "Data Successfully Added To Database !!! ");

      jTextField1.setText(null);
           jTextField2.setText(null);
              jTextField3.setText(null);
                 jTextField5.setText(null);
                    jTextField7.setText(null);
                       jTextField8.setText(null);
                          jTextField4.setText(null);
                             jTextField9.setText(null);
                                jTextField10.setText(null);
                             jTextField6.setText(null);
                             jTextArea1.setText(null);

  dispose () ;

}
                catch(Exception e){
                     JOptionPane.showMessageDialog(null, " Error: "+e);
                   }
        
        
        }   
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
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
jTextField1.setText(currentDate);

           int a = (int)(Math.random()*999999);
    String value = String.valueOf(a) ;
    jTextField2.setText(value);
    

        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
              jTextField1.setText(null);
           jTextField2.setText(null);
              jTextField3.setText(null);
                 jTextField5.setText(null);
                    jTextField7.setText(null);
                       jTextField8.setText(null);
                          jTextField4.setText(null);
                             jTextField9.setText(null);
                             jTextField6.setText(null);
                             jTextArea1.setText(null);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void openAccountFunction () {
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
            java.util.logging.Logger.getLogger(openAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(openAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(openAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(openAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new openAccount().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
