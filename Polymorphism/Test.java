
public class Test {

	public static void main(String[] args) {
		// Creating objects
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40.00);
		CommisionEmployee commisionEmployee = new CommisionEmployee("Sue", "Jones", "333-33-3333", 10000.00, 0.06);
		BasePlusCommisionEmployee basePlusCommisionEmployee = new BasePlusCommisionEmployee("Bob", "Lewis", "444-44-4444", 5000.00, 0.04, 300.00);
		// Printing informations by using toString and earnings methods.
		System.out.println("-----Employee Information Obtained by toString and earnings:-----");
		System.out.println(salariedEmployee.toString());
		System.out.println("Earnings : $" + salariedEmployee.earnings() + "\n\n");
		System.out.println(hourlyEmployee.toString());
		System.out.println("Earnings : $" + hourlyEmployee.earnings() + "\n\n");
		System.out.println(commisionEmployee.toString());
		System.out.println("Earnings : $" + commisionEmployee.earnings() + "\n\n");
		System.out.println(basePlusCommisionEmployee.toString());
		System.out.println("Earnings : $" + basePlusCommisionEmployee.earnings() + "\n\n");
		// Creating array for polymorphism example.
		Employee[] employees = new Employee[4];
		// Inýtýalizing array.
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commisionEmployee;
		employees[3] = basePlusCommisionEmployee;
		// Printing the informations by using for loop.
		System.out.println("-----Employee Array processed polymorphically-----\n\n");
		for(int i=0; i<4 ; i++) {
			System.out.println(employees[i]);
			// Validation for the increase baseSalary.
			if(employees[i] instanceof BasePlusCommisionEmployee) {
				double baseSalary = ((BasePlusCommisionEmployee) employees[i]).getBaseSalary();
				// Type casting for access to subclasses methods.
				((BasePlusCommisionEmployee) employees[i]).setBaseSalary(baseSalary*110/100);
				System.out.println("New base salary with 10% increase is : $" + ((BasePlusCommisionEmployee) employees[i]).getBaseSalary());
			}
			System.out.println("Earnings : $" + employees[i].earnings() + "\n");		
		}
		// Printing the class name informations.
		for(int j=0; j<4;j++) {
			System.out.println("Employee " + j + " is a " + employees[j].getClass().getName());
		}
		


	}
}
