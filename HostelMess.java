import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simple Hostel Mess Management System
 * Pricing is unit-wise: 2 units per day
 *   Unit 1 = Breakfast = 100
 *   Unit 2 = Dinner    = 150
 */
public class HostelMess {

    static final int BREAKFAST_PRICE = 100;
    static final int DINNER_PRICE = 150;

    // ---------- Student class ----------
    static class Student {
        int id;
        String name;
        String room;
        int breakfastDays;
        int dinnerDays;

        Student(int id, String name, String room) {
            this.id = id;
            this.name = name;
            this.room = room;
        }

        int breakfastCost() { return breakfastDays * BREAKFAST_PRICE; }
        int dinnerCost()    { return dinnerDays * DINNER_PRICE; }
        int totalUnits()    { return breakfastDays + dinnerDays; }
        int totalBill()     { return breakfastCost() + dinnerCost(); }

        void printBill() {
            System.out.println("\n========== MESS BILL ==========");
            System.out.println("ID    : " + id);
            System.out.println("Name  : " + name);
            System.out.println("Room  : " + room);
            System.out.println("-------------------------------");
            System.out.printf("Breakfast : %2d days x %d = %6d%n", breakfastDays, BREAKFAST_PRICE, breakfastCost());
            System.out.printf("Dinner    : %2d days x %d = %6d%n", dinnerDays, DINNER_PRICE, dinnerCost());
            System.out.println("-------------------------------");
            System.out.println("Total Units : " + totalUnits());
            System.out.println("TOTAL BILL  : " + totalBill());
            System.out.println("===============================");
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    // ---------- Input helpers ----------
    static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value >= min && value <= max) return value;
                System.out.println("Enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    static String readText(String prompt) {
        String s;
        do {
            System.out.print(prompt);
            s = sc.nextLine().trim();
        } while (s.isEmpty());
        return s;
    }

    static Student findStudent(int id) {
        for (Student s : students) {
            if (s.id == id) return s;
        }
        return null;
    }

    // ---------- Features ----------
    static void addMealDays(Student s, int plan, int days) {
        if (plan == 1 || plan == 3) s.breakfastDays += days;
        if (plan == 2 || plan == 3) s.dinnerDays += days;
    }

    static int choosePlan() {
        System.out.println("\nSelect Plan:");
        System.out.println("1. Breakfast only  (" + BREAKFAST_PRICE + "/day)");
        System.out.println("2. Dinner only     (" + DINNER_PRICE + "/day)");
        System.out.println("3. Breakfast + Dinner (" + (BREAKFAST_PRICE + DINNER_PRICE) + "/day)");
        return readInt("Choice: ", 1, 3);
    }

    static void registerStudent() {
        String name = readText("Student name: ");
        String room = readText("Room number: ");
        Student s = new Student(nextId++, name, room);

        int plan = choosePlan();
        int days = readInt("Number of days (1-31): ", 1, 31);
        addMealDays(s, plan, days);

        students.add(s);
        System.out.println("\nStudent registered with ID " + s.id);
        s.printBill();
    }

    static void addMoreDays() {
        if (students.isEmpty()) { System.out.println("No students registered."); return; }
        int id = readInt("Student ID: ", 1, Integer.MAX_VALUE);
        Student s = findStudent(id);
        if (s == null) { System.out.println("Student not found."); return; }

        int plan = choosePlan();
        int days = readInt("Number of days to add (1-31): ", 1, 31);
        addMealDays(s, plan, days);
        System.out.println("Meal days added.");
        s.printBill();
    }

    static void viewBill() {
        if (students.isEmpty()) { System.out.println("No students registered."); return; }
        int id = readInt("Student ID: ", 1, Integer.MAX_VALUE);
        Student s = findStudent(id);
        if (s == null) { System.out.println("Student not found."); return; }
        s.printBill();
    }

    static void showAllStudents() {
        if (students.isEmpty()) { System.out.println("No students registered."); return; }
        int grandTotal = 0;
        System.out.println("\nID  Name             Room   B.days  D.days  Units  Bill");
        System.out.println("---------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-3d %-16s %-6s %-7d %-7d %-6d %d%n",
                    s.id, s.name, s.room, s.breakfastDays, s.dinnerDays, s.totalUnits(), s.totalBill());
            grandTotal += s.totalBill();
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Total mess income: " + grandTotal);
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        System.out.println("===== HOSTEL MESS MANAGEMENT SYSTEM =====");
        System.out.println("Rates: Breakfast = " + BREAKFAST_PRICE + ", Dinner = " + DINNER_PRICE + " (per day)");

        while (true) {
            System.out.println("\n1. Register student");
            System.out.println("2. Add more meal days");
            System.out.println("3. View student bill");
            System.out.println("4. Show all students & total income");
            System.out.println("5. Exit");
            int choice = readInt("Choice: ", 1, 5);

            switch (choice) {
                case 1: registerStudent(); break;
                case 2: addMoreDays(); break;
                case 3: viewBill(); break;
                case 4: showAllStudents(); break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}