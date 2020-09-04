package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleDiscountCalculatorTest {
    private SimpleDiscountCalculator calculator;

    @Test
    void singleFixedDiscountApplies() {
        List<Item> items = Arrays.asList(new CountableProduct(new BigDecimal(35.00)).oneOf());
        List<Discount> discounts = Arrays.asList(new FlatFixedDiscount(new BigDecimal(10.00)));

        DiscountCalculator calculator = new SimpleDiscountCalculator();

        assertEquals(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_DOWN), calculator.calculate(discounts, items));
    }
}