import java.util.Scanner;
public class UnderstandingJava{
    public  static void Sayhello(){
        System.out.println("haan jee !!");
    }
    public static int Summation(int a , int b){
        return a+b;
    }
    public static  void Calculate(int x , int y ){
        int sum = x+y;
        int subtraction = x-y;
        int divivsion= x/y;
        int multiplication = x*y;
        System.out.println("sum :" +sum);
        System.out.println("subtraction :" +subtraction);
        System.out.println("division :" +divivsion);
        System.out.println("multiplication :" +multiplication);
        
    }

    public static void main (String [] args ){
//Scanner sc = new Scanner(System.in);
Sayhello();
int result = Summation(2,6);
System.out.println(result);
 Calculate(4, 4);


        
    }
}