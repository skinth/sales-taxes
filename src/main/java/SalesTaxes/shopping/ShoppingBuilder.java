package SalesTaxes.shopping;

import SalesTaxes.products.Product;

public class ShoppingBuilder implements IShoppingBuilder {

    private Shopping shopping;

    public ShoppingBuilder() {
        this.shopping = new Shopping();
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
