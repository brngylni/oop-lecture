import java.util.Scanner; 
public class numbergame {

	public static void main(String[] args) {
		
		int number = (int)(Math.random() * 100);
		int prompt = 0;
		int counter = 0;

		 
		while(prompt != number) {
			System.out.print("Enter a number : ");

			if(prompt < number) {
				System.out.print("Enter a higher value.");
			}else if(prompt > number) {
				System.out.print("Enter a lower value.");
			}
			counter += 1;
			Scanner input = new Scanner (System.in);
			prompt = input.nextInt();
		}
		
		
	}

}
