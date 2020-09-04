package kata.supermarket;

import java.math.BigDecimal;

public class CountableProduct extends Product {

    private final BigDecimal pricePerUnit;

    public CountableProduct(final BigDecimal pricePerUnit) {
        this(pricePerUnit, Category.noCategory());
    }

    public CountableProduct(final BigDecimal pricePerUnit, final Category category) {
        super(category);
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }
}
