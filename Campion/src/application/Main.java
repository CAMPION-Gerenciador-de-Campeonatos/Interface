package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
	        StyleUtil.applyStyle(scene);
			stage.setScene(scene);
			stage.show();
			
			stage.setOnCloseRequest(event -> {
				event.consume();
				sair(stage);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public void sair(Stage stage) {
    	Alert aviso = new Alert(AlertType.CONFIRMATION);
    	aviso.setTitle("Champion");
    	aviso.setHeaderText("Deseja finalizar seu processo?");
    	aviso.setContentText("Obrigado por usar o Champion");
    	
    	if(aviso.showAndWait().get() == ButtonType.OK) {
        	stage.close();
    	}
    }

	public static void main(String[] args) {
		launch(args);
	}
}
