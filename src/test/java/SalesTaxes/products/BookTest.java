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
