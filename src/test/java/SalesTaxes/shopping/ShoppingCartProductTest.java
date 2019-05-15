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
