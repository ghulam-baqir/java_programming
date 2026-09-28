public class Main {
    static int search (int [] a , int low , int high , int target ){

        if (low>high)  return -1 ;
         
        int mid = low +(high-low)/2;
        if (a[mid] == target ) return mid ;
        if (target < a[mid])
            return search(a, low, high, target);
        else {
            
            return search(a, mid+1, high, target);
        }
    }
    
    public static void main(String[] args) {
    
        int [] a= {2,3,4,10,40};
        System.out.println(search(a, 0, 5, 10 ));
    }
    
}
