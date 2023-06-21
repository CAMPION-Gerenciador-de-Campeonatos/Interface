package application;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class StageUtil {

	public static void centerStage(Stage stage) {
        // Obtenha o tamanho da tela primária
        Screen screen = Screen.getPrimary();
        double screenWidth = screen.getBounds().getWidth();
        double screenHeight = screen.getBounds().getHeight();

        // Calcule as coordenadas para centralizar o palco
        double stageWidth = stage.getWidth();
        double stageHeight = stage.getHeight();
        double centerX = (screenWidth - stageWidth) / 2;
        double centerY = (screenHeight - stageHeight) / 2;

        // Defina as coordenadas do palco
        stage.setX(centerX);
        stage.setY(centerY);
    }
}
