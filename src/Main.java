public class Main {
    public static void main(String[] args) {

        Room room = new Room(101, "Deluxe", 2500);

        System.out.println("Room Number:" + room.getRoomNumber());
        System.out.println("Room Type:" + room.getRoomType());
        System.out.println("Price:" + room.getPrice());
        System.out.println("Booked:" + room.isBooked());

        room.setBooked(true);
        System.out.println("After Booking:" + room.isBooked());

        Customer customer = new Customer("Medini", "7665477976", "medini@gmail.com");

        System.out.println("-----------------------");
        System.out.println("Name:" + customer.getName());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Email: " + customer.getEmail());

        Hotel hotel = new Hotel();
        hotel.bookRoom(103, customer);
        System.out.println("\nAfter booking:");
        hotel.viewAvailableRooms();

    }
}