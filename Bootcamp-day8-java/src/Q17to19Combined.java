import java.util.*;

// 1️. Mini Banking Application
class InvalidAmountException extends Exception {
    InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccountQues {
    private int accountNumber;
    private String holderName;
    private double balance;
    private static int totalAccounts = 0;

    // Constructor
    public BankAccountQues(int accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        totalAccounts++;
    }
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Deposit amount must be positive!");
        balance += amount;
        System.out.println("Deposited: Rs " + amount);
    }
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal amount must be positive!");
        if (amount > balance) throw new InsufficientFundsException("Insufficient balance!");
        balance -= amount;
        System.out.println("Withdrawn: Rs " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void showDetails() {
        System.out.println("Account No: " + accountNumber + ", Holder: " + holderName + ", Balance: Rs " + balance);
    }
}

// 2️. Employee Management System

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to be overridden
    public double calculateSalary() {
        return 0.0;
    }

    public void showDetails() {
        System.out.println("Employee ID: " + id + ", Name: " + name);
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}


// 3. Product Catalog (Encapsulation + Custom Exception)
class InvalidPriceException extends Exception {
    InvalidPriceException(String message) {
        super(message);
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) throws InvalidPriceException {
        if (price < 0) throw new InvalidPriceException("Price cannot be negative!");
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "Product [ID=" + id + ", Name=" + name + ", Price=Rs " + price + "]";
    }
}

public class Q17to19Combined {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1️. Mini Banking Application
        System.out.println("==== Mini Banking Application ====");
        BankAccountQues acc1 = new BankAccountQues(1001, "Alice", 5000);
        BankAccountQues acc2 = new BankAccountQues(1002, "Bob", 10000);

        try {
            acc1.deposit(2000);
            acc1.withdraw(3000);
            acc1.showDetails();
        } catch (Exception e) {
            System.out.println("Bank Error: " + e.getMessage());
        }

        System.out.println("Total Bank Accounts: " + BankAccountQues.getTotalAccounts());

        // 2. Employee Management System
        System.out.println("\n==== Employee Management System ====");
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(1, "John", 40000));
        employees.add(new PartTimeEmployee(2, "Mary", 500, 80));

        for (Employee emp : employees) {
            emp.showDetails();
            System.out.println("Calculated Salary: Rs " + emp.calculateSalary());
            System.out.println("----------------------");
        }

        // 3. Product Catalog
        System.out.println("\n==== Product Catalog ====");
        try {
            List<Product> products = new ArrayList<>();
            products.add(new Product(201, "Laptop", 55000));
            products.add(new Product(202, "Smartphone", 35000));
            products.add(new Product(203, "Headphones", 2500));
            products.add(new Product(204, "Keyboard", -1000)); // Will throw exception

            for (Product p : products) {
                System.out.println(p);
            }

        } catch (InvalidPriceException e) {
            System.out.println("Product Error: " + e.getMessage());
        }

        sc.close();
    }
}
