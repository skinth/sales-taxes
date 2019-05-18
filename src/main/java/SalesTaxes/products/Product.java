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
package SalesTaxes.products;

import java.math.BigDecimal;

public class Product {

    protected String description;
    protected BigDecimal shelfPrice;
    protected boolean imported;

    public Product() {
        this.description = "AAA battery";
        this.shelfPrice = new BigDecimal(5.45);
        this.imported = false;
    }

    public Product(String description, double shelfPrice, boolean imported) {
        this.description = description;
        this.shelfPrice = new BigDecimal(shelfPrice);
        this.imported = imported;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getShelfPrice() {
        return shelfPrice.doubleValue();
    }

    public void setShelfPrice(double shelfPrice) {
        this.shelfPrice = new BigDecimal(shelfPrice);
    }

    public boolean isImported() {
        return imported;
    }
}
