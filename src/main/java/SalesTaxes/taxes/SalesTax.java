/*
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
