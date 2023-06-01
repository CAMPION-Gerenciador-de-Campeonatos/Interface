package application;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuButton menuButton2;
    @FXML 
    private TextField user_id;
    @FXML
	private ImageView avatar_imagem;

    public void entrar(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("meus_campeonatos.fxml"));
    	root = loader.load();
    	
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        StageUtil.centerStage(stage);
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
    
    public void logout(ActionEvent event ) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login_cadastro.fxml"));
        Stage stage = (Stage) menuButton.getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        StageUtil.centerStage(stage);
        stage.show();    
     }
    
    public void criar_time(ActionEvent event ) throws IOException {
        root = FXMLLoader.load(getClass().getResource("criar_time.fxml"));
        Stage stage = (Stage) menuButton.getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        StageUtil.centerStage(stage);
        stage.show();    
     }
    
    public void meus_times(ActionEvent event ) throws IOException {
        root = FXMLLoader.load(getClass().getResource("meus_times.fxml"));
        Stage stage = (Stage) menuButton.getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        StageUtil.centerStage(stage);
        stage.show();    
     }
    
    public void criar_campeonato(ActionEvent event ) throws IOException {
        root = FXMLLoader.load(getClass().getResource("criar_campeonato1.fxml"));
        Stage stage = (Stage) menuButton.getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        StageUtil.centerStage(stage);
        stage.show();    
     }
    
    public void meus_campeonatos(ActionEvent event ) throws IOException {
        root = FXMLLoader.load(getClass().getResource("meus_campeonatos.fxml"));
        Stage stage = (Stage) menuButton.getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        StageUtil.centerStage(stage);
        stage.show();    
     }
    
    public void ir_para_campeonato(ActionEvent event) throws IOException {
    	FXMLLoader	loader = new FXMLLoader(getClass().getResource("criar_campeonato2.fxml"));
    	root = loader.load();        
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        StyleUtil.applyStyle(scene);
        stage.setScene(scene);
        StageUtil.centerStage(stage);
        stage.show();
    }
}
class StyleUtil {
    public static void applyStyle(Scene scene) {
        String css = StyleUtil.class.getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);
    }
}