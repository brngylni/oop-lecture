
public class Test {

	public static void main(String[] args) {
		
		Payable payableObjects[] = new Payable[6];
		// Initializing the array with objects.
		payableObjects[0] = new Invoice("01234", "seat", 2.00, 375.0);
		payableObjects[1] = new Invoice("56789", "tire", 4.00, 79.95);
		payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		payableObjects[3] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40.00);
		payableObjects[4] = new CommisionEmployee("Sue", "Jones", "333-33-3333", 10000.00, 0.06);
		payableObjects[5] = new BasePlusCommisionEmployee("Bob", "Lewis", "444-44-4444", 5000.00, 0.04, 300.00);
		// Printing the elements and some operations..
		for(int i=0; i<6; i++) {
			System.out.print(payableObjects[i] + "\n");
			if(payableObjects[i] instanceof BasePlusCommisionEmployee) {
				((BasePlusCommisionEmployee)payableObjects[i]).setBaseSalary(((BasePlusCommisionEmployee)payableObjects[i]).getBaseSalary()*110/100);
				System.out.println("New base salary that increased %10 = " + ((BasePlusCommisionEmployee)payableObjects[i]).getBaseSalary());	
			}
				System.out.print("Payment Amount = $" + payableObjects[i].getPaymentAmount() + "\n\n");
		}
		// Printing class information.
		for(int i=0; i<6; i++) {
			System.out.println("Payable object " + i + " is a " + payableObjects[i].getClass().getName());
		}
		
		
		
		
		
		
	}

}
