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
