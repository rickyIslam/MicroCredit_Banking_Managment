/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package microcreditbanking.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricky Islam
 */
public class chechLoanStatus {
    
     public void chechLoanStatusFunction () {
        
        
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
rs =  stmt.executeQuery("SELECT * FROM payment WHERE p_account_no like '"+num+"' ");

if (rs.next()) {
     
    try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shunno");
Statement stmt1=con.createStatement();
ResultSet rs1 = null ;
rs1 =  stmt1.executeQuery("SELECT * FROM payment  WHERE p_account_no like '"+num+"' ");

       
        while (rs1.next()) {
          String a  = rs.getString("P_CUS_NAME") ;
              String b = rs.getString("P_ACCOUNT_NO") ;
                  String c = rs.getString("P_BORROW_DATE") ;
                      String d = rs.getString("P_DEADLINE") ;
                          String e = rs.getString("P_LOAN_AMOUNT") ;
                              String f  = rs.getString("P_AMOUNT") ;
                                 
      
      float loan = Float.parseFloat(e) ;
      float paid = Float.parseFloat(f) ;
      float result = loan - paid ;
      String r = String.valueOf(result) ;
      
                      

    String line = "Customer Name: "+a+"\n"+"Account Number: "+b+"\n"+"Borrowing Date: "+c+"\n"+"Payment Deadline: "+d+"\n"+"Total Loan: "+e+"\n"+"Total Paid: "+f+"\n"+"-----------------------------------"+"\n"+"Still Have To Pay: "+r+"\n" ;         
   
   JOptionPane.showMessageDialog(null,line);
  

}
 con.close();  
 
 
        
          }
    
    catch(Exception e){
                     JOptionPane.showMessageDialog(null, " Error: "+e);
                   } 
    
    
    
    
    
}
else {
    JOptionPane.showMessageDialog(null, "No Payment Record !!! "); 
}


 con.close();      
        
          }

                catch(Exception e){
                     JOptionPane.showMessageDialog(null, " Error: "+e);
                   } 
            
            
            
            
            
        }
            

        
        
    }
    
}
