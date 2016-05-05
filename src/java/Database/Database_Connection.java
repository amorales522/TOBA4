package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database_Connection 
{
    public static Connection Connection()
    {
        
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/toba","root","");
            } catch (SQLException ex) {
                Logger.getLogger(Database_Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;
    }
}
