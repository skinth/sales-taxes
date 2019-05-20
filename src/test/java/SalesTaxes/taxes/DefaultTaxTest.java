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
package SalesTaxes.taxes;

import SalesTaxes.products.Book;
import SalesTaxes.products.Food;
import SalesTaxes.products.Medicine;
import SalesTaxes.products.Product;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DefaultTaxTest {

    private DefaultTax taxer;

    @Before public void createTaxer() {
        taxer = new DefaultTax();
        taxer.addTaxFree(Book.class);
        taxer.addTaxFree(Medicine.class);
        taxer.addTaxFree(Food.class);
    }

    @Test public void testCalculateDefaultTax() {
        Product p = new Product("a blackboard", 7.98);
        assertEquals(0.80, taxer.calculateTax(p).doubleValue(), 0);
    }

    @Test public void testCalculateDefaultTaxExempt() {
        Product p = new Book("a book", 7.98, "MyBook", "MyAuthor", "123567890123");
        assertEquals(0.00, taxer.calculateTax(p).doubleValue(),0);
    }

}
