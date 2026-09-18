import java.util.Scanner;
public class If_elseCodes{
    public static void main (String [] args){
        Scanner sc= new Scanner (System.in);
        System. out. println("enter  n number ");
        int n = sc.newInt();
        if (n%2 ==0){
            System. out. println (n+" number is even");
        }
        else {
            System . out.println(n+" number is odd ");
        }

    }
}