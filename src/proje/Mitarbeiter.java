/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.security.NoSuchAlgorithmException;
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
    private int MitarbeiterId;
    private String password ;
    private byte[] salt;
    private boolean admin ;
    public Mitarbeiter(String FirstName, String LastName, String Level, LocalDate Date,String password , boolean admin) throws NoSuchAlgorithmException {
        setFirstName(FirstName);
        setLastName(LastName);
        setLevel(Level);
        setCertificateDate(Date);
        salt = Password.getSalt();
        this.password = Password.getSHA512password(password, salt);
        this.admin = admin ;
    }
    public void UpdateMitarbeiterDB() throws SQLException{
        
        Connection con =null;
        PreparedStatement stmt=null;
        try{
            con=DatabaseConnection.getConnection();
            String sql="UPDATE Mitarbeiter SET FirstName=? ,LastName=?,Level=?,CertificateDate=?"+"WHERE MitarbeiterId=?";
                     
            
            stmt =con.prepareStatement(sql);
            Date db = Date.valueOf(CertificateDate);
            stmt.setString(1,FirstName);
            stmt.setString(2,LastName);
            stmt.setString(3,Level);
            stmt.setDate(4,db);
            stmt.setInt(5,MitarbeiterId);
            stmt.executeUpdate();
            stmt.close();
            
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }finally{
            if (stmt != null)
                stmt.close();
            
            if (con!= null)
                con.close();
        }
    }
   public void MitarbeiterDeleteDB()throws SQLException{
        Connection con = null ;
       PreparedStatement stmt = null ;
       try{
           con = DatabaseConnection.getConnection();
           String sql ="DELETE FROM Mitarbeiter WHERE MitarbeiterId=?";
           stmt=con.prepareStatement(sql);
           stmt.setInt(1,MitarbeiterId);
           stmt.executeUpdate();
           stmt.close();
           
       }catch(SQLException e){
           System.err.println(e.getMessage());
       }finally{
            if(con!=null)
                con.close();
            if(stmt!=null)
                stmt.close();
        }
    }
    public void InsertionDB() throws SQLException{
         Connection con = null;
        PreparedStatement stmt = null;
        try {
            con=DatabaseConnection.getConnection();
            String sql= "INSERT INTO Mitarbeiter(FirstName,LastName,Level,CertificateDate,PASSWORD,salt,admin)"+"VALUES(?,?,?,?,?,?,?)";
           // prepare the query 
            stmt = con.prepareStatement(sql);
            // convert certificatedate into a sql date 
            Date db = Date.valueOf(CertificateDate);
            // bind parameters
            stmt.setString(1,FirstName);
            stmt.setString(2,LastName);
            stmt.setString(3,Level);
            stmt.setDate(4,db);
            stmt.setString(5,password);
            stmt.setBlob(6,new javax.sql.rowset.serial.SerialBlob(salt));
            stmt.setBoolean(7, admin);
            stmt.executeUpdate();
              
            
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
        int level = Integer.parseInt(Level);
        
            this.Level = Level;
        
    }

    public LocalDate getCertificateDate() {
        return CertificateDate;
    }

    public void setCertificateDate(LocalDate CertificateDate) {
        this.CertificateDate = CertificateDate;
    }

   

    public int getMitarbeiterId() {
        return MitarbeiterId;
    }

    public void setMitarbeiterId(int MitarbeiterId) {
       if(MitarbeiterId >= 0){
            this.MitarbeiterId = MitarbeiterId;
       }else{
           throw new IllegalArgumentException("MitarbeiterId must be >=0");
       }
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
}
