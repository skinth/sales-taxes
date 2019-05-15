package SalesTaxes.products;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test public void testProductCreation() {
        Product p = new Product();
        assertNotNull(p);
    }

    @Test public void testProductShelfPrice() {
        Product p = new Product("music CD", 12.99, false);
        assertEquals(p.getShelfPrice(), 12.99, 0);
    }
}
