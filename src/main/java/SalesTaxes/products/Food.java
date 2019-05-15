package SalesTaxes.products;

public class Food extends Product {

    private String category;

    public Food(String description, double shelfPrice, boolean imported, String category) {
        super(description, shelfPrice, imported);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
