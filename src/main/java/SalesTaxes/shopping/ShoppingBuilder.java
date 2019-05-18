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

public class ShoppingBuilder implements IShoppingBuilder {

    private static ShoppingBuilder me;
    private Shopping shopping;

    private ShoppingBuilder() {
        this.shopping = new Shopping();
    }

    public static ShoppingBuilder getMe() {
        if (me == null) {
            me = new ShoppingBuilder();
        }

        return me;
    }

    @Override
    public ShoppingBuilder purchase(Product p, int quantity) {
        PurchasedProduct toShopping = new PurchasedProduct(p, quantity);
        this.shopping.putIn(toShopping);
        return this;
    }

    @Override
    public Shopping build() {
        Shopping buildedShopping = new Shopping(this.shopping.getPurchasedProducts());
        this.shopping.removeAll();
        return buildedShopping;
    }

}
