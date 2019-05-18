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

import SalesTaxes.products.Food;
import SalesTaxes.products.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImportDutyTaxTest {

    private ImportDutyTax taxer;

    @Before public void createTaxer() {
        taxer = new ImportDutyTax();
    }

    @Test public void testCalculateImportDutyTax() {
        Product p = new Food("pizza", 5.44, true, "pizza");
        assertEquals(0.30, taxer.calculateTax(p).doubleValue(), 0);
    }

    @Test public void testCalculateImportDutyTaxExempt() {
        Product p = new Food("pizza", 5.44, false, "pizza");
        assertEquals(0.00, taxer.calculateTax(p).doubleValue(), 0);
    }

}
