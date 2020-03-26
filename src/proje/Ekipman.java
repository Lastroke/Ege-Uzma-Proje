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
import java.sql.SQLException;


public class Ekipman {
    private int EkipmanId ;
    private String EkipmanName ;
    private String KutupMesafesi;
    private String Cihaz ;
    private String MPTasıyıcıOrtam;
    private String MıknatıslamaTek;
    private String UVIsıkSiddeti;
    private String IsıkMesafesi;

    public Ekipman(String EkipmanName, String KutupMesafesi, String Cihaz, String MPTasıyıcıOrtam, String MıknatıslamaTek, String UVIsıkSiddeti, String IsıkMesafesi) {
        setEkipmanName(EkipmanName);
        setKutupMesafesi(KutupMesafesi);
        setCihaz(Cihaz);
        setMPTasıyıcıOrtam(MPTasıyıcıOrtam);
        setMıknatıslamaTek(MıknatıslamaTek);
        setUVIsıkSiddeti(UVIsıkSiddeti);
        setIsıkMesafesi(IsıkMesafesi);
    }
     public void EkipmanInsertionDB() throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            System.out.println("Connecting database...");
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
            con = DriverManager.getConnection(url,"egeuzma","egeuzma");
            System.out.println("Database connected!");
            
            String sql= "INSERT INTO Ekipman(EkipmanAdı,KutupMesafesi,Cihaz,MPTasıyıcıOrtam,MıknatıslamaTek,UVIsıkSiddeti,IsıkMesafesi)"
                                                +"VALUES(?,?,?,?,?,?,?)";
           // prepare the query 
            stmt = con.prepareStatement(sql);
            // convert certificatedate into a sql date 
            
            // bind parameters
            stmt.setString(1,EkipmanName);
            stmt.setString(2,KutupMesafesi);
            stmt.setString(3,Cihaz);
            stmt.setString(4,MPTasıyıcıOrtam);
            stmt.setString(5,MıknatıslamaTek);
            stmt.setString(6,UVIsıkSiddeti);
            stmt.setString(7,IsıkMesafesi);
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
    public String getEkipmanName() {
        return EkipmanName;
    }

    public void setEkipmanName(String EkipmanName) {
        this.EkipmanName = EkipmanName;
    }

    public String getKutupMesafesi() {
        return KutupMesafesi;
    }

    public void setKutupMesafesi(String KutupMesafesi) {
        this.KutupMesafesi = KutupMesafesi;
    }

    public String getCihaz() {
        return Cihaz;
    }

    public void setCihaz(String Cihaz) {
        this.Cihaz = Cihaz;
    }

    public String getMPTasıyıcıOrtam() {
        return MPTasıyıcıOrtam;
    }

    public void setMPTasıyıcıOrtam(String MPTasıyıcıOrtam) {
        this.MPTasıyıcıOrtam = MPTasıyıcıOrtam;
    }

    public String getMıknatıslamaTek() {
        return MıknatıslamaTek;
    }

    public void setMıknatıslamaTek(String MıknatıslamaTek) {
        this.MıknatıslamaTek = MıknatıslamaTek;
    }

    public String getUVIsıkSiddeti() {
        return UVIsıkSiddeti;
    }

    public void setUVIsıkSiddeti(String UVIsıkSiddeti) {
        this.UVIsıkSiddeti = UVIsıkSiddeti;
    }

    public String getIsıkMesafesi() {
        return IsıkMesafesi;
    }

    public void setIsıkMesafesi(String IsıkMesafesi) {
        this.IsıkMesafesi = IsıkMesafesi;
    }

    public int getEkipmanId() {
        return EkipmanId;
    }

    public void setEkipmanId(int EkipmanId) {
        this.EkipmanId = EkipmanId;
    }

    
    
    
    
}
