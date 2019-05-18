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
package SalesTaxes.shopping;

import SalesTaxes.products.Product;
import SalesTaxes.utils.CurrencyUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shopping {

    private List<PurchasedProduct> purchasedProducts;
    private BigDecimal total;
    private BigDecimal totalTaxes;

    public Shopping() {
        this.purchasedProducts = new ArrayList<PurchasedProduct>();
    }

    public Shopping(List<PurchasedProduct> purchasedProducts) {
        this.purchasedProducts = new ArrayList<>();
        purchasedProducts.forEach(el -> this.purchasedProducts.add(el));
    }

    public boolean isEmpty() {
        return this.purchasedProducts.isEmpty();
    }

    public int getListSize() {
        int numberOf = 0;
        for(PurchasedProduct cp : this.purchasedProducts) {
            numberOf += 1*cp.getQuantity();
        }
        return numberOf;
    }

    public List<PurchasedProduct> getPurchasedProducts() {
        return this.purchasedProducts;
    }

    public void putIn(PurchasedProduct purchasedProduct) {
        this.purchasedProducts.add(purchasedProduct);
    }

    public void putIn(Product p, int quantity) {
        PurchasedProduct purchasedProduct = new PurchasedProduct(p, quantity);
        this.putIn(purchasedProduct);
    }

    public PurchasedProduct remove(int index) {
        return this.purchasedProducts.remove(index);
    }

    public void removeAll() {
        this.purchasedProducts.clear();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = CurrencyUtils.truncateTo(total, 2);
    }

    public BigDecimal getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(BigDecimal totalTaxes) {
        this.totalTaxes = CurrencyUtils.truncateTo(totalTaxes, 2);
    }
}
