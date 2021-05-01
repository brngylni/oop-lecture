package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class ButtonOperations {
	
	// Operations that associated with add button.
	public static Person[] addButton(Person person, Person[] array, File text){
		Person[] newArray;
		// Controlling the array for Null Array Exception.
		if(array == null) {
			// Creating first person.
			person.setId(1);
			newArray = new Person[2];
			newArray[1] = person;
			
		}else {
			// Editing the incomed array then creating a new one.
			person.setId(array.length);
			newArray = new Person[array.length + 1];
			for(int i = 1; i < array.length; i++) {
				newArray[i] = array[i];
			}
			newArray[array.length] = person;
		}
		try {
			// Writing the entries to a file.
		FileOutputStream fileOut = new FileOutputStream(text, false);
		ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
		for(int i = 1; i < newArray.length; i++) {
			objOut.writeObject(newArray[i]);
		}
		// Closing the file
		objOut.flush();
		objOut.close();
		fileOut.close();
		// Catching if there is any IOException.
		}catch(IOException e) {
			e.printStackTrace();
		}
		// Setting the Alert that will be showed when a new person added.
		Alert information = new Alert(AlertType.INFORMATION);
		information.setTitle("Record added");
		information.setHeaderText("Record is added succesfully");
		information.setContentText("Record is added. Press OK to go back.");
		information.showAndWait();
		return newArray;
		
	}
	// Operations that associated with Update Bu ID button.
	public static Person[] updateByIdButton (Person[] persons, Person scanned, File text) throws IOException{
		// Controlling if the requested update ID is 0 or not.
		if(scanned.getId() == 0) {
			Alert updateAlert = new Alert(AlertType.ERROR);
			updateAlert.setTitle("Error");
			updateAlert.setHeaderText("Please enter a valid ID number.(ID Numbers Starts from 1)");
			updateAlert.setContentText("Press OK to go back");
			updateAlert.showAndWait();
			// Controlling if there is no entries.
		}else if((persons == null)){
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error");
			error.setHeaderText("There isn't any person assigned with that ID");
			error.setContentText("Press OK to go back");
			error.showAndWait();
			// Controlling if the prompted ID is bigger than the number of persons for the OutOfIndexException.
		}else if((persons != null) && (persons.length - 1 < scanned.getId()))  {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error");
			error.setHeaderText("There isn't any person assigned with that ID");
			error.setContentText("Press OK to go back");
			error.showAndWait();
		}else {
			// Then change the selected person and write it to file.
			persons[scanned.getId()] = scanned;
			FileOutputStream fileOut = new FileOutputStream(text.getName());
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(persons);
			objOut.close();
			fileOut.close();
		}
		
		return persons;
	}


}
