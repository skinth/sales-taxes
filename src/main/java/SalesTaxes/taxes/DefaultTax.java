package SalesTaxes.taxes;

import SalesTaxes.products.Book;
import SalesTaxes.products.Food;
import SalesTaxes.products.Medicine;
import SalesTaxes.products.Product;

import java.util.ArrayList;
import java.util.List;

public class DefaultTax extends SalesTax {

    private final List<Class> taxFree = new ArrayList<>() {
        {
            add(Book.class);
            add(Medicine.class);
            add(Food.class);
        }
    };

    public DefaultTax() {
        this.rate = DEFAULT_RATE;
    }

    public DefaultTax(int rate) {
        this.rate = rate;
    }

    @Override
    public boolean hasToApply(Product p) {
        return !this.taxFree.contains(p.getClass());
    }

}
