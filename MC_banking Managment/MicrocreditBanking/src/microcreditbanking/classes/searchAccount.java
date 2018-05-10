/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package microcreditbanking.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricky Islam
 */
public class searchAccount {
    
    
     public void searchAccountFunction () {
        
        
               String num = JOptionPane.showInputDialog(null, "Give Desired Account Number: ") ;
      
        if (num.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Give A Valid Account Number !!! ");
            
            
            
            
        }
        
        else {
            
           try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shunno");

Statement stmt=con.createStatement();
ResultSet rs = null ;
rs =  stmt.executeQuery("SELECT * FROM customer WHERE account like '"+num+"' ");

if (rs.next()) {
     
    try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shunno");
Statement stmt1=con.createStatement();
ResultSet rs1 = null ;
rs1 =  stmt1.executeQuery("SELECT * FROM customer  WHERE account like '"+num+"' ");

       
        while (rs1.next()) {
          String a  = rs.getString("cur_date") ;
              String b = rs.getString("account") ;
                  String c = rs.getString("name") ;
                      String d = rs.getString("b_day") ;
                          String e = rs.getString("phone") ;
                              String f  = rs.getString("occupation") ;
                                  String g = rs.getString("nid") ;
                                      String h  = rs.getString("address") ;
                                          String i = rs.getString("sex") ;
                                              String j = rs.getString("account_type") ;
                                              String jj = rs.getString("account_key") ;
                                                  String k  = rs.getString("income") ;
                                                      String l  = rs.getString("nominee") ;
                                                          String m  = rs.getString("balance") ;
                                                           String n  = rs.getString("loan") ;
                                                          
                      

    String line = "Customer Name: "+c+"\n"+"Account Number: "+b+"\n"+"Account Created: "+a+"\n"+"Birth Date: "+d+"\n"+"Phone Number: "+e+"\n"+"Occupation: "+f+"\n"+"Address: "+h+"\n"+"NID Number: "+g+"\n"+"Sex: "+i+"\n"+"Account Type: "+j+"\n"+"Annual Income: "+k+"\n"+"Nominee Name:  "+l+"\n"+"Current Balance: "+m+"\n"+ "Current Loan: "+n+"\n" ;         
   
   JOptionPane.showMessageDialog(null,line);
  

}
 con.close();  
 
 
        
          }
    
    catch(Exception e){
                     JOptionPane.showMessageDialog(null, " Error: "+e);
                   } 
    
    
    
    
    
}
else {
    JOptionPane.showMessageDialog(null, "Account Doesn't Exists !!! "); 
}


 con.close();      
        
          }

                catch(Exception e){
                     JOptionPane.showMessageDialog(null, " Error: "+e);
                   } 
            
            
            
            
            
        }
            

        
        
    }
    
}
