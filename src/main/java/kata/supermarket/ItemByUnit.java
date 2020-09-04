package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final CountableProduct countableProduct;

    ItemByUnit(final CountableProduct countableProduct) {
        this.countableProduct = countableProduct;
    }

    public BigDecimal price() {
        return countableProduct.pricePerUnit();
    }

    @Override
    public Product of() {
        return countableProduct;
    }
}
