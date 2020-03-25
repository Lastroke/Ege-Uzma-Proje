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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author egeuzma
 */
public class EkipmanEkleController implements Initializable {

     @FXML private TextField EkipmanAdıTextField;
     @FXML private TextField KutupMesafesiTextField;
     @FXML private TextField CihazTextField;
     @FXML private TextField MPTasıyıcıOrtamTextField;
     @FXML private TextField MıknatıslamaTekTextField;
     @FXML private TextField UVIsıkSiddetiTextField;
     @FXML private TextField IsıkMesafesiTextField;
     @FXML private Label errormesage;
     
      public void ekleButtonPushed(ActionEvent event){
        
        try
        {
           Ekipman ekipman = new Ekipman(EkipmanAdıTextField.getText(),KutupMesafesiTextField.getText(),
                                          CihazTextField.getText(),MPTasıyıcıOrtamTextField.getText(),
          MıknatıslamaTekTextField.getText(),UVIsıkSiddetiTextField.getText(),IsıkMesafesiTextField.getText() ); 
           ekipman.EkipmanInsertionDB();
        }
        catch(Exception e)
        {
            errormesage.setText(e.getMessage());
        }
    }
     public void GeriButonuPushed(ActionEvent event) throws IOException{
       Parent geri = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Scene scene = new Scene(geri);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
