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

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<ShoppingCartProduct> cartProducts;

    public ShoppingCart() {
        this.cartProducts = new ArrayList<ShoppingCartProduct>();
    }

    public ShoppingCart(List<ShoppingCartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public boolean isEmpty() {
        return this.cartProducts.isEmpty();
    }

    public int getSize() {
        int numberOf = 0;
        for(ShoppingCartProduct cp : this.cartProducts) {
            numberOf += 1*cp.getQuantity();
        }
        return numberOf;
    }

    public void putIn(ShoppingCartProduct cartProduct) {
        this.cartProducts.add(cartProduct);
    }

    public ShoppingCartProduct remove(int index) {
        return this.cartProducts.remove(index);
    }

    public void removeAll() {
        this.cartProducts.removeIf(it -> it instanceof ShoppingCartProduct);
    }

}
