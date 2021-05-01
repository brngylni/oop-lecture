
public class BasePlusCommisionEmployeeTest {

	public static void main(String[] args) {
		BasePlusCommisionEmployee object = new BasePlusCommisionEmployee("Bob", "Lewis", "333-33-3333", 5000.00, 0.04, 300.00);
		
		System.out.println("Employee information obtained by get methods and earnings : \n");
		System.out.println("First Name : " + object.getFirstName());
		System.out.println("Last Name : " + object.getLastName());
		System.out.println("Social Security Number : " + object.getSocialSecurityNumber());
		System.out.println("Gross Sales : " + object.getGrossSales());
		System.out.println("Commision Rate : " + object.getCommisionRate());
		System.out.println("Base Salary : " + object.getBaseSalary());
		System.out.println("Earnings : " + object.earnings());
		
		object.setBaseSalary(1000.00);
		
		System.out.println("\n\nUpdated employee information obtained by toString and earnings : \n");
		System.out.println(object.toString());
		System.out.println("Earnings : " + object.earnings());
	}

}
