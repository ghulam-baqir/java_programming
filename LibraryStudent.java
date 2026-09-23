import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryStudent {

    static class Record {
        String bookTitle;
        LocalDate borrowDate;
        LocalDate dueDate;
        LocalDate returnDate = null;

        Record(String bookTitle) {
            this.bookTitle = bookTitle;
            this.borrowDate = LocalDate.now();
            this.dueDate = borrowDate.plusDays(14);
        }

        boolean isReturned() {
            return returnDate != null;
        }

        String status() {
            if (isReturned()) return "Returned";
            if (LocalDate.now().isAfter(dueDate)) {
                long late = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
                return "Overdue (" + late + " days)";
            }
            return "Borrowed";
        }
    }

    static class Student {
        String rollNo;
        String name;
        String password;
        ArrayList<Record> records = new ArrayList<>();

        Student(String rollNo, String name, String password) {
            this.rollNo = rollNo;
            this.name = name;
            this.password = password;
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Library - Student Portal =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: register(); break;
                case 2: login(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // ---------- helpers ----------
    static int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Number enter !!");
            }
        }
    }

    static String readLine(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    static Student findStudent(String rollNo) {
        for (Student s : students) {
            if (s.rollNo.equalsIgnoreCase(rollNo)) return s;
        }
        return null;
    }

    // ---------- register & login ----------
    static void register() {
        String rollNo = readLine("Roll No: ");
        if (rollNo.isEmpty() || findStudent(rollNo) != null) {
            System.out.println("Rool No already exists or is empty.");
            return;
        }
        String name = readLine("Name: ");
        String pass = readLine("Password (min 4 chars): ");
        if (pass.length() < 4) {
            System.out.println("Password is too short .");
            return;
        }
        students.add(new Student(rollNo, name, pass));
        System.out.println("Registered! now login credentials .");
    }

    static void login() {
        String rollNo = readLine("Roll No: ");
        String pass = readLine("Password: ");
        Student s = findStudent(rollNo);
        if (s != null && s.password.equals(pass)) {
            System.out.println("\nWelcome, " + s.name + "!");
            studentMenu(s);
        } else {
            System.out.println("invalid roll no or password .");
        }
    }

    // ---------- student menu ----------
    static void studentMenu(Student s) {
        int choice;
        do {
            System.out.println("\n--- " + s.name + " (" + s.rollNo + ") ---");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. My Book Status");
            System.out.println("0. Logout");
            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: borrow(s); break;
                case 2: giveBack(s); break;
                case 3: showStatus(s); break;
                case 0: System.out.println("Logged out."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void borrow(Student s) {
        String title = readLine("Book title: ");
        if (title.isEmpty()) {
            System.out.println("Title can't be empty .");
            return;
        }
        Record r = new Record(title);
        s.records.add(r);
        System.out.println("Borrowed: " + title + " | Due date: " + r.dueDate);
    }

    static void giveBack(Student s) {
        ArrayList<Record> active = new ArrayList<>();
        for (Record r : s.records) {
            if (!r.isReturned()) active.add(r);
        }
        if (active.isEmpty()) {
            System.out.println("no book is borrowd yet .");
            return;
        }
        for (int i = 0; i < active.size(); i++) {
            System.out.println((i + 1) + ". " + active.get(i).bookTitle + " (Due: " + active.get(i).dueDate + ")");
        }
        int pick = readInt("which book want to return ! enter (number): ");
        if (pick < 1 || pick > active.size()) {
            System.out.println("Invalid number.");
            return;
        }
        Record r = active.get(pick - 1);
        r.returnDate = LocalDate.now();
        System.out.println("Returned: " + r.bookTitle);
    }

    static void showStatus(Student s) {
        if (s.records.isEmpty()) {
            System.out.println("still no book is borrowd .");
            return;
        }
        System.out.println("\nBook | Borrowed | Due | Returned | Status");
        for (Record r : s.records) {
            String ret = r.isReturned() ? r.returnDate.toString() : "-";
            System.out.println(r.bookTitle + " | " + r.borrowDate + " | " + r.dueDate + " | " + ret + " | " + r.status());
        }
    }
}