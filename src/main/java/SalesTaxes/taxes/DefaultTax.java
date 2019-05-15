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
