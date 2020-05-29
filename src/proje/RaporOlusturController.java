/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author egeuzma
 */
public class RaporOlusturController implements Initializable {

   @FXML private TableView<Ekipman> EkipmanTable;
   @FXML private TableColumn<Ekipman,Integer> IdColumn;
   @FXML private TableColumn<Ekipman,String> AdColumn;
   @FXML private TableColumn<Ekipman,String> KutupMesafesiColumn;
   @FXML private TableColumn<Ekipman,String> CihazColumn;
   @FXML private TableColumn<Ekipman,String> MPTasıyıcıOrtamColumn;
   @FXML private TableColumn<Ekipman,String> MıknatıslamaTekColumn;
   @FXML private TableColumn<Ekipman,String> UVIsıkSiddetiColumn;
   @FXML private TableColumn<Ekipman,String> IsıkMesafesiColumn;
   @FXML private TableView<Mitarbeiter> CalisanTable;
   @FXML private TableColumn<Mitarbeiter,Integer> MitIdColumn;
   @FXML private TableColumn<Mitarbeiter,String> MitAdColumn;
   @FXML private TableColumn<Mitarbeiter,String> SoyadColumn;
   @FXML private TableColumn<Mitarbeiter,String> SeviyeColumn;
   @FXML private TableColumn<Mitarbeiter,LocalDate> SertifikaTarihiColumn;
   @FXML private TableView<Mitarbeiter> CalisanTable1;
   @FXML private TableColumn<Mitarbeiter,Integer> MitIdColumn1;
   @FXML private TableColumn<Mitarbeiter,String> MitAdColumn1;
   @FXML private TableColumn<Mitarbeiter,String> SoyadColumn1;
   @FXML private TableColumn<Mitarbeiter,String> SeviyeColumn1;
   @FXML private TableColumn<Mitarbeiter,LocalDate> SertifikaTarihiColumn1;
   @FXML private TableView<Mitarbeiter> CalisanTable2;
   @FXML private TableColumn<Mitarbeiter,Integer> MitIdColumn2;
   @FXML private TableColumn<Mitarbeiter,String> MitAdColumn2;
   @FXML private TableColumn<Mitarbeiter,String> SoyadColumn2;
   @FXML private TableColumn<Mitarbeiter,String> SeviyeColumn2;
   @FXML private TableColumn<Mitarbeiter,LocalDate> SertifikaTarihiColumn2;
   @FXML private TableView<Firma> FirmaTable;
   @FXML private TableColumn<Firma,Integer> FirIdColumn;
   @FXML private TableColumn<Firma,String> FirmaAdColumn;
   @FXML private TableColumn<Firma,String> IlColumn;
   @FXML private TableColumn<Firma,String> IlceColumn;
   @FXML private TableColumn<Firma,String> IsEmriNoColumn;
   @FXML private TableColumn<Firma,String> TeklifNoColumn;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IdColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,Integer>("EkipmanId"));
        AdColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("EkipmanName"));
        KutupMesafesiColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("KutupMesafesi"));
        CihazColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("Cihaz"));
        MPTasıyıcıOrtamColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("MPTasıyıcıOrtam"));
        MıknatıslamaTekColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("MıknatıslamaTek"));
        UVIsıkSiddetiColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("UVIsıkSiddeti"));
        IsıkMesafesiColumn.setCellValueFactory(new PropertyValueFactory<Ekipman,String>("IsıkMesafesi"));
        
        MitIdColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,Integer>("MitarbeiterId"));
        MitAdColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("FirstName"));
        SoyadColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("LastName"));
        SeviyeColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("Level"));
        SertifikaTarihiColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,LocalDate>("CertificateDate"));
        MitIdColumn1.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,Integer>("MitarbeiterId"));
        MitAdColumn1.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("FirstName"));
        SoyadColumn1.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("LastName"));
        SeviyeColumn1.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("Level"));
        SertifikaTarihiColumn1.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,LocalDate>("CertificateDate"));
        MitIdColumn2.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,Integer>("MitarbeiterId"));
        MitAdColumn2.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("FirstName"));
        SoyadColumn2.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("LastName"));
        SeviyeColumn2.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("Level"));
        SertifikaTarihiColumn2.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,LocalDate>("CertificateDate"));
        
        FirIdColumn.setCellValueFactory(new PropertyValueFactory<Firma,Integer>("FirmaId"));
        FirmaAdColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("FirmaAdı"));
        IlColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("Il"));
        IlceColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("Ilce"));
        IsEmriNoColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("IsEmriNo"));
        TeklifNoColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("TeklifNo"));
        try{
            loadEkipman1();
            loadMitarbeiter();
            loadFirma();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        } 
        
    }  
    public void loadFirma() throws SQLException{
       ObservableList<Firma> firmalar =FXCollections.observableArrayList();
        Connection con = null ;
        Statement stmt = null ;
        ResultSet rs = null ;
        try{
            //Class.forName("org.hsqldb.jdbcDriver");
          //  String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
           // con = DriverManager.getConnection(url,"egeuzma","egeuzma");
            con=DatabaseConnection.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM Firma");
            while(rs.next()){
                Firma newfirma = new Firma(rs.getString("FirmaAdı"),rs.getString("Il"),
                                           rs.getString("Ilce"),rs.getString("IsEmriNo"),
                                           rs.getString("TeklifNo"));
                newfirma.setFirmaId(rs.getInt("FirmaId"));
                firmalar.add(newfirma);
            }
             FirmaTable.getItems().addAll(firmalar);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            if(con!=null)
                con.close();
            if(stmt!=null)
                stmt.close();
            if(rs!=null)
                rs.close();
        }
    }
    public void loadEkipman1() throws SQLException{
        ObservableList<Ekipman> ekipmanlar = FXCollections.observableArrayList();
        Connection con = null ;
        Statement stmt = null ;
        ResultSet rs = null ;
        try
        {
            //Class.forName("org.hsqldb.jdbcDriver");
            //String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
            //con=DriverManager.getConnection(url, "egeuzma","egeuzma");
            con=DatabaseConnection.getConnection();
            stmt = con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM Ekipman");
            while(rs.next()){
                Ekipman newekipman = new Ekipman(rs.getString("EkipmanAdı"),rs.getString("KutupMesafesi"),
                                                 rs.getString("Cihaz"),rs.getString("MPTasıyıcıOrtam"),
                                                 rs.getString("MıknatıslamaTek"),rs.getString("UVIsıkSiddeti"),
                                                 rs.getString("IsıkMesafesi"));
                newekipman.setEkipmanId(rs.getInt("EkipmanId"));
                ekipmanlar.add(newekipman);
            }
            EkipmanTable.getItems().addAll(ekipmanlar);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            if(con!=null)
                 con.close();
            if(stmt!=null)
                stmt.close();
            if(rs!=null)
                rs.close();
        }
    }
    public void loadMitarbeiter() throws SQLException{
        ObservableList<Mitarbeiter> mitarbeiter = FXCollections.observableArrayList();
        Connection con = null ; 
        Statement stmt = null ;
        ResultSet rs = null ;
        try{
            //Class.forName("org.hsqldb.jdbcDriver");
            //String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
            //con = DriverManager.getConnection(url,"egeuzma","egeuzma");
            con=DatabaseConnection.getConnection();
            stmt = con.createStatement();
            
            // Create Sql Query
            rs=stmt.executeQuery("SELECT * FROM Mitarbeiter");
            
            // Create mitarbeiter object from each records
            while(rs.next()){
                Mitarbeiter newmitarbeiter = new Mitarbeiter(rs.getString("FirstName"),
                                                             rs.getString("LastName"),
                                                             rs.getString("Level"),
                                                             rs.getDate("CertificateDate").toLocalDate(),
                                                             rs.getString("Password"),rs.getBoolean("admin"));
                newmitarbeiter.setMitarbeiterId(rs.getInt("MitarbeiterId"));
                mitarbeiter.add(newmitarbeiter);
            }
            CalisanTable.getItems().addAll(mitarbeiter);
            CalisanTable1.getItems().addAll(mitarbeiter);
            CalisanTable2.getItems().addAll(mitarbeiter);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            if(con != null)
                con.close();
            if( stmt != null)
                stmt.close();
            if(rs != null) 
                rs.close();
        }
    }
    
   
    
   
    public void magneticreport(ActionEvent event) throws IOException{
      /*Parent magnetic = FXMLLoader.load(getClass().getResource("ManyetikRapor.fxml"));
       Scene scene = new Scene(magnetic);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
        */
    
    SceneChanger sc = new SceneChanger();
    Ekipman ekipman = this.EkipmanTable.getSelectionModel().getSelectedItem();
    Mitarbeiter calisan=this.CalisanTable.getSelectionModel().getSelectedItem();
    Mitarbeiter calisan2=this.CalisanTable1.getSelectionModel().getSelectedItem();
    Mitarbeiter calisan3=this.CalisanTable2.getSelectionModel().getSelectedItem();
    Firma firma =this.FirmaTable.getSelectionModel().getSelectedItem();
    ManyetikRaporController eec = new ManyetikRaporController();
    sc.ChangeScenesMan(event, "ManyetikRapor.fxml", "Rapor Düzenle",calisan,calisan2,calisan3,ekipman,firma, eec);

   }
    
     public void radio(ActionEvent event) throws IOException{
       Parent radio = FXMLLoader.load(getClass().getResource("RadyografikRaporu.fxml"));
       Scene scene = new Scene(radio);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
     public void GoBack(ActionEvent event) throws IOException{
       Parent Goback = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(Goback);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
}
