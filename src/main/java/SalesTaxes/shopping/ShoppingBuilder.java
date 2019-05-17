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
