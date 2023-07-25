package TES.BarberShop;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop("customer_data.txt");
        barberShop.loadData();

        Menu menu = new Menu(barberShop);

        Scanner scanner = new Scanner(System.in);

        int choice;
        boolean hasData = !barberShop.getCustomers().isEmpty();
        List<String> orders = new ArrayList<>();

        do {
            System.out.println("1. Add Customer Data");
            System.out.println("2. Delete Customer Data");
            System.out.println("3. Reset All Data");
            if (hasData) {
                System.out.println("4. Display Customer Data");
                System.out.println("5. Haircuts Menu");
            }
            System.out.println("6. Out");
            System.out.print("Eneter Your Choices (1, 2, 3, 4, 5, or 6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter your details :");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    barberShop.addCustomer(new Customer(name, email, phoneNumber, orders));
                    hasData = true;
                    break;
                case 2:
                    System.out.print("Enter the name of the customer you want to remove: ");
                    String nameToRemove = scanner.nextLine();
                    barberShop.removeCustomerByName(nameToRemove);
                    break;
                case 3:
                    barberShop.resetData();
                    hasData = false;
                    break;
                case 4:
                    barberShop.displayData();
                    break;
                case 5:
                    menu.showMenu();
                    break;
                case 6:
                    System.out.println("Out from program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            barberShop.saveData();
        } while (choice != 6);
    }
}
