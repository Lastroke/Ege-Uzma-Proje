/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author egeuzma
 */
public class LoginController implements Initializable {
     
    @FXML private TextField NameTextField;
    @FXML private PasswordField PWTextField;
    @FXML private Label errmsglabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void giris(ActionEvent event) throws IOException{
      
        Connection con =null;
        PreparedStatement stmt=null;
        ResultSet rs = null ;
        
        if(NameTextField.getText().equals("")||PWTextField.getText().equals("")){
            errmsglabel.setText("Kullanıcı ID veya Şifre boş bırakılamaz.");
        }else{
        try{
          int mitarbeiternummer = Integer.parseInt(NameTextField.getText());
          con=DatabaseConnection.getConnection();
          String sql = "SELECT PASSWORD ,salt , admin FROM Mitarbeiter WHERE MitarbeiterId = ?";
          stmt = con.prepareStatement(sql);
          stmt.setInt(1, mitarbeiternummer);
          rs = stmt.executeQuery();
          String dbPassword = null ;
          byte[] salt = null;
          boolean admin = false ;
          while(rs.next()){
              dbPassword = rs.getString("PASSWORD");
              
              Blob blob = rs.getBlob("salt");
              //blob dönüştürme
              int bloblength = (int) blob.length();
              salt = blob.getBytes(1, bloblength);
              
             admin = rs.getBoolean("admin");
          }
          String userPW = Password.getSHA512password(PWTextField.getText(), salt);
          
          if(userPW.equals(dbPassword) && admin){
              Parent giris = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
              Scene gobacktothescene = new Scene(giris);
              // this line gets stage informaiton
              Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
              window.setScene(gobacktothescene);
              window.show();
          }else if(userPW.equals(dbPassword)){
              Parent giris = FXMLLoader.load(getClass().getResource("RaporOlustur2.fxml"));
              Scene gobacktothescene = new Scene(giris);
              // this line gets stage informaiton
              Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
              window.setScene(gobacktothescene);
              window.show();
          }
          else {
              errmsglabel.setText("Kullanıcı ID veya Şifre yanlış.");
          }
        
        }catch (SQLException e){
            System.err.println(e.getMessage());
            
        }catch(NullPointerException e){
            errmsglabel.setText("Böyle bir Kullanıcı ID mevcut değildir.");
        }
       }
   }
}
