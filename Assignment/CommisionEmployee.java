
public class CommisionEmployee extends Employee {
	// Data Field
	private double grossSales;
	private double commisionRate;
	// Constructor
	public CommisionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commisionRate){
		// Calling super classes constructor.
		super(firstName, lastName, socialSecurityNumber);
		// Validation for grossSales and commisionRate.
		if(grossSales >= 0 && commisionRate>0 && commisionRate<1) {
			this.grossSales = grossSales;
			this.commisionRate = commisionRate;
		}else{
			throw new IllegalArgumentException("You've entered an invalid value.");
		}
	}
	// Accessors
	public double getGrossSales() {
		return this.grossSales;
	}
	public double getCommisionRate() {
		return this.commisionRate;
	}
	// Mutators
	public void setGrossSales(double grossSales) {
		// Validation for grossSales again.
		if(grossSales >= 0) {
			this.grossSales = grossSales;
		}else {
			throw new IllegalArgumentException("Gross Sales can not be smaller than 0!");
		}
	}
	public void setCommisionRate(double commisionRate) {
		// Validation for commisionRate again.
		if(commisionRate > 0 && commisionRate < 1) {
			this.commisionRate = commisionRate;
		}else {
			throw new IllegalArgumentException("Commision rate must be between 0 and 1 !");
		}
	}
	@Override
	public double getPaymentAmount() {
		double earning = this.commisionRate * this.grossSales;
		return earning;
	}

	public String toString() {
		String information = "Commision Employee : " + super.toString() + "\nGross Sales : $" + String.valueOf(this.grossSales) + "\nCommision Rate : " + String.valueOf(this.commisionRate);
		return information;
	}

}
