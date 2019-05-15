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
