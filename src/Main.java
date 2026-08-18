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
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    hotel.viewAvailableRooms();
                    break;

                case 2:

                    System.out.println("\n===== BOOK A ROOM =====");

                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Customer customer = new Customer(name, phone, email);

                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();

                    hotel.bookRoom(roomNumber, customer);
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