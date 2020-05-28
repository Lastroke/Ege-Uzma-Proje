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
   public Ekipman asd ;
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
        
       
        
        
        try{
            loadEkipman1();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        } 
        
    }    
    public void loadEkipman1() throws SQLException{
        ObservableList<Ekipman> ekipmanlar = FXCollections.observableArrayList();
        Connection con = null ;
        Statement stmt = null ;
        ResultSet rs = null ;
        try
        {
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
            con=DriverManager.getConnection(url, "egeuzma","egeuzma");
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
    ManyetikRaporController eec = new ManyetikRaporController();
    sc.ChangeScenesEkipman(event, "ManyetikRapor.fxml", "Rapor Düzenle", ekipman, eec);

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
