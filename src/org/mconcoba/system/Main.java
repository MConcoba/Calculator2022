
package org.mconcoba.system;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author mconcoba
 */
public class Main extends Application  {
    
    private final String PAQUETE_VISTA = "/org/mconcoba/view/";
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(PAQUETE_VISTA + "CalculatorView.fxml"));
        // stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Calculator");
        stage.getIcons().add(new Image("/org/mconcoba/view/calc.png"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
