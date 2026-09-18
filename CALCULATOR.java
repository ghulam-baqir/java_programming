import java.util.Scanner;
public class CALCULATOR{
    public static void main (String [] args ){
        Scanner sc = new Scanner (System.in);
        System .out.println("enter a double value ");
        double x =sc.nextDouble();
        System .out.println("enter second double value ");
        double y = sc.nextDouble();
        System.out.println("enter a character (+,-,*,/)");
        char operator = sc.next().charAt(0);
        switch (operator){
        case '+':
            System.out.println("sum = "+(x+y));
            break;
            case '-':
                System.out.println("difference  = "+(x-y));
                break;
                case '*':
                System.out.println("multiplication  = "+(x*y));
                break;
            case '/':
                System.out.println("division  = "+(x/y));
                break;
                default :
                System.out.println("invalid choice");
        }}}
            