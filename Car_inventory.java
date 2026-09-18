import java.util.Scanner;
public class Car_inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cars in inventory: ");
        int numCars = scanner.nextInt();
        String[] carModels = new String[numCars];
        
        for (int i = 0; i < numCars; i++) {
            System.out.print("Enter model for car " + (i + 1) + ": ");
            carModels[i] = scanner.next();
        }
        
        System.out.println("Car Inventory:");
        for (String model : carModels) {
            System.out.println(model);
        }
        
        scanner.close();
    }
}