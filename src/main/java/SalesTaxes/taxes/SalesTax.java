package SalesTaxes.taxes;

import SalesTaxes.products.Product;
import SalesTaxes.utils.CurrencyUtils;

import java.math.BigDecimal;

public abstract class SalesTax {

    public final static int DEFAULT_RATE = 10;
    public final static int DUTY_IMPORT_RATE = 5;

    protected int rate;

    public BigDecimal calculateTax(Product product) {
        BigDecimal tax = new BigDecimal(0.0);
        if (hasToApply(product)) {
            //tax = shelfPrice * rate / 100
            BigDecimal basePrice = new BigDecimal(product.getShelfPrice());
            tax = basePrice.multiply(new BigDecimal(this.rate).divide(new BigDecimal(100)));
            //round up to nearest 0.05
            tax = CurrencyUtils.roundUpToNearest(tax, 0.05);
        }

        return tax;
    }

    protected abstract boolean hasToApply(Product product);

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
