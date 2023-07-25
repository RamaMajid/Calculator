package TES.BarberShop;

import java.util.Scanner;

public class Menu {
    private BarberShop barberShop;
    private Scanner scanner;

    public Menu(BarberShop barberShop) {
        this.barberShop = barberShop;
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Regular Haircut");
            System.out.println("2. Haircut + Wash");
            System.out.println("3. Menu");
            System.out.print("Pick (1, 2, or 3): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleMenuSelection("Haircut Only", 20000);
                    break;
                case 2:
                    handleMenuSelection("Haircut + Wash", 35000);
                    break;
                case 3:
                    System.out.println("Back To Main Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
    }

    private void handleMenuSelection(String menuName, int price) {
        System.out.println("Customer Name: ");
        String customerName = scanner.nextLine();
        Customer customer = findCustomerByName(customerName);

        if (customer != null) {
            System.out.println("Order Received!");
            System.out.println("Menu: " + menuName);
            System.out.println("Price: Rp." + price);

            System.out.println("Enter the amount to paid: ");
            int payment = scanner.nextInt();
            scanner.nextLine();

            int change = payment - price;
            if (change < 0) {
                System.out.println("Sorry, you paid less money.");
            } else {
                System.out.println("Thank You Very Much!");
                System.out.println("Change: Rp." + change);

                customer.addOrder(menuName, price);
                barberShop.saveData();
            }
        } else {
            System.out.println("Customer Not Found.");
        }
    }

    private Customer findCustomerByName(String name) {
        for (Customer customer : barberShop.getCustomers()) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}