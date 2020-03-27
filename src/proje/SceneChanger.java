/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author egeuzma
 */
public class SceneChanger {
    public void  ChangeScenesMitarbeiter(ActionEvent event,String viewname,String title,Mitarbeiter mitarbeiter,ControllerClass controllerclass) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewname));
        Parent parent=loader.load();
       
        Scene scene = new Scene(parent);
        // acces the controller and preload the volunteer data
        controllerclass=loader.getController();
        controllerclass.preloaddata(mitarbeiter);
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    
    public void  ChangeScenesEkipman(ActionEvent event,String viewname,String title,Ekipman ekipman,ControllerClass controllerclass) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewname));
        Parent parent=loader.load();
       
        Scene scene = new Scene(parent);
        // acces the controller and preload the volunteer data
        controllerclass=loader.getController();
        controllerclass.preloaddataEkipman(ekipman);
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
