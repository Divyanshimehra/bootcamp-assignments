import java.util.Scanner;

//1. Parameterized Constructor: Create a Book class with fields title, author, and price.
//Initialize them using a parameterized constructor.
class Book{
    String title;
    String author;
    double price;

    Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails(){
        System.out.println("Book Title: "+title);
        System.out.println("Book Author: "+author);
        System.out.println("Book Price: Rs "+price);
    }
}

//2. Constructor Overloading: Create a Car class with overloaded constructors — one that sets only the model name and another that sets model and price.
class Car{
    String model;
    double price;

    //constructor1 - only model name
    Car(String model){
        this.model = model;
        this.price = 0.0; //defult
    }
    //constructor2 - Model and price
    Car(String model, double price){
        this.model = model;
        this.price = price;
    }

    void displayCar(){
        System.out.println("Model: "+ model);
        if (price>0)
            System.out.println("Price: Rs "+ price);
        else
            System.out.println("Price: not specified");
    }
}

public class Q10and11Constructors {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1. Parameterized Constructor
        System.out.println("Parameterized Constructor");
        System.out.print("Enter book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter book Author: ");
        String author = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        Book book1 = new Book(title, author, price);
        Book book2 = new Book("Atlas", "Shawn", 550.00);

        System.out.println("\nBook Details");
        book1.displayDetails();
        book2.displayDetails();

        //2. Constructor Overloading
        System.out.println("Constructor Overloading");
        Car car1 = new Car("Tesla Model");
        Car car2 = new Car("Audi 20", 450000.0);

        System.out.println("\nCar Details");
        car1.displayCar();
        car2.displayCar();

        sc.close();
    }
}
