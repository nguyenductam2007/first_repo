public class Vip extends Room{
    public Vip(int nights){
        super(nights,2000000);
    }

    @Override
    public double calculateTotal() {
        return pricePerNight*nights;
    }
}
