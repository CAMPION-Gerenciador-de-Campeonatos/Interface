package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerCampion1 {

    @FXML
    Label nome_id;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void mostrarNome(String username) {
    	nome_id.setText("Olá "+username+" seja bem-vindo ao Campion");
    }
    
    public void logout(ActionEvent event) throws IOException {	
    	FXMLLoader	loader = new FXMLLoader(getClass().getResource("Main.fxml"));
    	root = loader.load();        
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        stage.show();
    }
}
