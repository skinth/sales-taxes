package SalesTaxes.products;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    private Product defaultProduct;
    protected Product product;

    @Before public void createProduct() {
        defaultProduct = new Product();
        product = new Product("music CD", 12.99, false);
    }

    @Test public void testProductCreation() {
        assertNotNull(defaultProduct);
    }

    @Test public void testProductShelfPrice() {
        assertEquals(product.getShelfPrice(), 12.99, 0);
    }
}
