// File: Product.java
public class Product {
    protected String id;
    protected String name;
    protected double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.id = "UNKNOWN";
    }

    public double getFinalPrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return "Product";
    }
}