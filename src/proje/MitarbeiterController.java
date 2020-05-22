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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    @FXML private PasswordField passwordfield;
    @FXML private PasswordField confirmpasswordfield;
    @FXML private CheckBox   admincheck;
    private Mitarbeiter mitarbeiter;  
    public void ekleButtonPushed(ActionEvent event){
      
        if(vaildPassword()){
            try
            {
                if(mitarbeiter != null){
                    updateMitarbeiter();
                    mitarbeiter.UpdateMitarbeiterDB();
                }else{
                    mitarbeiter = new Mitarbeiter(AdıTextField.getText(),SoyadıTextField.getText(),
                                                  SeviyeTextField.getText(),SertifikaDatePicker.getValue(),
                                                  passwordfield.getText(),admincheck.isSelected()); 
                    mitarbeiter.InsertionDB();
                }
            }
            catch(Exception e)
            {
                errormesage.setText(e.getMessage());
            }
      }
       
    }
    public void SilButonuPushed(ActionEvent event){
         try{
             mitarbeiter.MitarbeiterDeleteDB();
         } catch(Exception e)
        {
            errormesage.setText(e.getMessage());
        }
     }
    public boolean vaildPassword(){
       if(passwordfield.getText().length()<5){
           errormesage.setText("Şifre uzunluğu 5 den büyük olmalı");
           return false;
       }
        if(passwordfield.getText().equals(confirmpasswordfield.getText())){
            return true;
        }else{
            return false;
        }
    }
    public void goback(ActionEvent event) throws IOException{
       Parent goback = FXMLLoader.load(getClass().getResource("MitarbeiterTableView.fxml"));
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
        this.headerLabel.setText("Çalışan Ekle");
    }

    @Override
    public void preloaddataFirma(Firma firma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preloaddataEkipman(Ekipman ekipman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //read from gui and update mitarbeiter
    public void updateMitarbeiter(){
        mitarbeiter.setFirstName(AdıTextField.getText());
        mitarbeiter.setLastName(SoyadıTextField.getText());
        mitarbeiter.setLevel(SeviyeTextField.getText());
        mitarbeiter.setCertificateDate(SertifikaDatePicker.getValue());
    }
    
}
