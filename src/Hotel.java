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

    public void bookRoom(int roomNumber, Customer customer) {
        for (Room room : rooms) {
            if (room.isBooked()) {
                System.out.println("Sorry, this room is already booked. ");
                return;
            }

            Booking booking = new Booking(customer, room);

            bookings.add(booking);
            room.setBooked(true);

            System.out.println("Room booked successfully!");
            System.out.println("Room Number:" + room.getRoomNumber());
            System.out.println("Customer:" + customer.getName());

            return;
        }
        System.out.println("Room not found");
    }
}