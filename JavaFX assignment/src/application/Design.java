package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Design {
	// Data field.
	public Button addButton, firstButton, nextButton, previousButton, lastButton, updateByIdButton, searchByIdButton = null, cleanButton;
	private VBox vbox = new VBox();
	private HBox bottomMenu = new HBox();
	private String name, street, city, gender, searchId, zip;
	private TextField searchUpdateField = new TextField();
	private TextField nameField = new TextField();
	private TextField streetField = new TextField();
	private TextField cityField = new TextField();
	private TextField zipField = new TextField();
	private TextField genderField = new TextField();
	private TextField idField = new TextField();
	
	public Design() {
		// First row of VBox.
		HBox row1 = new HBox(6);
		Label idLabel = new Label("ID : ");
		idLabel.setMinWidth(50);
		idLabel.setAlignment(Pos.CENTER_LEFT);
		this.idField.setDisable(true);
		this.idField.setMinWidth(40);
		this.idField.setMaxWidth(40);
		Label searchUpdateLabel = new Label("Search/Update ID : ");
		this.searchUpdateField.setMinWidth(161);
		this.searchUpdateField.setMaxWidth(161);
		row1.getChildren().addAll(idLabel, this.idField, searchUpdateLabel, this.searchUpdateField);
		row1.setAlignment(Pos.CENTER_LEFT);
		this.fieldLimiter(searchUpdateField, 4);

		// Second row of VBox
		HBox row2 = new HBox(6);
		Label nameLabel = new Label("Name : ");
		nameLabel.setAlignment(Pos.CENTER_LEFT);
		nameLabel.setMinWidth(50);
		this.nameField.setMinWidth(320);
		this.nameField.setMaxWidth(320);
		row2.getChildren().addAll(nameLabel, this.nameField);
		row2.setAlignment(Pos.CENTER_LEFT);
		this.fieldLimiter(nameField, 32);
		
		
		// 3. row of VBox
		HBox row3 = new HBox(6);
		Label streetLabel = new Label("Street : ");
		streetLabel.setAlignment(Pos.CENTER_LEFT);
		streetLabel.setMinWidth(50);
		this.streetField.setMinWidth(320);
		this.streetField.setMaxWidth(320);
		row3.getChildren().addAll(streetLabel, streetField);
		row3.setAlignment(Pos.CENTER_LEFT);
		this.fieldLimiter(streetField, 32);
		 
		// 4. row of VBox
		HBox row4 = new HBox(6);
		Label cityLabel = new Label("City : ");
		cityLabel.setMinWidth(50);
		cityLabel.setAlignment(Pos.CENTER_LEFT);
		this.cityField.setMinWidth(144);
		this.cityField.setMaxWidth(144);
		Label genderLabel = new Label("Gender : ");
		this.genderField.setMinWidth(30);
		this.genderField.setMaxWidth(30);
		Label zipLabel = new Label("Zip : ");
		this.zipField.setMinWidth(50);
		this.zipField.setMaxWidth(50);
		row4.getChildren().addAll(cityLabel, this.cityField, genderLabel, this.genderField, zipLabel, this.zipField);
		row4.setAlignment(Pos.CENTER_LEFT);
		this.vbox.getChildren().addAll(row1, row2, row3, row4);
		this.vbox.setPadding(new Insets(50, 10, 10, 120));
		this.vbox.setSpacing(4);
		this.fieldLimiter(cityField, 20);
		this.fieldLimiter(genderField, 1);
		this.fieldLimiter(zipField, 5);
		
		// Bottom Button Menu
		this.addButton = new Button("Add");
		this.firstButton = new Button("First");
		this.nextButton = new Button("Next");
		this.previousButton = new Button("Previous");
		this.lastButton = new Button("Last");
		this.updateByIdButton = new Button("Update By Id");
		this.searchByIdButton = new Button("Search By Id");
		this.cleanButton = new Button("Clean textFields");
		this.bottomMenu.getChildren().addAll(this.addButton, this.firstButton, this.nextButton, this.previousButton, this.lastButton, this.updateByIdButton, this.searchByIdButton, this.cleanButton);
		this.bottomMenu.setSpacing(10);
		this.bottomMenu.setPadding(new Insets(10, 10, 10, 20));
		this.bottomMenu.setAlignment(Pos.BOTTOM_CENTER);
			}
	// Getter for VBox
	public VBox getVBox() {
		return this.vbox;
	}
	// Getter for HBox
	public HBox getBottomMenu() {
		return this.bottomMenu;
	}
	// Scanning textfields
	public Person scanner() {
		Person person;
		int id;
		this.searchId = this.searchUpdateField.getText();
		this.name = this.nameField.getText();
		this.street = this.streetField.getText();
		this.city = this.cityField.getText();
		this.zip = this.zipField.getText();
			// Catching Number Format Exception.
		try {
			id = Integer.parseInt(this.searchId);
			person = new Person(id, this.name, this.street, this.city, this.zip, this.gender);
		}catch(Exception e) {
			person = new Person(0, this.name, this.street, this.city, this.zip, this.gender);
		}
		return person;
	}
	// Scanner for Search/Update By ID
	public int getSearchId(){
		int id;
		try{
			this.searchId = this.searchUpdateField.getText();
			id = Integer.parseInt(this.searchId);
			return id;
		}catch(NumberFormatException e) {
			id = 0;
			return id;
		}

	}
	// Printer for textfields.
	public void printer(int id, Person[] person) {
		// Controlling for NullPointerException and OutOfIndexException
		if(person == null){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No one to show.");
			alert.setHeaderText("There isn't any recording");
			alert.setContentText("Please add some records to see your first record.");
			alert.showAndWait();
			return;
		}else{
			this.idField.setText(String.valueOf(person[id].getId()));
			this.nameField.setText(person[id].getName());
			this.streetField.setText(person[id].getStreet());
			this.cityField.setText(person[id].getCity());
			this.genderField.setText(person[id].getGender());
			this.zipField.setText(person[id].getZip());
			return;
		}
	}
	// Cleaner for clean button.
	public void clean() {
		this.idField.clear();
		this.nameField.clear();
		this.streetField.clear();
		this.cityField.clear();
		this.zipField.clear();
		this.genderField.clear();
		this.searchUpdateField.clear();
	}
	// Character limiter.
	public void fieldLimiter(TextField field, int limit) {
			field.textProperty().addListener(new ChangeListener<String>() {
				public void changed(ObservableValue<? extends String> value, String oldValue, String newValue) {
					if((field.getText() != null) && (field.getText() != "")) {
						if(field.getText().length() > limit) {
							String limited = field.getText().substring(0,limit);
							field.setText(limited);
					}
				}
			}
		});		
	}		
}


