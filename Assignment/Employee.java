
public abstract class Employee implements Payable {
	// Data field.
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	//Constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	// Accessors
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getSocialSecurityNumber() {
		return this.socialSecurityNumber;
	}
	// Mutators
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber){
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public String toString() {
		String information = this.firstName + " " + this.lastName + "\nSocial Security Number : " + this.socialSecurityNumber;
		return information;
				
	}
}
