package modul6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.print("Masukkan jumlah suku deret: ");
            int jumlahSuku = scanner.nextInt();

            DeretInteger deret = new DeretInteger(jumlahSuku);
            deret.input();

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Pengurutan Ascending");
                System.out.println("2. Pengurutan Descending");
                System.out.println("3. Nilai Maksimal");
                System.out.println("4. Nilai Minimal");
                System.out.println("5. Masukkan jumlah suku deret lagi");
                System.out.println("6. Keluar");

                System.out.print("Pilih menu: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        deret.sortAscending();
                        System.out.println("\nHasil pengurutan ascending:");
                        for (int i = 0; i < jumlahSuku; i++) {
                            System.out.print(deret.getDeret()[i] + " ");
                        }
                        break;
                    case 2:
                        deret.sortDescending();
                        System.out.println("\nHasil pengurutan descending:");
                        for (int i = 0; i < jumlahSuku; i++) {
                            System.out.print(deret.getDeret()[i] + " ");
                        }
                        break;
                    case 3:
                        System.out.println("\nNilai maksimal: " + deret.getMax());
                        break;
                    case 4:
                        System.out.println("\nNilai minimal: " + deret.getMin());
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                        break;
                }
            } while (choice != 5 && choice != 6);

        } while (choice == 5);
    }
}
