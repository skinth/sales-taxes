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
package SalesTaxes;

import SalesTaxes.products.Book;
import SalesTaxes.products.Food;
import SalesTaxes.products.Product;
import SalesTaxes.products.ProductTest;
import SalesTaxes.shopping.Shopping;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AppTest {

    App app;

    @Before
    public void createApp() {
        app = new App();
    }

    @Test
    public void testApp() {
        assertNotNull(app.getCashRegister());
        assertEquals(2, app.getCashRegister().getTaxCollectors().length);
    }

    @Test
    public void testInputOne() {
        Map<Product.ProductType, String[]> ss = new LinkedHashMap<>() {{
            put(Product.ProductType.Book, new String[] {"2 book at 12.49"});
            put(Product.ProductType.Other, new String[] {"1 music CD at 14.99"});
            put(Product.ProductType.Food, new String[] {"1 chocolate bar at 0.85"});
        }};
        Shopping shopping = app.doShopping(ss);
        assertEquals(42.32, shopping.getTotal().doubleValue(), 0);
        assertEquals(1.50, shopping.getTotalTaxes().doubleValue(), 0);
        assertEquals(24.98, shopping.getPurchasedProducts().get(0).getFinalPrice(), 0);
        assertEquals(16.49, shopping.getPurchasedProducts().get(1).getFinalPrice(), 0);
        assertEquals(0.85, shopping.getPurchasedProducts().get(2).getFinalPrice(), 0);
    }

    @Test
    public void testInputTwo() {
        Map<Product.ProductType, String[]> ss = new LinkedHashMap<>() {{
            put(Product.ProductType.Food, new String[] {"1 imported box of chocolates at 10.00"});
            put(Product.ProductType.Other, new String[] {"1 imported bottle of perfume at 47.50"});
        }};
        Shopping shopping = app.doShopping(ss);
        assertEquals(65.15, shopping.getTotal().doubleValue(), 0);
        assertEquals(7.65, shopping.getTotalTaxes().doubleValue(), 0);
        assertEquals(10.50, shopping.getPurchasedProducts().get(0).getFinalPrice(), 0);
        assertEquals(54.65, shopping.getPurchasedProducts().get(1).getFinalPrice(), 0);
    }

    @Test
    public void testInputThree() {
        Map<Product.ProductType, String[]> ss = new LinkedHashMap<>() {{
            put(Product.ProductType.Other, new String[] {"1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99"});
            put(Product.ProductType.Medicine,  new String[] {"1 packet of headache pills at 9.75"});
            put(Product.ProductType.Food,  new String[] {"3 box of imported chocolates at 11.25"});
        }};
        Shopping shopping = app.doShopping(ss);
        assertEquals(98.38, shopping.getTotal().doubleValue(), 0);
        assertEquals(7.90, shopping.getTotalTaxes().doubleValue(), 0);
        assertEquals(32.19, shopping.getPurchasedProducts().get(0).getFinalPrice(), 0);
        assertEquals(20.89, shopping.getPurchasedProducts().get(1).getFinalPrice(), 0);
        assertEquals(9.75, shopping.getPurchasedProducts().get(2).getFinalPrice(), 0);
        assertEquals(35.55, shopping.getPurchasedProducts().get(3).getFinalPrice(), 0);
    }
}
