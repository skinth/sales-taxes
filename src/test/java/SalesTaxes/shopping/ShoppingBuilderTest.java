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

import static org.junit.Assert.*;

import SalesTaxes.products.Food;
import SalesTaxes.products.Medicine;
import SalesTaxes.products.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBuilderTest {

    private IShoppingBuilder builder;
    private Shopping shopping;

    @Before public void createShoppingBuilder() {
        List<Product> products = new ArrayList<>() {{
           add(new Product("a black pen", 0.79, false));
           add(new Food("a cup of damn good coffee", 1.16, false, "drinks"));
           add(new Medicine("a bottle of antibiotic spray", 8.60, false,
                   "Mylan", "Froben", "Flubiprofene"));
        }};
        builder = ShoppingBuilder.getMe();
        for (Product p : products) {
            builder.purchase(p, 2);
        }
        shopping = builder.build();
    }

    @Test public void testShoppingBuilderCreateShopping() {
        assertTrue(shopping instanceof Shopping);
    }

    @Test public void testShoppingListSizeWithBuilder() {
        assertEquals(6, shopping.getListSize());
    }

}
