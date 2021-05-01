package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import java.io.FileNotFoundException;



public class Main extends Application {
	
	// Creating the persons array
	private Person[] persons;
	// Open the recording file.
	private File text = new File("text.txt");
	// lastShowed memorizes last printed person. For next, previous etc. buttons.
	private int lastShowed = 0;
	private int counter = 0;
	private boolean hasObject = false;

	@Override
	public void start(Stage primaryStage) throws IOException{
		// Creating the file if it's not exist.
		if(!text.exists()){
			text.createNewFile();
		}
		// Calling the initialize function.
		this.initialize();

		try {
			
			// Creating a new BorderPane for aligning everything clearly.
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,650,250);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// Our Design object.
			Design box = new Design();
			// Aligning the VBox and HBox that coming from Design class.
			root.setCenter(box.getVBox());
			root.setBottom(box.getBottomMenu());
			// Defining the button actions 
			
			box.addButton.setOnAction(e -> {
			// Catching any IOException. Also calling the addButton function in which ButtonOperations class.		
				this.persons = ButtonOperations.addButton(box.scanner(), this.persons, text);
			});
			// Using printer function in which Design class for first button.Sending ID=1 as parameter.
			box.firstButton.setOnAction(e -> {
				box.printer(1, persons);
				// Setting the lastShowed as 1 for the other processes.
				this.lastShowed = 1;
			});
			// Actions for next button.
			box.nextButton.setOnAction(e -> {
				// Controlling either the lastShowed is last person or not.
				if(this.persons == null) {
					Alert nextAlert = new Alert(AlertType.ERROR);
					nextAlert.setTitle("Error");
					nextAlert.setHeaderText("There isn't any recordings.");
					nextAlert.setContentText("Press OK to go back.");
					nextAlert.showAndWait();
				}else {
					// Controlling either the next person exists or not.
					if(lastShowed == (this.persons.length - 1)) {
						Alert nextAlert = new Alert(AlertType.ERROR);
						nextAlert.setTitle("Error");
						nextAlert.setHeaderText("It's already last person.");
						nextAlert.setContentText("Press OK to go back.");
						nextAlert.showAndWait();
							
					}else {		
					// Printing the next person of last showed person by using printer function in which Design class..
							box.printer(this.lastShowed + 1, this.persons);
							this.lastShowed++;
					}
				}
				
			});
			// Actions for previous button.
			box.previousButton.setOnAction(e -> {
				// Controlling either the lastShowed is first person or not.
				if(lastShowed == 1) {
					// Controlling the previous person exists or not.
					Alert previousAlert = new Alert(AlertType.ERROR);
					previousAlert.setTitle("Error");
					previousAlert.setHeaderText("It's already first person.");
					previousAlert.setContentText("Press OK to go back.");
					previousAlert.showAndWait();
				}else {
					// Printing the previous person of last showed person by using printer function in which Design class.
					box.printer(this.lastShowed - 1, this.persons);
					this.lastShowed--;
				}
			});
			// Actions for last button.
			box.lastButton.setOnAction(e -> {
				// Controlling either the array null or not for the Null Pointer Exception.
				if(this.persons != null) {
					// Printing the last person
					box.printer(this.persons.length - 1, this.persons);
					this.lastShowed = this.persons.length - 1;
				}else {
					Alert lastAlert = new Alert(AlertType.ERROR);
					lastAlert.setTitle("Error");
					lastAlert.setHeaderText("There isn't any recordings.");
					lastAlert.setContentText("Press OK to go back.");
					lastAlert.showAndWait();
				}
			});
			box.updateByIdButton.setOnAction(e -> {
				try {
					// Calling the ButtonOperations classes updateById method.
					this.persons = ButtonOperations.updateByIdButton(this.persons, box.scanner(), text);
				// Catching the IOExceptions.
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			});
			// Searching operations.
			box.searchByIdButton.setOnAction(e -> {
				int id = box.getSearchId();
				// Controlling if the prompted ID is 0 or not.
				if(id == 0) {
					Alert error = new Alert(AlertType.ERROR);
					error.setTitle("Error");
					error.setHeaderText("You've entered an invalid value.");
					error.setContentText("Press OK to go back");
					error.showAndWait();
				}else {
					// Calling printer for requested ID.
					box.printer(id, this.persons);
				}
			});
			box.cleanButton.setOnAction(e -> {
				// Calling the clean function of Design Class.
				box.clean();
			});
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		

		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void initialize()  throws IOException{			
		// Opening the file for reading.
		FileInputStream fileIn = new FileInputStream(this.text);
		FileInputStream fileIn2 = new FileInputStream(this.text);
		try {
			// Controlling if the file is empty or not.
		      Scanner myReader = new Scanner(text);
		      while (myReader.hasNextLine()) {
		    	  hasObject = true;
		    	  break;
		      }
		      // Closing the file.
		      myReader.close();
		      // Catching the FileNotFoundException.
		    } catch (FileNotFoundException e) {
		    }		
	if(hasObject){ 
		// If the file isn't empty, open the file again.
		ObjectInputStream objIn = new ObjectInputStream(fileIn);
		try {
			// Finding number of objects that writed before this run.
		while(objIn.readObject() != null){
			this.counter++;
			}
		// Catching the EOFException.
		}catch(Exception e2){
			// Initializing the array then closing the file.
			persons = new Person[counter + 1];
			objIn.close();
			fileIn.close();
		}
		// Reopening file for reading objects.
		ObjectInputStream objIn2 = new ObjectInputStream(fileIn2);
		try {
			// Filling the array with objects in which file.
			for(int i=1; i<=counter; i++) {
				persons[i] = (Person) objIn2.readObject();
				// Catching the EOFException again.
			}}catch(Exception e) {
				// Closing the file.
			objIn2.close();
			fileIn2.close();
			}
	}}
}