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
import java.util.ArrayList;
import java.util.List;

public class DefaultTax extends SalesTax {

    private List<Class> taxFree;

    public DefaultTax() {
        this.rate = DEFAULT_RATE;
        this.taxFree = new ArrayList<>();
    }

    public DefaultTax(int rate) {
        this.rate = rate;
        this.taxFree = new ArrayList<>();
    }

    public DefaultTax(int rate, List<Class> taxFree) {
        this.rate = rate;
        this.taxFree = taxFree;
    }

    @Override
    public boolean hasToApply(Product p) {
        return !this.taxFree.contains(p.getClass());
    }

    public void setTaxFree(List<Class> taxFree) {
        this.taxFree = taxFree;
    }

    public void addTaxFree(Class c) {
        this.taxFree.add(c);
    }

    public boolean removeTaxFree(Class c) {
        return this.taxFree.remove(c);
    }

}
