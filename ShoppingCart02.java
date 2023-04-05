package coba;

public class ShoppingCart02 {
	public static void main(String [] args) {
		 double price = 5.0;
		    double tax = 0.25;
		    int quantity = 3;
		    double totalPrice = (price * quantity) * (1 + tax);
		    String custName = "Rama";
		    String itemDesc = "Jacket";
		    String message = custName + " wants to purchase " + quantity + " " + itemDesc;
		    System.out.println(message);
		    System.out.println("Total cost with tax is: $" + totalPrice);
	}
}
