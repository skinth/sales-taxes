package SalesTaxes.taxes;

import SalesTaxes.products.Product;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DefaultTaxTest {

    private SalesTax taxer;

    @Before public void createTaxer() {
        taxer = new DefaultTax();
    }

    @Test public void testCalculateDefaultTax() {
        Product p = new Product("a blackboard", 7.98, false);
        assertEquals(taxer.calculateTax(p).doubleValue(), 0.80, 0);
    }

}
