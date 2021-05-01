
public class CommisionEmployee {
		private String firstName;
		private String lastName;
		private String socialSecurityNumber;
		private double grossSales;
		private double commisionRate;
		
		public  CommisionEmployee(String name, String surname, String ssn, double gross, double commision){
			if(gross < 0 || commision < 0 || commision > 1){
				throw new IllegalArgumentException("You've entered an invalid value.");
			}else {
			this.firstName =	name;
			this.lastName = surname;
			this.socialSecurityNumber =	ssn;
			this.grossSales = gross;
			this.commisionRate = commision;
			}
		}
		public String getFirstName() {
			return this.firstName;
		}
		public String getLastName() {
			return this.lastName;
		}
		public String getSocialSecurityNumber() {
			return this.socialSecurityNumber;
		}
		public double getGrossSales() {
			return this.grossSales;
		}
		public double getCommisionRate() {
			return this.commisionRate;
		}	
		public void setFirstName(String newFirstName) {
			this.firstName = newFirstName;
		}
		public void setLastName(String newLastName) {
			this.lastName = newLastName;
		}
		public void setSocialSecurityNumber(String newSsn) {
			this.socialSecurityNumber = newSsn;
		}

		public void setGrossSales(double newGrossSales) {
			if(newGrossSales < 0) {
				throw new IllegalArgumentException("You've entered an invalid value.");
			}else {
			this.grossSales = newGrossSales;
			}
		}
		public void setCommisionRate(double newCommisionRate) {
			if((newCommisionRate < 0) || (newCommisionRate > 1)) {
				throw new IllegalArgumentException("You've entered an invalid value.");
			}else {
			this.commisionRate = newCommisionRate;
			}
		}
		public double earnings() {
			double earning = grossSales * commisionRate;
			return earning;
		}
		public String toString() {
			String information = "First Name :" + this.firstName + "\nLast name : " + this.lastName + "\nSSN : " + this.socialSecurityNumber + "\nGross Sales : " + String.valueOf(this.grossSales) + "\nCommision Rate : " + String.valueOf(this.commisionRate);
			return information;
		}
}
