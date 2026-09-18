import java . util.Scanner ;
public class Exercise_4{

    public static void main (String [] args ){
        Scanner c= new Scanner (System.in);
        System.out.println("enter your name ");
        String name = c.nextLine();
        int sum = 0;
        System.out.println("enter your marks ");
        for (int i = 0 ; i < 3 ; i++){
            int marks= c.nextInt();
             sum= sum+marks;
        }
        System.out.println("sum is " +sum);
        double avg = sum/3.0;
        System.out.println("avg is " +avg);
        
    }
}