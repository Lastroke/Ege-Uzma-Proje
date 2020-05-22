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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author egeuzma
 */
public class MitarbeiterTableViewController implements Initializable {
   
   @FXML private TableView<Mitarbeiter> CalisanTable;
   @FXML private TableColumn<Mitarbeiter,Integer> IdColumn;
   @FXML private TableColumn<Mitarbeiter,String> AdColumn;
   @FXML private TableColumn<Mitarbeiter,String> SoyadColumn;
   @FXML private TableColumn<Mitarbeiter,String> SeviyeColumn;
   @FXML private TableColumn<Mitarbeiter,LocalDate> SertifikaTarihiColumn;
   @FXML private Button editButton; 
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        //diasble the edit button until one of the mitarbeiter selected
        editButton.setDisable(true);       
        // configure the table columns
        IdColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,Integer>("MitarbeiterId"));
        AdColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("FirstName"));
        SoyadColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("LastName"));
        SeviyeColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,String>("Level"));
        SertifikaTarihiColumn.setCellValueFactory(new PropertyValueFactory<Mitarbeiter,LocalDate>("CertificateDate"));
        
        try{
            loadMitarbeiter();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }    
   
     public void calisansayfa(ActionEvent event) throws IOException{
       Parent calisansayfa = FXMLLoader.load(getClass().getResource("Mitarbeiter.fxml"));
       Scene calisanscene = new Scene(calisansayfa);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(calisanscene);
       window.show();
   }
//if edit button pushed, pass the selected mitrbeiter to the calısanekle and preload it with data
public void editButtonPushed(ActionEvent event) throws IOException{
    SceneChanger sc = new SceneChanger();
    Mitarbeiter mitarbeiter = this.CalisanTable.getSelectionModel().getSelectedItem();
    MitarbeiterController mc = new MitarbeiterController();
    sc.ChangeScenesMitarbeiter(event, "Mitarbeiter.fxml", "Çalışan Düzenle", mitarbeiter, mc);
}




//if user select something in table enable the edit button 
    public void mitarbeiterselected(){
        editButton.setDisable(false);
    }
public void GoBack(ActionEvent event) throws IOException{
       Parent Goback = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(Goback);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
// this method load mitarbeiter from databse and load into tableview
    public void loadMitarbeiter() throws SQLException{
        ObservableList<Mitarbeiter> mitarbeiter = FXCollections.observableArrayList();
        Connection con = null ; 
        Statement stmt = null ;
        ResultSet rs = null ;
        try{
           Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\egeuzma\\Desktop\\mydb\\;shutdown=true";
            con = DriverManager.getConnection(url,"egeuzma","egeuzma");
            
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
}
