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

public class PurchasedProductTest {

    private PurchasedProduct purchasedProduct;

    @Before public void createPurchasedProduct() {
        Product musicCD = new Product("a music CD", 15.12);
        purchasedProduct = new PurchasedProduct(musicCD, 2);
    }

    @Test public void testQuantity() {
        assertEquals(2, purchasedProduct.getQuantity());
    }

    @Test public void testProduct() {
        assertTrue(purchasedProduct.getProduct() instanceof Product);
    }

}
