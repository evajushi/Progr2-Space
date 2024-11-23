import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Mainview extends Application {

    @Override
    public void start(Stage primaryStage) {
      
    	Label titleLabel = new Label("Βελτιστοποιήση Ραντεβού Ιατρείου");
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #2E4057;");
        
        Label descriptionLabel = new Label("(Περιγραφή εφαρμογής)");
        descriptionLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #4A4A4A;");
        
        Button enterButton = new Button("Είσοδος στην εφαρμογή");
        enterButton.setStyle("-fx-background-color: #D8A7D2; -fx-text-fill: black; -fx-font-size: 20px;");
        enterButton.setPrefSize(250, 60);
        
        VBox vbox = new VBox(80); 
        vbox.setStyle("-fx-background-color: #A8D0E6;"); 
        vbox.setAlignment(Pos.CENTER); 
        vbox.setPadding(new Insets(50, 20, 20, 20))
        
        VBox.setMargin(titleLabel, new Insets(-250, 0, 0, 0));
        vbox.getChildren().addAll(enterButton);
        
        Scene scene = new Scene(vbox, 1000, 700); 
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
