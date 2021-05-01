package application;

public class Person {
	
	private int id;
	private String name;
	private String street;
	private String city;
	private int zip;
	private String gender;
	private static int counter = 0;
	
	public Person(int id, String name, String street, String city, int zip, String gender) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.gender = gender;
		counter += 1;
	}
	
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
	public int getZip() {
		return this.zip;
	}
	public String getGender() {
		return this.gender;
	}
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
	public void setZip(int zip) {
		this.zip = zip;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
