package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct extends Product {

    private final BigDecimal pricePerKilo;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        this(pricePerKilo, Category.noCategory());
    }

    public WeighedProduct(final BigDecimal pricePerKilo, final Category category) {
        super(category);
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
