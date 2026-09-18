import java.util.Scanner;
public class Looping_marks{
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name : ");
        String name = sc.nextLine();
        System.out.println("Field ");
        String Field= sc.nextLine();
         System.out.println("obtained marks of five courses  : ");
        /*  int marks = sc.nextInt();
         System.out.println("betch number ");
           int betch= sc.nextInt();
           // deciding grades accordingly 
            //printing all things
            System.out.println("*******result******");
            System.out.println("name : "+name);
            System.err.println("betch no :"+betch);
            System.out.println("departnment : "+Field);
            System.out.println("obtained marks : "+marks);
            // deciding the grades 
             if (marks >= 90 && marks <= 100){
             System.out.println("A grade");
           }
             else if (marks >= 80 && marks <= 90) {
             System.out.println("Grade : B ");
             }
             else {
                 System.out.println("fail");
                }*/
               int sum=0;
for (int i = 0 ; i < 5 ; i++){
  int marks= sc.nextInt();
  sum= sum+marks;
  }
  //or (int i = 0 ; i < 5; i++){
    //sum= sum+i;
  //}
  
System.out.println(sum);
    }
}