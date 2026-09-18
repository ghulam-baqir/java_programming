import java.util.Scanner;
public class Exercise_03{

    public static void main (String [] args){
         Scanner sc= new Scanner(System.in);
    
        int a= sc.nextInt();
        String Even= (a%2 ==0) ? "even" : "odd";
        System.out.println(Even);
    }
}