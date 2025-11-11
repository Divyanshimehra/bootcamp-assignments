


//1. Static Counter : Create a class where every time an object is created, a static counter increases.
// Print how many objects have been created.

import java.util.Scanner;

class ObjectCounter{
    static int count = 0; //static variable
    ObjectCounter(){
        count++;
        System.out.println(("Object created. Current Count: "+count));
    }

    //static method
    static void displayCount(){
        System.out.println("Total Objects created: "+ count);
    }
}

//2. Static Utility Class : Create a MathUtils class with static methods for max, min, and average.
//Call these without creating an object.

class MathUtils{
    private MathUtils(){} //prevents object creation

    //static methods
    static int max(int a, int b){
        return (a > b) ? a : b;
    }
    static int min(int a, int b){
        return (a < b) ? a : b;
    }
    static double average(int a, int b){
        return (a+b)/2.0;
    }

}


public class Q8and9StaticKeyword {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1. Static counter
        System.out.println("Static counter begins");
        ObjectCounter obj1 = new ObjectCounter();
        ObjectCounter obj2 = new ObjectCounter();
        ObjectCounter obj3 = new ObjectCounter();

        ObjectCounter.displayCount();


        //2. Static Utility Class
        System.out.println("Static Utility Class");
        System.out.println("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Max: "+ MathUtils.max(a,b));
        System.out.println("Min: "+ MathUtils.min(a,b));
        System.out.println("Average: "+ MathUtils.average(a,b));

        sc.close();

    }
}
