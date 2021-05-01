package palindrome_assignment;

import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		int number = 0;
		int reversed_number = 0;
		int controll = 0;
		System.out.print("Enter a 7-Digit Number(Enter -1 for exit.) : ");
		Scanner input = new Scanner (System.in);
		number = input.nextInt();
		if(number == -1) {					//The program exit's when the input is '-1'
			System.exit(0);
		}
		int original_number =  number;
		int remainder = 0;
		
		while(number != 0) {
			remainder = number % 10; 							//Here the program is obtaining how many digits the number has and reversing it.
			reversed_number = reversed_number * 10 + remainder;
			number /= 10;
			controll += 1;
		}
		if(controll == 7) {
			if(reversed_number == original_number) {
				
				System.out.println(original_number);
				System.out.print(" is a palindrome."); 	//Here the program decides whether the number is palindrome or not according to it's reversed version.
			}else {
				System.out.println(original_number);
				System.out.print(" is not a palindrome.");
			}
		}	
		else if(controll != 7) {
			System.out.print("Number must have 7 digit.");		//Warning for the numbers that hasn't 7 digits or has more digits.
		}
	}
	}


