import java.util.Scanner;

//1. Simple Calculator
class Calculator{
    // methods for basic operations
    double add(double a, double b){
        return a + b;
    }
    double subtract(double a, double b){
        return a - b;
    }
    double multiply(double a, double b){
        return a * b;
    }
    double divide(double a, double b){
        if (b==0){
            System.out.println("Error: Division by 0 not allowed");
        }
        return a/b;
    }
}

//2. Student Report
class Student{
    String name;
    int marks1, marks2, marks3;

    //constructor to initialize fields
    Student(String name, int marks1, int marks2, int marks3){
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    //method to calculate total and average marks
    int totalMarks(){
        return marks1+marks2+marks3;
    }
    double averageMarks(){
        return totalMarks()/3.0;
    }

    //Display
    void displayReport(){
        System.out.println("\nStudent Name: "+ name);
        System.out.println("Marks: "+ marks1 + ", " + marks2 + ", " + marks3);
        System.out.println("Total Marks: " + totalMarks());
        System.out.println("Average Marks: "+ averageMarks());
    }
}

// Bank account class
class BankAccount{
    String accountNumber;
    String holderName;
    double balance;

    //parameterized constructor
    BankAccount(String accountNumber, String holderName, double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    //methods
    void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }
    void displayBalance() {
        System.out.println("Account: " + accountNumber + ", Holder: " + holderName + ", Balance: ₹" + balance);
    }

}


public class Q5to7ClassesMethodsConstructors {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //1. calculator
        Calculator calc = new Calculator();
        System.out.println("SIMPLE CALCULATOR");
        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.println("Addition: " + calc.add(a,b));
        System.out.println("Subtraction: " + calc.subtract(a,b));
        System.out.println("Multiplication: " + calc.multiply(a,b));
        System.out.println("Division: " + calc.divide(a,b));

        // student report
        System.out.println("\nSTUDENT REPORT");
        System.out.print("Enter Student name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks in 3 subjects: ");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();

        Student stu = new Student(name, m1, m2, m3);
        stu.displayReport();

        // bank account
        System.out.println("\nBANK ACCOUNT");
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();
        sc.nextLine();
        System.out.print("Enter Holder Name: ");
        String holder = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        BankAccount acc = new BankAccount(accNo, holder, bal);
        acc.displayBalance();

        acc.deposit(2000);
        acc.withdraw(1500);
        acc.displayBalance();


        sc.close();
    }
}
