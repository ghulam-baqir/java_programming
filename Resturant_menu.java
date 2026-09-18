import java .util.Scanner;
public class Resturant_menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Restaurant Menu!");
        System.out.println("Please select an option:");
        System.out.println("1. Appetizers");
        System.out.println("2. Main Courses");
        System.out.println("3. Desserts");
        System.out.println("4. Beverages");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("You selected Appetizers.");
                // Add code to display appetizers
                break;
            case 2:
                System.out.println("You selected Main Courses.");
                // Add code to display main courses
                break;
            case 3:
                System.out.println("You selected Desserts.");
                // Add code to display desserts
                break;
            case 4:
                System.out.println("You selected Beverages.");
                // Add code to display beverages
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
        }
        
        scanner.close();
    }
}