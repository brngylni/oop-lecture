package application;


import java.io.Serializable;

	// Implementing this interface for Object writablity.
public class Person implements Serializable{
		// Data Field
		private static final long serialVersionUID = 1L;
		private int id;
		private String name;
		private String street;
		private String city;
		private String zip;
		private String gender;
		private static int counter = 1;
		
		// Constructor
		public Person(int id, String name, String street, String city, String zip, String gender) {
			this.id = id;
			this.name = name;
			this.street = street;
			this.city = city;
			this.zip = zip;
			this.gender = gender;
			counter += 1;
		}
		
		// Getter Methods
		public int getId() {
			return this.id;
		}
		public String getName() {
			return this.name;
		}
		public String getStreet() {
			return this.street;
		}
		public String getCity() {
			return this.city;
		}
		public String getZip() {
			return this.zip;
		}
		public String getGender() {
			return this.gender;
		}
		public static int getCounter() {
			int id = counter;
			return id;
		}
		// Setter Methods
		public void setId(int id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
}
