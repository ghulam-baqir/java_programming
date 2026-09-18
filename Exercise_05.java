import java .util.Scanner;
public class Exercise_05{

    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        System.out. println("enter a number from one to 7 ");
        int choice = sc.nextInt();
        switch (choice){
            case 1 :
                System.out.println("Monday ");
                break;
                 case 2 :
                System.out.println("tuesday");
                break;
                 case 3 :
                System.out.println("wed ");
                break;
                 case 4 :
                System.out.println("thru ");
                break;
                 case 5 :
                System.out.println("fri ");
                break;
                 case 6 :
                System.out.println("sat ");
                break;
                 case 7 :
                System.out.println("sunday  ");
                break;
                default :
                System.out.println("invalid choice is entered !!!");
        }

    }
}