
public class SalariedEmployee extends Employee{

	private double weeklySalary;
	
	// Constructor
	
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary){
		// Calling super classes constructor
		super(firstName, lastName, socialSecurityNumber);
	
		// Validation for weeklySalary
		if(weeklySalary >= 0) { 
			this.weeklySalary = weeklySalary;
		}else {
			throw new IllegalArgumentException("You've entered an invalid value.Weekly Salary has to be greater than or equal to 0");
		}
	}

	// Accessor 
	public double getWeeklySalary(){
		return this.weeklySalary;
	}
	// Mutator
	public void setWeeklySalary(double weeklySalary){
		// Validation for weeklySalary again.
		if(weeklySalary >= 0) {
			this.weeklySalary = weeklySalary;
		}else {
			throw new IllegalArgumentException("Weekly Salary must be greater than or equal to 0!");
		}
	}
	@Override 
	public double earnings(){
		return weeklySalary;
	}
	public String toString(){
		String information = "Salaried Employee : " + super.toString() + "\nWeekly Salary : $" + String.valueOf(this.weeklySalary);
		return information;
	}
}
