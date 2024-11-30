import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Mainview extends Application {

    @Override
    public void start(Stage primaryStage) {
      
        
        Button enterButton = new Button("Είσοδος στην εφαρμογή");
 
        enterButton.setPrefSize(250, 60);
        
        VBox vbox = new VBox(); 
        vbox.setStyle("-fx-background-color: #A8D0E6;"); 
        vbox.setAlignment(Pos.CENTER); 
    
        
       
        vbox.getChildren().addAll(enterButton);
        
        Scene scene = new Scene(vbox, 1000, 700); 
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
