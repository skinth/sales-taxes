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
package SalesTaxes.products;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookTest extends ProductTest {

    @Before public void createBook() {
        product = new Book("a book", 12.99, false, "Karamazov brothers", "Fedor M. Dostoevskij", "1234567890123");
    }

    @Test public void isBook() {
        assertTrue(product instanceof Book);
    }

    @Test public void testBookTitle() {
        assertTrue(((Book)product).getTitle().contains("Karamazov"));
    }

}
