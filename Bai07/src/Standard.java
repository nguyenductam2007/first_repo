
public class Standard extends Room {

    public Standard(int nights) {
        super(nights, 500000);
    }

    @Override
    public double calculateTotal() {
        double total = nights * pricePerNight;

        if (nights > 3) {
            total = total * 0.95;
        }
        return total;
    }
}