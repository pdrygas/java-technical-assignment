package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class SimpleDiscountCalculator implements DiscountCalculator {
    public SimpleDiscountCalculator() {
    }

    @Override
    public BigDecimal calculate(List<Discount> discounts, List<Item> items) {
        return discounts.stream()
                .map(d -> d.apply(items))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }
}