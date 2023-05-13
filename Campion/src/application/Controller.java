package application;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML 
    private TextField user_id;
    @FXML
    private ImageView avatar_imagem;
    
    public void login(ActionEvent event) throws IOException {	
        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        stage.show();
    }
    
    public void cadastrar_etapa1(ActionEvent event) throws IOException {    	
        root = FXMLLoader.load(getClass().getResource("Cadastro_etapa1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        stage.show();
    }

    public void entrar(ActionEvent event) throws IOException {
    	String username = user_id.getText();
    	
    	FXMLLoader	loader = new FXMLLoader(getClass().getResource("Campion1.fxml"));
    	root = loader.load();
    	ControllerCampion1 controladorCampion1 = loader.getController();
    	controladorCampion1.mostrarNome(username);
    	
    	//root = FXMLLoader.load(getClass().getResource("Campion1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        stage.show();

        
    }
    
    public void selecionar_avatar(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Selecionar Imagem");
    	fileChooser.getExtensionFilters().addAll(
    	        new FileChooser.ExtensionFilter("Imagens", "*.jpg", "*.jpeg", "*.png", "*.gif")
    	);
    	File selectedFile = fileChooser.showOpenDialog(null);
    	if (selectedFile != null) {
    	    Image image = new Image(selectedFile.toURI().toString());
    	    avatar_imagem.setImage(image);
    	}
    }
}

class StyleUtil {
    public static void applyStyle(Scene scene) {
        String css = StyleUtil.class.getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);
    }
}
