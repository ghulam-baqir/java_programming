import java.util.Scanner;
public class SimpleCalculator(){
    public static void main (String [] args ){
          Scanner sc = new Scanner (System.in);
          System.out.println("Enter the first number: ");
          int num1 = sc.nextInt();
            System.out.println("Enter the second number: ");
            int num2 = sc.nextInt();
            char operator;
            System.out.println("Enter an operator (+, -, *, /): "); 
            if (operator == '+') {
                System.out.println(num1 + num2);
            } else if (operator == '-') {
                System.out.println(num1 - num2);
            } else if (operator == '*') {
                System.out.println(num1 * num2);
            } else if (operator == '/') {
                System.out.println(num1 / num2);
            } else {
                System.out.println("Invalid operator");
            }

    }
}