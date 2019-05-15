package SalesTaxes.utils;

import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

public class CurrencyUtilsTest {

    @Test public void testRoundUpToNearest() {
        BigDecimal num = new BigDecimal(12.23);
        assertEquals(num.compareTo(CurrencyUtils.roundUpToNearest(num, 0.05)), -1);
    }

}
