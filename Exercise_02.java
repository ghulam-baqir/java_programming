import java.util.Scanner;
public class Exercise_02{

    public static void main (String [] args){
         Scanner sc= new Scanner(System.in);
        int marks1= sc.nextInt();
        int marks2= sc.nextInt();
        int marks3=sc.nextInt();
        int total = marks1+marks2+marks3;
        double avg= total/300.0*100;
        System.out.println("avg is : " +avg);
        if (avg >= 90.0){
            System.out.println("A grade ");
        } else{
            System.out.println("B grade ");
        }


    }
}