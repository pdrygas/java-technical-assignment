package kata.supermarket;

import java.math.BigDecimal;
import java.util.Collection;

interface Discount {
    BigDecimal apply(Collection<Item> items);
}
