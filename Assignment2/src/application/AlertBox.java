package application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
	
	
	public static void display(String message, String title) {
		Stage window = new Stage();
		 
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("OK");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
		
	}
	
}	
