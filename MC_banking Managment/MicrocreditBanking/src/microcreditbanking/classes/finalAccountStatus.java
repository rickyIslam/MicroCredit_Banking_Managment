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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ricky Islam
 */
public class finalAccountStatus {
    
    public static void fas () throws ClassNotFoundException, SQLException {
        

       
       Class.forName("com.mysql.jdbc.Driver") ;
       Connection con = null ;
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "" );
       Statement st = null;
       st = con.createStatement();
       ResultSet rs = null ;
       rs =  st.executeQuery("SELECT * FROM loan");
//       while (rs.next()) {
//          String v = rs.getString("category") ;
////          String w = rs.getString("b") ;
////          String x = rs.getString("c") ;
////          String y = rs.getString("d") ;
////          String z = rs.getString("e") ;
//         // String line = "Name: "+v+"\n"+"Faculty: "+w+"\n"+"ID No: "+x+"\n"+"Reg No: "+y+"\n"+"Sex: "+z+"\n" ;
//          
//          JOptionPane.showMessageDialog(null, v); 
            
       
            ResultSetMetaData rsmt = rs.getMetaData() ;
    int c = rsmt.getColumnCount() ;
    Vector colum = new Vector (c) ;
    for (int i = 1; i<=c ; i++) {
        
        colum.add(rsmt.getColumnName(i));
    }
    
Vector data = new Vector () ;
Vector row = new Vector () ;

while (rs.next()) {
    row = new Vector (c) ;
    for (int i = 1; i<=c; i++) {
        row.add (rs.getString (i)) ;
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
    
}
