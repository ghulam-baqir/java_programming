
import java.util.Scanner;

class MovieList {

    class Node {
        String movieName;
        Node next;

        Node(String movieName) {
            this.movieName = movieName;
            this.next = null;
        }
    }

    Node head;
    int count = 0;

    public void addMovie(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        count++;
        System.out.println("Movie added successfully!");
    }

    public void displayMovies() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }

        Node current = head;
        int i = 1;

        System.out.println("\nAvailable Movies:");

        while (current != null) {
            System.out.println(i + ". " + current.movieName);
            current = current.next;
            i++;
        }
    }

    public void searchMovie(String name) {
        Node current = head;

        while (current != null) {
            if (current.movieName.equalsIgnoreCase(name)) {
                System.out.println("Movie found: " + current.movieName);
                return;
            }

            current = current.next;
        }

        System.out.println("Movie not found.");
    }

    public void removeMovie(String name) {
        if (head == null) {
            System.out.println("Cinema list is empty.");
            return;
        }

        if (head.movieName.equalsIgnoreCase(name)) {
            head = head.next;
            count--;
            System.out.println("Movie removed successfully!");
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.movieName.equalsIgnoreCase(name)) {
                current.next = current.next.next;
                count--;
                System.out.println("Movie removed successfully!");
                return;
            }

            current = current.next;
        }

        System.out.println("Movie not found.");
    }

    public void totalMovies() {
        System.out.println("Total movies: " + count);
    }
}

public class Cinema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieList cinema = new MovieList();

        int choice;

        do {
            System.out.println("\n===== CINEMA MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Movie");
            System.out.println("2. Display Movies");
            System.out.println("3. Search Movie");
            System.out.println("4. Remove Movie");
            System.out.println("5. Total Movies");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter movie name: ");
                    String addName = sc.nextLine();
                    cinema.addMovie(addName);
                    break;

                case 2:
                    cinema.displayMovies();
                    break;

                case 3:
                    System.out.print("Enter movie name to search: ");
                    String searchName = sc.nextLine();
                    cinema.searchMovie(searchName);
                    break;

                case 4:
                    System.out.print("Enter movie name to remove: ");
                    String removeName = sc.nextLine();
                    cinema.removeMovie(removeName);
                    break;

                case 5:
                    cinema.totalMovies();
                    break;

                case 0:
                    System.out.println("Exiting Cinema System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
