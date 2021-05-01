package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {
	Stage window;
	Button addButton, firstButton, nextButton, previousButton, lastButton, updateByIdButton, searchByIdButton, cleanButton;
	Person[] persons;
	public static void main(String[] args) {
		launch(args);
		
	}
	@Override
	public void start(Stage arg0) throws Exception {
		
		window = arg0;
		window.setTitle("Address Book");

		addButton = new Button("Add");
		firstButton = new Button("First");
		nextButton = new Button("Next");
		previousButton = new Button("Previous");
		lastButton = new Button("Last");
		updateByIdButton = new Button("Update By Id");
		searchByIdButton = new Button("Search By Id");
		cleanButton = new Button("Clean textFields");
		
		BorderPane layout = new BorderPane();
		layout.getChildren().addAll(addButton, firstButton, nextButton, previousButton, lastButton, updateByIdButton, searchByIdButton, cleanButton);
		
		addButton.setOnAction(e ->{
		AlertBox.display("Record is added succesfully", "Information");
		});
		
		
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
		
	}

}
