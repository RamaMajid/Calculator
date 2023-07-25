package TES.BarberShop;

import java.util.List;
public class Customer {
	private String name;
    private String email;
    private String phoneNumber;
    private List<String> orders;

    public Customer(String name, String email, String phoneNumber, List<String> orders) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void addOrder(String order, int price) {
        orders.add(order);
    }

    public List<String> getOrders() {
        return orders;
    }
}
