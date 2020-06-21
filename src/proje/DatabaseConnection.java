/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Ege Uzma 170503013
package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    private static Connection conn ;
   
    public static Connection getConnection() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
            conn = DriverManager.getConnection(url, "egeuzma", "egeuzma");
            
            } catch (SQLException e) {
             System.err.println(e); 
            } catch (ClassNotFoundException e){  
            System.err.println(e); 
        }
        return conn;
    }
}
