/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author egeuzma
 */
public class Firma {
    private int FirmaId;
    private String FirmaAdı ;
    private String Il;
    private String Ilce;
    private String IsEmriNo;
    private String TeklifNo ;

    public Firma(String FirmaAdı, String Il, String Ilce, String IsEmriNo, String TeklifNo) {
        setFirmaAdı(FirmaAdı);
        setIl(Il);
        setIlce(Ilce);
        setIsEmriNo(IsEmriNo);
        setTeklifNo(TeklifNo);
    }
    
   public void FirmaInsertionDB() throws SQLException{
       Connection con = null ;
       PreparedStatement stmt = null ;
       try{
         //  Class.forName("org.hsqldb.jdbcDriver");
          // String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
         //  con = DriverManager.getConnection(url,"egeuzma","egeuzma");
          con = DatabaseConnection.getConnection();
           String sql= "INSERT INTO Firma(FirmaAdı,Il,Ilce,IsEmriNo,TeklifNo)"+"VALUES(?,?,?,?,?)";
           
          stmt = con.prepareStatement(sql);
          
          stmt.setString(1, FirmaAdı);
          stmt.setString(2, Il);
          stmt.setString(3, Ilce);
          stmt.setString(4, IsEmriNo);
          stmt.setString(5, TeklifNo);
          stmt.executeUpdate();
       }
       catch(SQLException e){
           System.err.println(e.getMessage());
       }finally{
           if(con!=null){
               con.close();
           }
           if(stmt!=null){
               stmt.close();
           }
       }
   }
    public void UpdateFirmaDB() throws SQLException{
        Connection con = null ;
        PreparedStatement stmt = null ;
        try{
           Class.forName("org.hsqldb.jdbcDriver");
           String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
           con = DriverManager.getConnection(url,"egeuzma","egeuzma");
           
          String sql ="UPDATE Firma Set FirmaAdı=? ,Il=?,Ilce=?,IsEmriNo=?,TeklifNo=?"+"WHERE FirmaId=?";
          
          stmt=con.prepareStatement(sql);
          stmt.setString(1,FirmaAdı);
            stmt.setString(2,Il);
            stmt.setString(3,Ilce);
            stmt.setString(4,IsEmriNo);
            stmt.setString(5,TeklifNo);
            stmt.setInt(6,FirmaId);
            stmt.executeUpdate();
            stmt.close();
            
        }catch (ClassNotFoundException e){
            System.err.println(e.getMessage());
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally{
            if(con!=null)
                con.close();
            if(stmt!=null)
                stmt.close();
        }
        
    }
    public String getFirmaAdı() {
        return FirmaAdı;
    }

    public void setFirmaAdı(String FirmaAdı) {
        this.FirmaAdı = FirmaAdı;
    }

    public String getIl() {
        return Il;
    }

    public void setIl(String Il) {
        this.Il = Il;
    }

    public String getIlce() {
        return Ilce;
    }

    public void setIlce(String Ilce) {
        this.Ilce = Ilce;
    }

    public String getIsEmriNo() {
        return IsEmriNo;
    }

    public void setIsEmriNo(String IsEmriNo) {
        this.IsEmriNo = IsEmriNo;
    }

    public String getTeklifNo() {
        return TeklifNo;
    }

    public void setTeklifNo(String TeklifNo) {
        this.TeklifNo = TeklifNo;
    }

    public int getFirmaId() {
        return FirmaId;
    }

    public void setFirmaId(int FirmaId) {
        this.FirmaId = FirmaId;
    }
    
    
}
