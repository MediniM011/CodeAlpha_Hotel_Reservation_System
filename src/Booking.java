public class Booking {
    private Customer customer;
    private Room room;
    private int numberOfNights;

    public Booking(Customer customer, Room room, int numberOfNights) {
        this.customer = customer;
        this.room = room;
        this.numberOfNights = numberOfNights;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }
}