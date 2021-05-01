
public class stars {

	public static void main(String[] args) {
		
		int x = 0;
		int y = 0;
		int row = 0;
		
		while(row <= 10) {	
				while(x < row) {
					System.out.print("*");
					if(x == row-1) {						//First triangle.
						System.out.print("\n");
					}
					x += 1;
				}
		x = 0;
		row += 1;
		}
			
		x = 11;
		row = 0; 		//Adjusting the values for the next loop.
		System.out.print("\n\n");
		
		while(row < 9) {
											
			while(x > row) {	
				System.out.print("*");		//Second Triangle
				x -= 1 ;
				if(x == row+1) {
					System.out.print("\n");
				}
			}
		x = 10;
		row += 1;		
		}
	
		System.out.print("\n\n");
		row = 0;
		x = 0;
		
		while(row <= 10) {	
			while(x < row) {
				if(x >= 1) {
				System.out.print(" ");
				}											//Third triangle.
				if(x == row-1) {
					while(10>x) {
						System.out.print("*");
						x +=1;
					}
					x = row-1;
					System.out.print("\n");
				}
				x += 1;
			}
	x = 0;
	row += 1;
	}
	
		
	System.out.print("\n\n");
	row = 0;
	x= 10;
	while(row < 10) {
		while(x > row) { 
			if(x < 10) {
			System.out.print(" ");
			}
			if(x == row+1) {
				while(row >= 0 ){					//Fourth triangle.
					System.out.print("*");
					row -=1;
			}
				row = x-1;
				if(row >= 0) {
				System.out.print("\n");
				}
			}
			x -= 1 ;
		}
	x = 10;
	row += 1;		
	}
		
}	
}
	

 			