/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Ege Uzma 170503013
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
public class EkipmanEkleController implements Initializable,ControllerClass {
     @FXML private Label headerlabel;
     @FXML private TextField EkipmanAdıTextField;
     @FXML private TextField KutupMesafesiTextField;
     @FXML private TextField CihazTextField;
     @FXML private TextField MPTasıyıcıOrtamTextField;
     @FXML private TextField MıknatıslamaTekTextField;
     @FXML private TextField UVIsıkSiddetiTextField;
     @FXML private TextField IsıkMesafesiTextField;
     @FXML private Label errormesage;
     private Ekipman ekipman;
      public void ekleButtonPushed(ActionEvent event){
        
        try
        {
            if(ekipman!=null){
              updateEkipman();
              ekipman.EkipmanUpdateDB();
            }else{
                ekipman = new Ekipman(EkipmanAdıTextField.getText(),KutupMesafesiTextField.getText(),
                                          CihazTextField.getText(),MPTasıyıcıOrtamTextField.getText(),
          MıknatıslamaTekTextField.getText(),UVIsıkSiddetiTextField.getText(),IsıkMesafesiTextField.getText() ); 
           ekipman.EkipmanInsertionDB();
            }
           
        }
        catch(Exception e)
        {
            errormesage.setText(e.getMessage());
        }
    }
     public void SilButonuPushed(ActionEvent event){
         try{
             ekipman.EkipmanDeleteDB();
         } catch(Exception e)
        {
            errormesage.setText(e.getMessage());
        }
     }
     public void GeriButonuPushed(ActionEvent event) throws IOException{
       Parent geri = FXMLLoader.load(getClass().getResource("EkipmanTableView.fxml"));
       Scene scene = new Scene(geri);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @Override
    public void preloaddata(Mitarbeiter mitarbeiter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preloaddataFirma(Firma firma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preloaddataEkipman(Ekipman ekipman) {
        this.ekipman=ekipman;
        this.EkipmanAdıTextField.setText(ekipman.getEkipmanName());
        this.KutupMesafesiTextField.setText(ekipman.getKutupMesafesi());
        this.CihazTextField.setText(ekipman.getCihaz());
        this.MPTasıyıcıOrtamTextField.setText(ekipman.getMPTasıyıcıOrtam());
        this.MıknatıslamaTekTextField.setText(ekipman.getMıknatıslamaTek());
        this.UVIsıkSiddetiTextField.setText(ekipman.getUVIsıkSiddeti());
        this.IsıkMesafesiTextField.setText(ekipman.getIsıkMesafesi());
        this.headerlabel.setText("Ekipman Düzenle/Sil");
    }
    public void updateEkipman(){
        ekipman.setEkipmanName(EkipmanAdıTextField.getText());
        ekipman.setKutupMesafesi(KutupMesafesiTextField.getText());
        ekipman.setCihaz(CihazTextField.getText());
        ekipman.setMPTasıyıcıOrtam(MPTasıyıcıOrtamTextField.getText());
        ekipman.setMıknatıslamaTek(MıknatıslamaTekTextField.getText());
        ekipman.setUVIsıkSiddeti(UVIsıkSiddetiTextField.getText());
        ekipman.setIsıkMesafesi(IsıkMesafesiTextField.getText());
           
    }

    @Override
    public void preloadmitarbeiter(Mitarbeiter mitarbeiter, Mitarbeiter mitarbeiter2, Mitarbeiter mitarbeiter3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
