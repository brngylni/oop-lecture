
public class BasePlusCommisionEmployee extends CommisionEmployee{
	// Data Field
	private double baseSalary;
	// Constructor
	public BasePlusCommisionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commisionRate, double baseSalary) {
		// Calling the super classes constructor.
		super(firstName, lastName, socialSecurityNumber, grossSales, commisionRate);
		// Validation for baseSalary
		if(baseSalary >= 0) {
			this.baseSalary = baseSalary;
		}else {
			throw new IllegalArgumentException("Base Salary must be greater than or equal to 0!");
		}
	}
	// Accessor
	public double getBaseSalary() {
		return this.baseSalary;
	}
	// Mutator
	public void setBaseSalary(double baseSalary) {
		// Validation for baseSalary again.
		if(baseSalary >= 0) {
			this.baseSalary = baseSalary;
		}else {
			throw new IllegalArgumentException("Base Salary must be greater than or equal to 0!");
		}
	}
	@Override
	public double getPaymentAmount() {
		double amount;
		amount = (super.getPaymentAmount() + this.baseSalary);
		return amount;
	}
	public String toString() {
		String information = "Base Salaried " + super.toString() + "\nBase Salary : $" + String.valueOf(this.baseSalary); 
		return information;
	}
}
