import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public Hotel() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 1500));
        rooms.add(new Room(102, "Single", 1500));
        rooms.add(new Room(103, "Double", 2000));
        rooms.add(new Room(104, "Double", 2000));
        rooms.add(new Room(105, "Deluxe", 3000));
    }

    public void viewAvailableRooms() {

        System.out.println("\n===== AVAILABLE ROOMS =====");

        boolean available = false;

        for (Room room : rooms) {

            if (!room.isBooked()) {

                System.out.println(
                        "Room: " + room.getRoomNumber()
                                + " | Type: " + room.getRoomType()
                                + " | Price: ₹" + room.getPrice());

                available = true;
            }
        }

        if (!available) {
            System.out.println("No rooms are currently available.");
        }
    }

    public void bookRoom(int roomNumber, Customer customer, int numberOfNights) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.isBooked()) {
                    System.out.println("Sorry, this room is already booked. ");
                    return;
                }

                Booking booking = new Booking(customer, room, numberOfNights);

                bookings.add(booking);
                room.setBooked(true);

                System.out.println("Room booked successfully!");
                System.out.println("Room Number:" + room.getRoomNumber());
                System.out.println("Customer:" + customer.getName());

                return;
            }
        }
        System.out.println("Room not found");
    }

    public void viewBookings() {
        System.out.println("\n------ CURRENT BOOKINGS ------");

        if (bookings.isEmpty()) {
            System.out.println("No bookingd found.");
            return;
        }
        for (Booking booking : bookings) {
            Customer customer = booking.getCustomer();
            Room room = booking.getRoom();
            System.out.println("Room Number: " + room.getRoomNumber());
            System.out.println("Room Type: " + room.getRoomType());
            System.out.println("Price: ₹" + room.getPrice());
            System.out.println("Customer: " + customer.getName());
            System.out.println("Phone: " + customer.getPhone());
            System.out.println("Email: " + customer.getEmail());

            System.out.println("-----------------------");

        }
    }

    public void cancelBooking(int roomNumber) {
        for (Booking booking : bookings) {
            Room room = booking.getRoom();
            if (room.getRoomNumber() == roomNumber) {
                room.setBooked(false);
                bookings.remove(booking);
                System.out.println("Booking cancelled successfully.");
                System.out.println("Room" + roomNumber + "is now availabe.");
                return;
            }
        }
        System.out.println("No booking found for room " + roomNumber);
    }

    public void generateBill(int roomNumber) {

        for (Booking booking : bookings) {

            Room room = booking.getRoom();
            Customer customer = booking.getCustomer();

            if (room.getRoomNumber() == roomNumber) {

                double billAmount = room.getPrice();

                System.out.println("\n===== HOTEL BILL =====");
                System.out.println("Customer Name : " + customer.getName());
                System.out.println("Phone         : " + customer.getPhone());
                System.out.println("Email         : " + customer.getEmail());
                System.out.println("Room Number   : " + room.getRoomNumber());
                System.out.println("Room Type     : " + room.getRoomType());
                System.out.println("Room Price    : ₹" + room.getPrice());
                System.out.println("-----------------------------");
                System.out.println("Total Bill    : ₹" + billAmount);
                System.out.println("=============================");

                return;
            }
        }

        System.out.println("No booking found for Room " + roomNumber);
    }

    public boolean roomExists(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return true;
            }
        }
        return false;
    }
}