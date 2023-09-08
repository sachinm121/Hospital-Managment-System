/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;
import java.sql.*;
/**
 *
 * @author Sheetal
 */
public class Conn {
    Connection c;
    Statement s;
        
    Conn()
    { 
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          //c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb?user=root");
          c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "Sachin@166");
          s = c.createStatement();
      }   
      catch(Exception e)
      {
           System.out.println(e);
      }
    }
    
}
