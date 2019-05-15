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
