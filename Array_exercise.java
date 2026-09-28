public class Array_exercise{
    public static void main (String [] args ){

        int arr [] = {5,10,15,40,9};
        int largest = 0 ;
        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] > largest){
                largest = arr[i];
            }
        }
        System.out.println("Largest number in the array is : " + largest);
    }
}
