import java.util.Scanner;

public class Q1to4Variable{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1. Sum of Digits
        System.out.print("Enter number for Sum of Digits: ");
        int num = sc.nextInt();
        int temp = num;
        int sum = 0;

        while (temp!=0){
            int digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        System.out.println("Sum of digits of " + num + " = "+ sum);

        //----------------------------------------------------------------------
        //2. Multiplication Table
        System.out.print("\nEnter number for Multiplication Table: ");
        int tableNum = sc.nextInt();
        System.out.println("Multiplication Table of "+ tableNum + ":");
        for (int i=1; i<=10; i++){
            System.out.println(tableNum + " x " + i + " = " + (tableNum*i));
        }

        //-----------------------------------------------------------------------
        //3. Factorial Calculator
        System.out.print("\nEnter number for Factorial: ");
        int factNum = sc.nextInt();
        long factorial = 1;
        for(int i=1; i<=factNum; i++){
            factorial *= i;
        }
        System.out.println("Factorial of " + factNum + " = " + factorial);

        //------------------------------------------------------------------------
        //4. Reverse a number
        System.out.print("\nEnter number to Reverse: ");
        int revNum = sc.nextInt();
        int reversed = 0;
        int original = revNum;
        while(revNum!=0){
            int digit = revNum%10;
            reversed = (reversed*10)+digit;
            revNum /= 10;
        }
        System.out.println("Reversed Number of "+ original + " = " + reversed);


        sc.close();
    }
}

