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
        sc.close();
    }
}
