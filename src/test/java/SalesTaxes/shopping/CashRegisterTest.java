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

import static org.junit.Assert.*;

import SalesTaxes.products.Book;
import SalesTaxes.products.Food;
import SalesTaxes.products.Medicine;
import SalesTaxes.products.Product;
import SalesTaxes.taxes.DefaultTax;
import SalesTaxes.taxes.ImportDutyTax;
import SalesTaxes.taxes.SalesTax;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CashRegisterTest {

    private CashRegister cash;

    @Before
    public void createCashRegister() {
        SalesTax taxCollectors[] = {new DefaultTax(SalesTax.DEFAULT_RATE, new ArrayList<Class>() {{
            add(Book.class);
            add(Food.class);
            add(Medicine.class);
        }}), new ImportDutyTax()};
        cash = new CashRegister(taxCollectors);
    }

    @Test
    public void testInputOne() {
        ShoppingBuilder shoppingBuilder = ShoppingBuilder.getMe();
        Shopping shopping = shoppingBuilder
                .purchase(new Book("book", 12.49, false), 2)
                .purchase(new Product("music CD", 14.99, false), 1)
                .purchase(new Food("chocolate bar", 0.85, false), 1)
                .build();
        List<String> listR = cash.printReceipt(shopping);
        assertEquals(24.98, Double.parseDouble(listR.get(1).split(":")[1]), 0);
        assertEquals(16.49, Double.parseDouble(listR.get(2).split(":")[1]), 0);
        assertEquals(0.85, Double.parseDouble(listR.get(3).split(":")[1]), 0);
        assertEquals(1.50, Double.parseDouble(listR.get(4).split(":")[1]), 0);
        assertEquals(42.32, Double.parseDouble(listR.get(listR.size()-1).split(":")[1]), 0);
    }

    @Test
    public void testInputTwo() {
        ShoppingBuilder shoppingBuilder = ShoppingBuilder.getMe();
        Shopping shopping = shoppingBuilder
                .purchase(new Food("imported box of chocolates", 10.00, true), 1)
                .purchase(new Product("imported bottle of perfume", 47.50, true), 1)
                .build();
        List<String> listR = cash.printReceipt(shopping);
        assertEquals(10.50, Double.parseDouble(listR.get(1).split(":")[1]), 0);
        assertEquals(54.65, Double.parseDouble(listR.get(2).split(":")[1]), 0);
        assertEquals(7.65, Double.parseDouble(listR.get(3).split(":")[1]), 0);
        assertEquals(65.15, Double.parseDouble(listR.get(listR.size()-1).split(":")[1]), 0);
    }

    @Test
    public void testInputThree() {
        ShoppingBuilder shoppingBuilder = ShoppingBuilder.getMe();
        Shopping shopping = shoppingBuilder
                .purchase(new Product("imported bottle of perfume", 27.99, true), 1)
                .purchase(new Product("bottle of perfume", 18.99, false), 1)
                .purchase(new Medicine("packet of headache pills", 9.75, false), 1)
                .purchase(new Food("box of imported cholates", 11.25, true), 3)
                .build();
        List<String> listR = cash.printReceipt(shopping);
        assertEquals(32.19, Double.parseDouble(listR.get(1).split(":")[1]), 0);
        assertEquals(20.89, Double.parseDouble(listR.get(2).split(":")[1]), 0);
        assertEquals(9.75, Double.parseDouble(listR.get(3).split(":")[1]), 0);
        assertEquals(35.55, Double.parseDouble(listR.get(4).split(":")[1]), 0);
        assertEquals(7.90, Double.parseDouble(listR.get(5).split(":")[1]), 0);
        assertEquals(98.38, Double.parseDouble(listR.get(listR.size()-1).split(":")[1]), 0);
    }

}
