package SalesTaxes.products;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FoodTest extends ProductTest {

    @Before public void createFood() {
        product = new Food("a chocolate bar", 12.99, true, "dessert");
    }

    @Test public void isFood() {
        assertTrue(product instanceof Food);
    }

    @Test public void testFoodCategory() {
        assertEquals(((Food)product).getCategory(), "dessert");
    }

}
