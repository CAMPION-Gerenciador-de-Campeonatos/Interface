package application;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button cadastro_button;
    @FXML
    private Button entrar_button;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private TextField cad_user;
    @FXML
    private PasswordField cad_senha;   
    @FXML
    private TextField cad_email;
    @FXML
    private Button avancar_cad2;
    @FXML
    private Label auxUser;
    @FXML
    private Label auxSenha;
    @FXML
    private Label auxEmail;
    
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
    
    String usuario, senha;
    public void cadastrar_etapa2(ActionEvent event) throws IOException {

        String usuario = cad_user.getText();
        String senha = cad_senha.getText();
        String email = cad_email.getText();

        //Verificação de Usuario
        if (usuario.length() < 5 || usuario.length() > 15) {
            auxUser.setText("Usuario inválido. Insira um usuário entre 5 a 15 carateres");
            auxUser.setVisible(true);
        }  else if (!usuario.matches("[a-zA-Z0-9_]+")) {
            auxUser.setText("Usuario com caracteres invalidos");
            auxUser.setVisible(true);
        } else {
            auxUser.setVisible(false);
            
            //Verificação de Senha
        } if (senha.length() < 8) {
            auxSenha.setText("Senha inválida. Insira uma senha com no mínimo 8 caracteres");
            auxSenha.setVisible(true);
        } else if (!senha.matches(".*[A-Z].*") || !senha.matches(".*[a-z].*")) {
            auxSenha.setText("Senha inválida. Insira uma senha com uma combinação de letras maiúsculas e minúsculas");
            auxSenha.setVisible(true);
        } else if(!senha.matches(".*\\d.*") || !senha.matches(".*[@#$%].*")) {
        	auxSenha.setText("Senha inválida. Insira uma senha com uma combinação números e caracteres especiais");
            auxSenha.setVisible(true);
        }
        else {
            auxSenha.setVisible(false);
        }
        
        //Verificação de Email
        if (email.isEmpty()) {
            auxEmail.setText("Email não pode ser vazio");
            auxEmail.setVisible(true);
        } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{3,}")) {
            auxEmail.setText("Email inválido");
            auxEmail.setVisible(true);
        } else {
            auxEmail.setVisible(false);
        }
        
        //Condições para mudança de cena
        if (!auxUser.isVisible() && !auxSenha.isVisible() && !auxEmail.isVisible()) {
        	System.out.println("Usuário: "+usuario);
            System.out.println("Senha: "+senha);
            System.out.println("Email: "+email);
            
            root = FXMLLoader.load(getClass().getResource("Cadastro_etapa2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            StyleUtil.applyStyle(scene);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void entrar(ActionEvent event) {
    	Alert aviso = new Alert(AlertType.CONFIRMATION);
    	aviso.setTitle("Champion");
    	aviso.setHeaderText("Deseja entrar no Champion?");
    	
    	if(aviso.showAndWait().get() == ButtonType.OK) {
        	stage = (Stage) scenePane.getScene().getWindow();
        	System.out.println("Você entrou no Champion!");
        	stage.close();
    	}
    }

    public void cadastrou(ActionEvent event) {
    	Alert aviso = new Alert(AlertType.CONFIRMATION);
    	aviso.setTitle("Champion");
    	aviso.setHeaderText("Deseja finalizar seu cadastro?");
    	aviso.setContentText("Informações prestadas corretas");
    	
    	if(aviso.showAndWait().get() == ButtonType.OK) {
        	stage = (Stage) scenePane.getScene().getWindow();
        	System.out.println("Você cadastrou-se no Champion!");
        	stage.close();
    	}
    }
}

class StyleUtil {
    public static void applyStyle(Scene scene) {
        String css = StyleUtil.class.getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);
    }
}