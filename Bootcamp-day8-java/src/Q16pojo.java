import java.util.*;
class Customer {
    // Private fields (Encapsulation)
    private int id;
    private String name;
    private String email;

    // Constructor
    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // toString() for easy printing
    @Override
    public String toString() {
        return "Customer [ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }
}


public class Q16pojo {
    static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(101, "Neha", "neha@gmail.com"));
        customers.add(new Customer(103, "Shruti", "shruti1@gmail.com"));
        customers.add(new Customer(105, "Nikhil", "nikhil@gmail.com"));

        System.out.println("Customer Details");
        for (Customer c : customers){
            System.out.println(c);
        }
    }
}
