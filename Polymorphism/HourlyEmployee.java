
public class HourlyEmployee extends Employee{
	// Data field.
	private double wage;
	private double hours;
	// Constructor
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		// Calling super classes constructor.
		super(firstName, lastName, socialSecurityNumber);
		// Validation for wage and hours.
		if(wage >= 0 &&  168>hours && hours >=0) {
		this.wage = wage;
		this.hours = hours;
		}else {
			throw new IllegalArgumentException("You've entered an invalid value.");
		}
	}
	// Accessors
	public double getWage(){
		return this.wage;
	}
	public double getHours(){
		return this.hours;
	}
	// Mutators
	public void setWage(double wage) {
		// Validation for wage again.
		if(wage >= 0) {
			this.wage = wage;
		}else {
			throw new IllegalArgumentException("Wage must be greater than or equal to 0!");
		}
	}	
	public void setHours(double hours){
		// Validation for hours again.
		if(hours >= 0 && hours<168) {
			this.hours = hours;
		}else {
			throw new IllegalArgumentException("Hours must be between 0 and 168!");
		}
	}
	@Override
	// Calculating the overtime wage.
	public double earnings(){
		double earning = 0;
		if(hours <= 40) {
			earning = wage * hours;
		}else if(hours > 40){
			earning = ((40 * wage) + ((hours - 40) * wage * 1.5));
		}
		return earning;
	}
	public String toString(){
		String information = "Hourly Employee : " + super.toString() + "\nHourly Wage : $" + String.valueOf(wage) + "; Hours worked : " + String.valueOf(hours);
		return information;
	}

}
