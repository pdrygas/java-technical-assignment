package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

interface DiscountCalculator {
    BigDecimal calculate(List<Discount> discounts, List<Item> items);
}
