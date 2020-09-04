package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;
    private final List<Discount> discounts;

    public Basket() {
        this.items = new ArrayList<>();
        this.discounts= new ArrayList<>();
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    List<Discount> discounts() {
        return Collections.unmodifiableList(discounts);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {
        private final DiscountCalculator discountCalculator;

        TotalCalculator() {
            this(new SimpleDiscountCalculator());
        }

        TotalCalculator(DiscountCalculator discountCalculator) {
            this.discountCalculator = discountCalculator;
        }

        private BigDecimal subtotal() {
            return items().stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        private BigDecimal calculateDiscount() {
            return discountCalculator.calculate(discounts(), items());
        }

        private BigDecimal calculate() {
            BigDecimal result = subtotal().subtract(calculateDiscount());
            return result.compareTo(BigDecimal.ZERO) > 0 ? result: BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN) ;
        }
    }
}
