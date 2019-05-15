package SalesTaxes.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyUtils {

    public static BigDecimal roundUpToNearest(BigDecimal value, double factor) {
        //round up value to the nearest factor
        //new_value = ceil(value/factor) * factor
        BigDecimal scale = new BigDecimal(factor);
        BigDecimal quotient = value.divide(scale, 0, RoundingMode.CEILING);
        BigDecimal product = quotient.multiply(scale);
        return product.setScale(2, RoundingMode.FLOOR);
    }
}
