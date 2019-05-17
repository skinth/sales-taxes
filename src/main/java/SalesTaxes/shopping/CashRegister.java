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
package SalesTaxes.shopping;

import SalesTaxes.taxes.SalesTax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CashRegister {

    private SalesTax[] taxCollectors;

    public CashRegister(SalesTax[] taxCollectors) {
        this.taxCollectors = taxCollectors;
    }

    private void doIt(Shopping shopping) {
        BigDecimal tot = new BigDecimal(0.00);
        BigDecimal totTaxes = new BigDecimal(0.00);
        BigDecimal prodTaxes = new BigDecimal(0.00);
        for(PurchasedProduct currentProduct : shopping.getPurchasedProducts()) {
            prodTaxes = new BigDecimal(0.00);
            for(SalesTax taxCollector : this.taxCollectors) {
                prodTaxes = prodTaxes.add(taxCollector.calculateTax(currentProduct.getProduct()));
            }
            totTaxes = prodTaxes.multiply(new BigDecimal(currentProduct.getQuantity())).add(totTaxes);
            BigDecimal basePrice = new BigDecimal(currentProduct.getProduct().getShelfPrice());
            currentProduct.setFinalPrice(
                    basePrice.add(prodTaxes).multiply(new BigDecimal(currentProduct.getQuantity())).doubleValue()
            );
            tot = tot.add(new BigDecimal(currentProduct.getFinalPrice()));
        }
        shopping.setTotal(tot);
        shopping.setTotalTaxes(totTaxes);
    }

    public List<String> printReceipt(Shopping shopping) {
        this.doIt(shopping);
        List<String> receipt = new ArrayList<>();
        receipt.add("Output:");
        receipt.addAll(shopping.getPurchasedProducts().stream()
                        .map(pp -> pp.getQuantity() + " " + pp.getProduct().getDescription() + ": " + pp.getFinalPrice())
                        .collect(Collectors.toList()));
        receipt.add("Sales Taxes: "+shopping.getTotalTaxes());
        receipt.add("Total: "+shopping.getTotal());
        return receipt;
    }

    public SalesTax[] getTaxCollectors() {
        return this.taxCollectors;
    }

    public void setTaxCollectors(SalesTax[] taxCollectors) {
        this.taxCollectors = taxCollectors;
    }

}
