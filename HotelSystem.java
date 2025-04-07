import java.util.*;

class Room {
    int roomNumber;
    String type;
    boolean isAvailable = true;
    int price;

    Room(int number, String type, int price) {
        this.roomNumber = number;
        this.type = type;
        this.price = price;
    }

    public String toString() {
        return "Room " + roomNumber + " (" + type + ") - Rs." + price + " - " + (isAvailable ? "Available" : "Booked");
    }
}

class Reservation {
    String customerName;
    Room room;

    Reservation(String name, Room room) {
        this.customerName = name;
        this.room = room;
        room.isAvailable = false;
    }

    public String toString() {
        return customerName + " reserved " + room.toString();
    }
}

public class HotelSystem {
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize rooms
        rooms.add(new Room(101, "Single", 1000));
        rooms.add(new Room(102, "Double", 2000)); 
        rooms.add(new Room(103, "Deluxe", 3000)); 

        while (true) {
            System.out.println("\n1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    static void viewAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room);
            }
        }
    }

    static void makeReservation() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter room type (Single/Double/Deluxe): ");
        String type = scanner.nextLine();

        for (Room room : rooms) {
            if (room.type.equalsIgnoreCase(type) && room.isAvailable) {
                System.out.println("Room found: " + room);
                System.out.println("Total amount: Rs." + room.price);

                System.out.print("Do you want to proceed with payment? (yes/no): ");
                String proceed = scanner.nextLine();

                if (!proceed.equalsIgnoreCase("yes")) {
                    System.out.println("Reservation cancelled.");
                    return;
                }

                // Payment mode selection
                System.out.println("Select Payment Mode:");
                System.out.println("1. UPI");
                System.out.println("2. Credit/Debit Card");
                System.out.println("3. Net Banking");
                System.out.print("Enter choice: ");
                int mode = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (mode) {
                    case 1:
                        System.out.print("Enter UPI ID: ");
                        scanner.nextLine(); // Simulate UPI ID input
                        break;
                    case 2:
                        System.out.print("Enter Card Number: ");
                        scanner.nextLine();
                        System.out.print("Enter CVV: ");
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.print("Enter Bank Name: ");
                        scanner.nextLine();
                        System.out.print("Enter User ID: ");
                        scanner.nextLine();
                        break;
                    default:
                        System.out.println("Invalid payment mode. Reservation cancelled.");
                        return;
                }

                // Simulate payment delay
                System.out.println("Processing payment...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Payment error.");
                }

                System.out.println("Payment successful! Booking confirmed.");
                reservations.add(new Reservation(name, room));
                return;
            }
        }

        System.out.println("No available rooms of that type.");
    }

    static void viewReservations() {
        System.out.println("\n--- Reservations ---");
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }
}
