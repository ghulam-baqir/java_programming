import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    static class Book {
        int id;
        String title;
        String author;
        boolean issued = false;
        String issuedTo = "";

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        void display() {
            String status = issued ? "Issued to " + issuedTo : "Available";
            System.out.println(id + " | " + title + " | " + author + " | " + status);
        }
    }

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // clear leftover newline

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: searchBook(); break;
                case 4: issueBook(); break;
                case 5: returnBook(); break;
                case 6: deleteBook(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static Book findById(int id) {
        for (Book b : books) {
            if (b.id == id) return b;
        }
        return null;
    }

    static void addBook() {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (findById(id) != null) {
            System.out.println("This ID already exists.");
            return;
        }
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("ID | Title | Author | Status");
        for (Book b : books) b.display();
    }

    static void searchBook() {
        System.out.print("Title (or part of it): ");
        String key = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Book b : books) {
            if (b.title.toLowerCase().contains(key)) {
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("No books found.");
    }

    static void issueBook() {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Book b = findById(id);
        if (b == null) {
            System.out.println("Book not found.");
        } else if (b.issued) {
            System.out.println("This book is already issued.");
        } else {
            System.out.print("Member name: ");
            b.issuedTo = sc.nextLine();
            b.issued = true;
            System.out.println("Book issued successfully.");
        }
    }

    static void returnBook() {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Book b = findById(id);
        if (b == null) {
            System.out.println("Book not found.");
        } else if (!b.issued) {
            System.out.println("This book is not currently issued.");
        } else {
            b.issued = false;
            b.issuedTo = "";
            System.out.println("Book returned successfully.");
        }
    }

    static void deleteBook() {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Book b = findById(id);
        if (b == null) {
            System.out.println("Book not found.");
        } else {
            books.remove(b);
            System.out.println("Book deleted successfully.");
        }
    }
}