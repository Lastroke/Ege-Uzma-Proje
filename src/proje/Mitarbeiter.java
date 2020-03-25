/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


public class Mitarbeiter {
    private String FirstName , LastName ;
    private String Level ;
    private LocalDate CertificateDate ;

    public Mitarbeiter(String FirstName, String LastName, String Level, LocalDate Date) {
        setFirstName(FirstName);
        setLastName(LastName);
        setLevel(Level);
        setDate(Date);
    }
    public void InsertionDB() throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            System.out.println("Connecting database...");
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
            con = DriverManager.getConnection(url,"egeuzma","egeuzma");
            System.out.println("Database connected!");
            
            String sql= "INSERT INTO Mitarbeiter(FirstName,LastName,Level,CertificateDate)"+"VALUES(?,?,?,?)";
           // prepare the query 
            stmt = con.prepareStatement(sql);
            // convert certificatedate into a sql date 
            Date db = Date.valueOf(CertificateDate);
            // bind parameters
            stmt.setString(1,FirstName);
            stmt.setString(2,LastName);
            stmt.setString(3,Level);
            stmt.setDate(4,db);
            stmt.executeUpdate();
              
            
            }catch (ClassNotFoundException e) {
            System.out.println("Database connection error:" + e);
            } catch (SQLException e) {
            System.out.println("Database connection error:" + e);
            }finally
        {
            if (stmt != null)
                stmt.close();
            
            if (con!= null)
                con.close();
        }
    }
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public LocalDate getDate() {
        return CertificateDate;
    }

    public void setDate(LocalDate Date) {
        this.CertificateDate = Date;
    }
    
    
}
