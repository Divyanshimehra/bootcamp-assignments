import java.util.Scanner;

//1. Division with Exception
class DivisionExceptionQues{
    void doDivision(){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b= sc.nextInt();
            int result = a/b;
            System.out.println("Result = " + result);
        } catch (ArithmeticException e){
            System.out.println("Error: Cannot Divide by Zero");
        } finally {
            System.out.println("Division Completed");
        }
    }
}


//2. Nested try-catch
class NestedTryCatchQues{
    void trycatchNested() {
        try {
            int[] arr = new int[3];
            try {
                int result = 10/0;  // inner exception
            } catch (ArithmeticException e) {
                System.out.println("Inner Catch: Arithmetic Exception handled.");
            }
            arr[5] = 20;  // outer exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer Catch: Array index out of bounds handled.");
        }
    }
}


//3. Exception Propagation (Method Chain)
class ExceptionPropagationQues{
    void m3() {
        int result = 10/0;  // ArithmeticException
    }

    void m2() {
        m3(); // propagates exception up
    }

    void m1() {
        try {
            m2();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in m1(): " + e);
        }
    }
}


//4. Re-throw Exception
class ReThrowQues{
    void doReThrow(){
        try{
            int result = 10/0;
        } catch (ArithmeticException e){
            System.out.println("Caught inside doReThrow(), throwing again..");
            throw e; //rethrow same exception
        }
    }
}

//5. Custom Exception
class InvalidEmailException extends Exception{
    InvalidEmailException(String message){
        super(message);
    }
}

class EmailValidation{
    void validate(String email) throws InvalidEmailException{
        if(!email.contains("@")){
            throw new InvalidEmailException("Invalid Email: Missing '@'");
        } else {
            System.out.println("Valid email: " + email);
        }
    }
}

public class Q12to15ExceptionHandling {
    static void main(String[] args) {

        System.out.println("1. Division Exception");
        new DivisionExceptionQues().doDivision();


        System.out.println("2. Nested Try Catch");
        new NestedTryCatchQues().trycatchNested();

        System.out.println("3. Exception Propagation (Method Chain)");
        new ExceptionPropagationQues().m1();

        System.out.println("4. Re-throw Exception");
        try{
            new ReThrowQues().doReThrow();
        } catch (ArithmeticException e){
            System.out.println("Caught again in main(): "+ e);
        }

        System.out.println("5. Custom Exception");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        EmailValidation validation= new EmailValidation();
        try{
            validation.validate(email);
        } catch (InvalidEmailException e){
            System.out.println("Caught Custom Exception: "+ e.getMessage());
        }

    }
}
