package application;
import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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
    private MenuButton menuButton;
    @FXML
    private MenuButton menuButton2;
    
    //ID's para a tela de login_cadastro:
    @FXML 
    private TextField email_login_id;
    @FXML 
    private PasswordField senha_login_id;
    @FXML 
    private TextField user_cad_id;
    @FXML 
    private PasswordField senha_cad_id;
    @FXML
    private TextField email_cad_id;
    @FXML
	private ImageView avatar_cad_id;
    
    //ID's para a tela de meus_campeonatos:
    @FXML
    private TextField nome_buscarCamp_id;
    @FXML
    private TextField status_buscarCamp_id;
    @FXML
    private TextField modalidade_buscarCamp_id;
    
    //ID's para tela de meus_times:
    @FXML
    private TextField nome_buscarTime_id;
    
    //ID's para tela de criar_campeonato1:
    @FXML
    private TextField nome_criarCamp;
    @FXML
    private RadioButton tipo_Real;
    @FXML
    private RadioButton tipo_VideoGame;
    @FXML
    private RadioButton competidores_Time;
    @FXML
    private RadioButton competidores_Jogador;
    @FXML
    private TextField numero_Competidores;
    
    //ID's para tela de criar_campeonato2:
    @FXML
    private ImageView imagem_criarCamp;
    @FXML
    private MenuButton andamento_Status;
    @FXML
    private MenuButton encerrado_Status;
    @FXML
    private TextArea descricao_Camp;
    @FXML
    private TextField data_inicio;
    @FXML
    private TextField data_termino;
    
    //ID's para tela de criar_time:
    @FXML
    private TextField nome_criarTime;
    @FXML
    private TextArea descricao_time;
    @FXML
    private TextField abreviacao_time;
    @FXML
    private TextField rival_time;
    @FXML
    private TextField casa_time;
    @FXML
    private ImageView imagem_time;
    @FXML
    private TextField nome_jogadores;
    @FXML
    private ListView<?> lista_jogadores;
    
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
    	    avatar_cad_id.setImage(image);
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