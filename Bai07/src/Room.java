
public abstract class Room {
    protected int nights;
    protected double pricePerNight;

    public Room(int nights, double pricePerNight) {
        this.nights = nights;
        this.pricePerNight = pricePerNight;
    }


    public abstract double calculateTotal();
}