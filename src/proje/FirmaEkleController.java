/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
public class FirmaEkleController implements Initializable,ControllerClass{
    @FXML private Label headerLabel;
    @FXML private TextField FirmaAdıTextField;
    @FXML private TextField IlTextField;
    @FXML private TextField IlceTextField;
    @FXML private TextField IsEmriNoTextField;
    @FXML private TextField TeklifNoTextField;
    @FXML private Label errLabel;
    private Firma firma;
    
    public void geriback(ActionEvent event) throws IOException{
       Parent geriback = FXMLLoader.load(getClass().getResource("FirmaTableView.fxml"));
       Scene gobacktothescene = new Scene(geriback);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(gobacktothescene);
       window.show();
   }
    public void ekleButonuTıkla(ActionEvent event) throws SQLException{
        try{
            if(firma!=null){
                updateFirma();
                firma.UpdateFirmaDB();
            }else{
                firma = new Firma(FirmaAdıTextField.getText(),IlTextField.getText(),IlceTextField.getText(),
                                  IsEmriNoTextField.getText(),TeklifNoTextField.getText());
                firma.FirmaInsertionDB();
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
     public void SilButonuPushed(ActionEvent event){
         try{
             firma.FirmaDeleteDB();
         } catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void preloaddata(Mitarbeiter mitarbeiter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preloaddataEkipman(Ekipman ekipman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preloaddataFirma(Firma firma) {
        this.firma=firma;
        this.FirmaAdıTextField.setText(firma.getFirmaAdı());
        this.IlTextField.setText(firma.getIl());
        this.IlceTextField.setText(firma.getIlce());
        this.IsEmriNoTextField.setText(firma.getIsEmriNo());
        this.TeklifNoTextField.setText(firma.getTeklifNo());
        this.headerLabel.setText("Firma Düzenle");
    }
    public void updateFirma(){
      firma.setFirmaAdı(FirmaAdıTextField.getText());
      firma.setIl(IlTextField.getText());
      firma.setIlce(IlceTextField.getText());
      firma.setIsEmriNo(IsEmriNoTextField.getText());
      firma.setTeklifNo(TeklifNoTextField.getText());
           
    }

    @Override
    public void preloadmitarbeiter(Mitarbeiter mitarbeiter, Mitarbeiter mitarbeiter2, Mitarbeiter mitarbeiter3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
