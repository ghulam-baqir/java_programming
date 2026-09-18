import java . util . Scanner ;
public class Calculations {
    public static void main (String [] args ){
        Scanner sc = new Scanner (System.in);
        System . out. println ("x =");
        int x = sc.nextInt();
        System . out. println ("y =");
        int y = sc.nextInt();
        int sum = x+y;
        System .out . println("sum is equal to : "+ sum);
        int mutiplication = x*y;
        System .out . println("mutiplicationis equal to : "+ mutiplication );
        
        double  division = (double)x/y;
        System .out . println("division equal to : "+ division );
        System .out . println("division equal to : "+ (double )(x/y)) ;
        // modulus % finding 
        int modulus= x%y;
        System .out . println("modulus equal to : "+ modulus );
        

    }
}