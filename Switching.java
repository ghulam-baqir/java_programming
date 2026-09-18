import java.util.Scanner;
public class Switching{
    public static void main (String [] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter an interger from 1 to 5");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("u chose 1");
                break;
                case 2:
                System.out.println("u chose 2");
                break;
                case 3:
                System.out.println("u chose 3");
                break;
                case 4:
                System.out.println("u chose 4");
                break;
                case 5:
                System.out.println("u chose 5");
                break;
                default :
                System.out.println("invalid option is choosen");
            
            
            
        }

    }
}