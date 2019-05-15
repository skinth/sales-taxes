package SalesTaxes.shopping;

import SalesTaxes.products.Product;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before public void createCart() {
        cart = new ShoppingCart();
        Product p = new Product("a DVD", 21.34, false);
        ShoppingCartProduct cartProduct = new ShoppingCartProduct(p,2);
        cart.putIn(cartProduct);
        p = new Product("a PC", 499.23, true);
        cartProduct = new ShoppingCartProduct(p, 1);
        cart.putIn(cartProduct);
    }

    @Test public void testCartSize() {
        assertEquals(cart.getSize(), 3);
    }

    @Test public void testRemoveByIndex() {
        assertTrue(cart.remove(1) instanceof ShoppingCartProduct);
    }

    @Test public void testEmptyCart() {
        cart.removeAll();
        assertEquals(cart.getSize(), 0);
    }

}
