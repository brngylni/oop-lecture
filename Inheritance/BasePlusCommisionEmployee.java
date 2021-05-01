
public class BasePlusCommisionEmployee extends CommisionEmployee{
	double baseSalary;
	public BasePlusCommisionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commisionRate, double baseSalary){
		super(firstName, lastName, socialSecurityNumber, grossSales, commisionRate);
		if(baseSalary < 0) {
			throw new IllegalArgumentException("You've entered an invalid value!");
		}else {
		this.baseSalary = baseSalary;
		}
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary){
		this.baseSalary = baseSalary;
	}
	public double earnings() {
		double earning = this.getCommisionRate() * this.getGrossSales() + this.baseSalary;
		return earning;
	}
	public String toString() {
		String information = "First Name : " + this.getFirstName() + "\nLast Name : " + this.getLastName() + "\nSocial Security Number : " + this.getSocialSecurityNumber() + "\nGross Sales : " + String.valueOf(this.getGrossSales()) + "\nCommision Rate : " + String.valueOf(this.getCommisionRate()) + "\nBase Salary : " + String.valueOf(this.baseSalary);
		return information;	
	}

}
