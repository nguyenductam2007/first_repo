
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food extends Product {
    private LocalDate expirationDate;

    public Food(String name, double basePrice, LocalDate expirationDate) {
        super(name, basePrice);
        this.expirationDate = expirationDate;
    }

    @Override
    public double getFinalPrice() {
        LocalDate today = LocalDate.now();

        long daysUntilExpiration = ChronoUnit.DAYS.between(today, expirationDate);

        if (daysUntilExpiration >= 0 && daysUntilExpiration < 7) {
            return basePrice * 0.8;
        }

        return basePrice;
    }

    @Override
    public String getType() {
        return "Food";
    }
}