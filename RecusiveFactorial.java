
public class RecusiveFactorial {

    static long factorial (int n ){
        if (n<0) throw new IllegalArgumentException("Negative numbers are not allowed");
        if (n>20) throw new IllegalArgumentException("Index is out of bond ");
        if (n<=1) return 1;
        return n*factorial(n-1);
    }
    static fab(int n ){

    }
    static void  main (){
        long num = factorial(-10);
        System.out.println(num);
    }
    
}
