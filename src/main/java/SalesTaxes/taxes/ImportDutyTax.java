/*
    Copyright (C) 2019 Stefano Salvagni

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

public class ImportDutyTax extends SalesTax {

    public ImportDutyTax() {
        this.rate = SalesTax.DUTY_IMPORT_RATE;
    }

    public ImportDutyTax(int rate) {
        this.rate = rate;
    }

    @Override
    public boolean hasToApply(Product p) {
        return p.isImported();
    }

}
