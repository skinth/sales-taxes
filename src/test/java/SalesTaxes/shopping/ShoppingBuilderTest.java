package SalesTaxes.shopping;

import static org.junit.Assert.*;

import SalesTaxes.products.Food;
import SalesTaxes.products.Medicine;
import SalesTaxes.products.Product;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBuilderTest {

    private IShoppingBuilder builder;
    private Shopping shopping;

    @Before public void createShoppingBuilder() {
        List<Product> products = new ArrayList<>() {{
           add(new Product("a black pen", 0.79, false));
           add(new Food("a cup of damn good coffee", 1.16, false, "drinks"));
           add(new Medicine("a bottle of antibiotic spray", 8.60, false,
                   "Mylan", "Froben", "Flubiprofene"));
        }};
        builder = new ShoppingBuilder();
        for (Product p : products) {
            builder.purchase(p, 2);
        }
        shopping = builder.build();
    }

    @Test public void testShoppingBuilderCreateShopping() {
        assertTrue(shopping instanceof Shopping);
    }

    @Test public void testShoppingListSizeWithBuilder() {
        assertEquals(shopping.getListSize(), 6);
    }

}
