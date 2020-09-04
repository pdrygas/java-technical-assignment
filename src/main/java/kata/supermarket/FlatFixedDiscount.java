package kata.supermarket;

import java.math.BigDecimal;
import java.util.Collection;

public class FlatFixedDiscount implements Discount {
    private final BigDecimal fixedAmount;

    public FlatFixedDiscount(BigDecimal fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    @Override
    public BigDecimal apply(Collection<Item> items) {
        return fixedAmount;
    }
}
