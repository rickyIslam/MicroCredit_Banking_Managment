/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package microcreditbanking.classes;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author Ricky Islam
 */
public class transactionHistory {
    
    public void function_transaction_history () {
        
        String id = JOptionPane.showInputDialog(null, "Enter Account Number: ") ;
 
 if (id.isEmpty()) {
     JOptionPane.showMessageDialog(null, "Give A Valid A/C Number !! ");
     
 }
 else {
     
     try {
         
   
          Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shunno");
Statement stmt=con.createStatement();
ResultSet rs = null ;
rs =  stmt.executeQuery("SELECT * FROM customer where account like '"+id+"' ");

if (rs.next()) {
    
     try {
 System.out.println(id);
     Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con111=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shunno");
Statement stmt111=con111.createStatement();
ResultSet rs111 = null ;
rs111 =  stmt111.executeQuery("SELECT * FROM history where customer_id like '"+id+"'  ");

    ResultSetMetaData rsmt = rs111.getMetaData() ;
    int c = rsmt.getColumnCount() ;
    Vector colum = new Vector (c) ;
    for (int i = 1; i<=c ; i++) {
        
        colum.add(rsmt.getColumnName(i));
    }
    
Vector data = new Vector () ;
Vector row = new Vector () ;

while (rs111.next()) {
    row = new Vector (c) ;
    for (int i = 1; i<=c; i++) {
        row.add (rs111.getString (i)) ;
    }
    
    data.add(row);
}


     JFrame frame = new JFrame () ;
     frame.setSize(1370,730);

     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
     JPanel panel = new JPanel () ;
     JTable  table = new JTable (data,colum) ;
      JScrollPane jsp = new JScrollPane (table) ;
      panel.setLayout(new BorderLayout());
      panel.add(jsp,BorderLayout.CENTER) ;
      frame.setContentPane(panel);
      frame.setVisible(true);
   
  
     

 }
 
 catch (Exception e) {
     
     JOptionPane.showMessageDialog(null, e);
 }
 
    
}

else {
     JOptionPane.showMessageDialog(null,"Account Doesn't Exists");
}

     }
     
     catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
     }
 }   
        
        
       
        
        
    }
    
}
