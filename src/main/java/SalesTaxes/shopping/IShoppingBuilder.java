package SalesTaxes.shopping;

import SalesTaxes.products.Product;

public interface IShoppingBuilder {

    IShoppingBuilder purchase(Product p, int quantity);
    Shopping build();

}
