package coba;

public class Calculator {
	public static void main(String [] args) {
		System.out.println("var1 + var2 = "+penjumlahan(2,3));
		System.out.println("var1 - var2 = "+pengurangan(5,3));
		System.out.println("var1 * var2 = "+perkalian(6,4));
		System.out.println("var1 / var2 = "+pembagian(12,3));
	}
	static int penjumlahan(int var1, int var2) {
		return  var1  + var2;
	}
	
	static int pengurangan(int var1, int var2) {
		return  var1  - var2;
	}
	
	static int perkalian(int var1, int var2) {
		return  var1  * var2;
	}
	
	static double pembagian(double var1, double var2) {
		return  var1  / var2;
	}
}
