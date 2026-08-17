public class Main {
    public static void main(String[] args) {

        Room room = new Room(101, "Deluxe", 2500);

        System.out.println("Room Number:" + room.getRoomNumber());
        System.out.println("Room Type:" + room.getRoomType());
        System.out.println("Price:" + room.getPrice());
        System.out.println("Booked:" + room.isBooked());

        room.setBooked(true);
        System.out.println("After Booking:" + room.isBooked());
    }
}