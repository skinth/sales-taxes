package SalesTaxes.shopping;

import SalesTaxes.products.Product;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartProductTest {

    private ShoppingCartProduct shoppingCartProduct;

    @Before public void createShoppingCartProduct() {
        Product musicCD = new Product("a music CD", 15.12, false);
        shoppingCartProduct = new ShoppingCartProduct(musicCD, 2);
    }

    @Test public void testQuantity() {
        assertEquals(shoppingCartProduct.getQuantity(), 2);
    }

    @Test public void testProduct() {
        assertTrue(shoppingCartProduct.getProduct() instanceof Product);
    }

}
