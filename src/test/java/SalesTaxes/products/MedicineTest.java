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

public class MedicineTest extends ProductTest {

    @Before public void createMedicine() {
        product = new Medicine("box of pills", 12.99, false,
                    "Angelini", "Tachipirina", "Paracetamolo");
    }

    @Test public void isMedicine() {
        assertTrue(product instanceof Medicine);
    }

    @Test public void testMedicineName() {
        assertTrue(((Medicine)product).getName().contains("Tachipirina"));
    }

}
