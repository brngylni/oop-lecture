import java.util.Scanner;
public class bankaccount {

	public static void main(String[] args) {
		
		 double[]  accounts = new double[10];
		 int control = 0;
		 int choice = 4;
		 int id = 0;
		 double amount = 0.0;
		 
		 
		if(control == 0) {
		 for(int i=0; i<10; i++ ) {
			accounts[i] = 100.0;
			control = 1;
		}
		}
		
		while(choice == 4) {
			System.out.print("Enter an id : ");
			Scanner input = new Scanner (System.in);
			id = input.nextInt();
			choice = 0;
			while(choice != 4) {
				 System.out.print("Main menu\n");
				 System.out.print("1: Check Balance\n");
				 System.out.print("2: Withdraw\n");
				 System.out.print("3: Deposit\n");
				 System.out.print("4: Exit\n");
				 System.out.print("Enter a choice : ");
				 Scanner input2 = new Scanner (System.in);
				 choice = input2.nextInt();
				 if(choice == 1) {
					 double balance = checkbalance(accounts, id);
					 System.out.print("Current balance is : " + balance + "\n");
				 }else if(choice == 2) {
					 while(choice == 2) {
					 	System.out.print("Enter an amount to withdraw : ");
					 	Scanner input3 = new Scanner (System.in);
					amount = input3.nextDouble();
					if(accounts[id] < amount) {
						System.out.print("You can't withdraw an amount that bigger than your balance.\n");
					}else{
						break;
					}}
					accounts[id] = withdraw(accounts[id], amount);
				 }else if(choice == 3) {
					 System.out.print("Enter an amount to deposit : ");
					 Scanner input4 = new Scanner (System.in);
					 amount = input4.nextDouble();
					 accounts[id] = deposit(accounts[id], amount);
				 }else if(choice == 4){
					 exit();
				 }else {
					 continue;
				 }
			}
		}
		
		 
	}

	public static double checkbalance(double[] account, int id) {
			double balance = account[id];
			return balance;
		}
	
	public static double withdraw(double account, double amount) {
		double result = account - amount;
		return result;
	}

	public static double deposit(double account, double amount) {
		double result = account + amount;
		return result;
	}
	
	public static boolean exit() {
		return false;
	}



}