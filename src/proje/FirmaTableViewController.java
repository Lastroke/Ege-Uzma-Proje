/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author egeuzma
 */
public class FirmaTableViewController implements Initializable {
   @FXML private TableView<Firma> FirmaTable;
   @FXML private TableColumn<Firma,Integer> IdColumn;
   @FXML private TableColumn<Firma,String> FirmaAdColumn;
   @FXML private TableColumn<Firma,String> IlColumn;
   @FXML private TableColumn<Firma,String> IlceColumn;
   @FXML private TableColumn<Firma,String> IsEmriNoColumn;
   @FXML private TableColumn<Firma,String> TeklifNoColumn;
   @FXML private Button editButton; 
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       editButton.setDisable(true);
       
       IdColumn.setCellValueFactory(new PropertyValueFactory<Firma,Integer>("FirmaId"));
       FirmaAdColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("FirmaAdı"));
       IlColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("Il"));
       IlceColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("Ilce"));
       IsEmriNoColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("IsEmriNo"));
       TeklifNoColumn.setCellValueFactory(new PropertyValueFactory<Firma,String>("TeklifNo"));
    
       try{
            loadFirma();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
       
    }    
     public void FirmaEkle(ActionEvent event) throws IOException{
       Parent firmaekle = FXMLLoader.load(getClass().getResource("FirmaEkle.fxml"));
       Scene scene = new Scene(firmaekle);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
    public void EditButtonPushed(ActionEvent event) throws IOException{
    SceneChanger sc = new SceneChanger();
    Firma firma = this.FirmaTable.getSelectionModel().getSelectedItem();
    FirmaEkleController fec = new FirmaEkleController();
    sc.ChangeScenesFirma(event, "FirmaEkle.fxml", "Firma Düzenle", firma, fec);
    }
    public void firmaselected(){
        editButton.setDisable(false);
    }
    public void Back(ActionEvent event) throws IOException{
       Parent back = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(back);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
    public void loadFirma() throws SQLException{
       ObservableList<Firma> firmalar =FXCollections.observableArrayList();
        Connection con = null ;
        Statement stmt = null ;
        ResultSet rs = null ;
        try{
          //  Class.forName("org.hsqldb.jdbcDriver");
           // String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
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
}
