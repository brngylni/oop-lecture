
public class Invoice implements Payable {
	// Data field
	private String partNumber;
	private String partDescription;
	private double quantity;
	private double pricePerItem;
	// Constructor
	public Invoice(String partNumber, String partDescription, double quantity, double pricePerItem){
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		// Validation for quantity and price.
		if((quantity >= 0) && (pricePerItem > 0)){
			this.quantity = quantity;
			this.pricePerItem = pricePerItem;
		}else {
			throw new IllegalArgumentException("You've entered an invalid value!");
		}
		
	}
	
	// Getter Methods
	public String getPartNumber() {
		return this.partNumber;
	}
	public String getPartDescription() {
		return this.partDescription;
	}
	public double getQuantity() {
		return this.quantity;
	}
	public double getPricePerItem(){
		return this.pricePerItem;
	}
	// Setter Methods
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public void setQuantity(double quantity) {
		// Validation
		if(quantity >= 0) {
		this.quantity = quantity;
		}else {
			throw new IllegalArgumentException("You've entered an invalid value.");
		}
	}
	public void setPricePerItem(double pricePerItem) {
		// Validation 
		if(pricePerItem > 0 ) {
		this.pricePerItem = pricePerItem;
		}else {
			throw new IllegalArgumentException("You've entered an invalid value.");
		}
	}
	@Override
	public double getPaymentAmount() {
		double amount = this.quantity * this.pricePerItem;
		return amount;
	}
	public String toString() {
		String information = "Part Number : " + this.partNumber + " (" + this.partDescription + ")\nQuantity : " + this.quantity + "\nPrice Per Item : $" + this.pricePerItem;
		return information;
	}

}
