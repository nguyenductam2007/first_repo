
public class Electronics extends Product {
    private double warrantyFee;

    public Electronics(String name, double basePrice, double warrantyFee) {
        super(name, basePrice);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double getFinalPrice() {
        double vat = basePrice * 0.10;
        return basePrice + vat + warrantyFee;
    }

    @Override
    public String getType() {
        return "Electronics";
    }
}