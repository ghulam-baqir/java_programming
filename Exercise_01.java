import java.util.Scanner;
public class Exercise_01{
    public static void main (String [] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter marks for gradings");
        int marks = sc.nextInt();
        char grade;
        if (marks >= 90 && marks <= 100){
           grade='A';
        }
            else if (marks >= 75 && marks <= 89){
            grade='B';
            }
            else if (marks >= 60 && marks <= 74){
            grade='C';
            }
            else if (marks >= 40  && marks <= 59){
            grade='D';
            }
            else {
                 grade='F';
            }
        switch(grade){
        case 'A':
            System.out.println("A grade excellent");
            break;
            case 'B':
            System.out.println("B grade Good");
            break;
            case 'C':
            System.out.println(" c grade just right");
            break;
            case 'D':
            System.out.println("D grade needs improvements");
            break;
            case 'F':
            System.out.println("F grade so plzz tryy again and again ");
            break;
            default :
            System.out.println("no range value entered ");
        }
        }
}

            