/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package microcreditbanking.classes;

/**
 *
 * @author Ricky Islam
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricky Islam
 */
public class fieldAdmin {

    /**
     * @param args the command line arguments
     */
    public static void mt () {
        // TODO code application logic here
        
                 String pass ;
            pass  = JOptionPane.showInputDialog (null, "Please Enter Admin Code.... ") ;
            
            if (pass.isEmpty()) {
                
                     JOptionPane.showMessageDialog(null, " Empty Field Not Permitted !! "); 
                
            }
            
            else {
                
                try {
            Class.forName("com.mysql.jdbc.Driver") ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fieldAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
 Connection con = null ;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "" );
        } catch (SQLException ex) {
            Logger.getLogger(fieldAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(fieldAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st.executeUpdate ("INSERT INTO password_field "+"VALUE('"+pass+"')");  
        } catch (SQLException ex) {
            Logger.getLogger(fieldAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                     JOptionPane.showMessageDialog(null, " Inserted Successfully !! "); 
                
            }
            
            
         
        
        
        
    }
}

