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
