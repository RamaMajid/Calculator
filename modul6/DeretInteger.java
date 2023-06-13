package modul6;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class DeretInteger {
	private int jumlahSuku;
	private int[] deret;

	public DeretInteger(int jumlahSuku) {
		this.jumlahSuku = jumlahSuku;
		this.deret = new int[jumlahSuku];
	}

	public void input() {
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < jumlahSuku; i++) {
			boolean validInput = false;

			while (!validInput) {
				try {
					System.out.print("Masukkan elemen ke-" + (i + 1) + ": ");
					int input = scanner.nextInt();

					if (input < 0) {
						throw new NegativeNumberException("Input tidak boleh negatif! Silakan masukkan elemen baru.");
					}

					if (input == 0) {
						System.out.println("Input tidak boleh nol! Silakan masukkan elemen baru.");
						continue;
					}

					deret[i] = input;
					validInput = true;
				} catch (InputMismatchException e) {
					System.out.println("Input harus berupa bilangan bulat!");
					scanner.nextLine();
				} catch (NegativeNumberException e) {
					System.out.println(e.getMessage());
					scanner.nextLine();
				}
			}
		}
	}

	public void sortAscending() {
		Arrays.sort(deret);
	}

	public void sortDescending() {
		Arrays.sort(deret);

		for (int i = 0; i < jumlahSuku / 2; i++) {
			int temp = deret[i];
			deret[i] = deret[jumlahSuku - 1 - i];
			deret[jumlahSuku - 1 - i] = temp;
		}
	}

	public int getMax() {
		int max = deret[0];
		for (int i = 1; i < jumlahSuku; i++) {
			if (deret[i] > max) {
				max = deret[i];
			}
		}
		return max;
	}

	public int getMin() {
		int min = deret[0];
		for (int i = 1; i < jumlahSuku; i++) {
			if (deret[i] < min) {
				min = deret[i];
			}
		}
		return min;
	}

	public int[] getDeret() {
		return deret;
	}
}
