/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.IOException;
import java.net.URL;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author egeuzma
 */
public class MitarbeiterController implements Initializable,ControllerClass {
   @FXML private Label headerLabel;
    @FXML private TextField AdıTextField;
    @FXML private TextField SoyadıTextField;
    @FXML private TextField SeviyeTextField;
    @FXML private DatePicker SertifikaDatePicker;
    @FXML private Label errormesage;
    private Mitarbeiter mitarbeiter;  
    public void ekleButtonPushed(ActionEvent event){
        
        try
        {
           Mitarbeiter mitarbeiter = new Mitarbeiter(AdıTextField.getText(),SoyadıTextField.getText(),
                                                     SeviyeTextField.getText(),SertifikaDatePicker.getValue()); 
           mitarbeiter.InsertionDB();
        }
        catch(Exception e)
        {
            errormesage.setText(e.getMessage());
        }
    }
    
    public void goback(ActionEvent event) throws IOException{
       Parent goback = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene gobacktothescene = new Scene(goback);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(gobacktothescene);
       window.show();
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void preloaddata(Mitarbeiter mitarbeiter) {
        this.mitarbeiter=mitarbeiter;
        this.AdıTextField.setText(mitarbeiter.getFirstName());
        this.SoyadıTextField.setText(mitarbeiter.getLastName());
        this.SeviyeTextField.setText(mitarbeiter.getLevel());
        this.SertifikaDatePicker.setValue(mitarbeiter.getCertificateDate());
        this.headerLabel.setText("Çalışan Düzenle");
    }

    @Override
    public void preloaddataEkipman(Ekipman ekipman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
