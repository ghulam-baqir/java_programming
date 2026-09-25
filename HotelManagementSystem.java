import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Simple Hotel Management System (Console-based)
 * Features: Add rooms, Book room, Checkout, View all rooms, View bill
 */

class Room {
    int roomNumber;
    String roomType;   // Single, Double, Deluxe
    double pricePerNight;
    boolean isBooked;
    String guestName;
    int daysStayed;

    Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
        this.guestName = null;
        this.daysStayed = 0;
    }

    void bookRoom(String guestName, int days) {
        this.isBooked = true;
        this.guestName = guestName;
        this.daysStayed = days;
    }

    void checkout() {
        this.isBooked = false;
        this.guestName = null;
        this.daysStayed = 0;
    }

    double calculateBill() {
        return pricePerNight * daysStayed;
    }

    void display() {
        System.out.println("Room No: " + roomNumber +
                " | Type: " + roomType +
                " | Price/Night: " + pricePerNight +
                " | Status: " + (isBooked ? "Booked by " + guestName + " (" + daysStayed + " days)" : "Available"));
    }
}

class Hotel {
    List<Room> rooms = new ArrayList<>();

    void addRoom(Room room) {
        rooms.add(room);
    }

    Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                return room;
            }
        }
        return null;
    }

    void bookRoom(int roomNumber, String guestName, int days) {
        Room room = findRoom(roomNumber);
        if (room == null) {
            System.out.println("Room not found!");
        } else if (room.isBooked) {
            System.out.println("Room " + roomNumber + " is already booked.");
        } else {
            room.bookRoom(guestName, days);
            System.out.println("Room " + roomNumber + " successfully booked for " + guestName + ".");
        }
    }

    void checkoutRoom(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room == null) {
            System.out.println("Room not found!");
        } else if (!room.isBooked) {
            System.out.println("Room " + roomNumber + " is not booked.");
        } else {
            double bill = room.calculateBill();
            System.out.println("Guest: " + room.guestName +
                    " | Days Stayed: " + room.daysStayed +
                    " | Total Bill: Rs. " + bill);
            room.checkout();
            System.out.println("Room " + roomNumber + " checked out successfully.");
        }
    }

    void showAllRooms() {
        System.out.println("\n---- Room Status ----");
        for (Room room : rooms) {
            room.display();
        }
    }
}

public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);

        // Preloaded rooms
        hotel.addRoom(new Room(101, "Single", 2000));
        hotel.addRoom(new Room(102, "Double", 3500));
        hotel.addRoom(new Room(103, "Deluxe", 5000));
        hotel.addRoom(new Room(104, "Single", 2000));

        int choice;
        do {
            System.out.println("\n===== Hotel Management System =====");
            System.out.println("1. Show All Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Checkout a Room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAllRooms();
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int bookRoomNo = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Guest Name: ");
                    String guestName = sc.nextLine();
                    System.out.print("Enter Number of Days: ");
                    int days = sc.nextInt();
                    hotel.bookRoom(bookRoomNo, guestName, days);
                    break;

                case 3:
                    System.out.print("Enter Room Number to Checkout: ");
                    int checkoutRoomNo = sc.nextInt();
                    hotel.checkoutRoom(checkoutRoomNo);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}