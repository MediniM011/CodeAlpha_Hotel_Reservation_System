import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("     HOTEL RESERVATION SYSTEM");
            System.out.println("====================================");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");
            System.out.println("====================================");

            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid inpot! Please enter a number");
                scanner.next();
                System.out.println("Enter your choice:");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    hotel.viewAvailableRooms();
                    break;

                case 2:

                    System.out.println("\n===== BOOK A ROOM =====");

                    String name;
                    while (true) {
                        System.out.print("Enter customer name: ");
                        name = scanner.nextLine().trim();
                        if (!name.isEmpty()) {
                            break;
                        }
                        System.out.println("Name cannot be empty. Please try again.");
                    }

                    String phone;
                    while (true) {
                        System.out.print("Enter phone number:");
                        phone = scanner.nextLine().trim();
                        if (phone.matches("\\d{10}")) {
                            break;
                        }
                        System.out.println("Invaled phone number. Please enter exactly 10 digits.");
                    }

                    String email;
                    while (true) {
                        System.out.print("Enetr email:");
                        email = scanner.nextLine().trim();
                        if (email.matches("^[A-Z a-z 0-9 + _ .]+@[A-Za-z0-9.-]+$")) {
                            break;
                        }
                        System.out.println("Invalid email. Please enter a valid email address.");
                    }

                    int numberOfNights;
                    while (true) {
                        System.out.print("Enter number of nights:");
                        if (scanner.hasNextInt()) {
                            numberOfNights = scanner.nextInt();
                            if (numberOfNights > 0) {
                                break;
                            }
                            System.out.println("Number of nights must be greater than 0.");

                        } else {
                            System.out.println("Invalid input. please enter a valid number.");
                            scanner.next();
                        }
                    }

                    int roomNumber;
                    while (true) {
                        System.out.println("Enter room number:");
                        if (scanner.hasNextInt()) {
                            roomNumber = scanner.nextInt();
                            scanner.nextLine();

                            if (hotel.roomExists(roomNumber)) {
                                break;
                            }
                            System.out.println("Invalid room number. Please choose a valid room.");
                        } else {
                            System.out.println("Invalid input. Please enter a valid room number.");
                            scanner.next();
                        }
                    }
                    Customer customer = new Customer(name, phone, email);

                    hotel.bookRoom(roomNumber, customer, numberOfNights);

                    break;

                case 3:
                    hotel.viewBookings();
                    break;

                case 4:

                    System.out.println("\n===== CANCEL BOOKING =====");

                    System.out.print("Enter room number: ");
                    int cancelRoomNumber = scanner.nextInt();

                    hotel.cancelBooking(cancelRoomNumber);
                    break;

                case 5:

                    System.out.println("\n===== GENERATE BILL =====");

                    System.out.print("Enter room number: ");
                    int billRoomNumber = scanner.nextInt();

                    hotel.generateBill(billRoomNumber);
                    break;

                case 6:
                    System.out.println("\nThank you for using Hotel Reservation System!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}