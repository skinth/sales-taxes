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
        assertEquals(taxer.calculateTax(p).doubleValue(), 0.30, 0);
    }

}
