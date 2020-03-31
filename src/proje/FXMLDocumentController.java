/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author egeuzma
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label label;
    @FXML private ChoiceBox choicebox;
    
     public void EkipmanTableView(ActionEvent event) throws IOException{
       Parent EkipmanTableView = FXMLLoader.load(getClass().getResource("EkipmanTableView.fxml"));
       Scene scene = new Scene(EkipmanTableView);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
     public void CalisanTableView(ActionEvent event) throws IOException{
       Parent CalisanTableView = FXMLLoader.load(getClass().getResource("MitarbeiterTableView.fxml"));
       Scene scene = new Scene(CalisanTableView);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
     public void FirmaTableView(ActionEvent event) throws IOException{
       Parent FirmaTableView = FXMLLoader.load(getClass().getResource("FirmaTableView.fxml"));
       Scene scene = new Scene(FirmaTableView);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
    public void EkipmanEkle(ActionEvent event) throws IOException{
       Parent ekipmanekle = FXMLLoader.load(getClass().getResource("EkipmanEkle.fxml"));
       Scene scene = new Scene(ekipmanekle);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
    public void FirmaEkle(ActionEvent event) throws IOException{
       Parent firmaekle = FXMLLoader.load(getClass().getResource("FirmaEkle.fxml"));
       Scene scene = new Scene(firmaekle);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
    public void calisansayfa(ActionEvent event) throws IOException{
       Parent calisansayfa = FXMLLoader.load(getClass().getResource("Mitarbeiter.fxml"));
       Scene calisanscene = new Scene(calisansayfa);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(calisanscene);
       window.show();
   }
    public void magneticreport(ActionEvent event) throws IOException{
       Parent magnetic = FXMLLoader.load(getClass().getResource("ManyetikRapor.fxml"));
       Scene scene = new Scene(magnetic);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
    public void radio(ActionEvent event) throws IOException{
       Parent radio = FXMLLoader.load(getClass().getResource("RadyografikRaporu.fxml"));
       Scene scene = new Scene(radio);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
