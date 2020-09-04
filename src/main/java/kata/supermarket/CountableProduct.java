package kata.supermarket;

import java.math.BigDecimal;

public class CountableProduct {

    private final BigDecimal pricePerUnit;

    public CountableProduct(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}
