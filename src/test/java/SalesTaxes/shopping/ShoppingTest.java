/*
    Copyright (C) 2019 Stefano Salvagni

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

public class ShoppingTest {

    private Shopping cart;

    @Before public void createShopping() {
        cart = new Shopping();
        Product p = new Product("a DVD", 21.34);
        PurchasedProduct purchProduct = new PurchasedProduct(p,2);
        cart.putIn(purchProduct);
        p = new Product("a imported PC", 499.23);
        purchProduct = new PurchasedProduct(p, 1);
        cart.putIn(purchProduct);
    }

    @Test public void testShoppingListSize() {
        assertEquals(3, cart.getListSize());
    }

    @Test public void testRemoveByIndex() {
        assertTrue(cart.remove(1) instanceof PurchasedProduct);
    }

    @Test public void testEmptyCart() {
        cart.removeAll();
        assertEquals(0, cart.getListSize());
    }

}
