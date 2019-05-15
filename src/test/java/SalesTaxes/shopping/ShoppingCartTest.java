/*
    This file is part of SalesTaxes.

    SalesTaxes is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    SalesTaxes is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SalesTaxes.  If not, see <https://www.gnu.org/licenses/>.
 */
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
