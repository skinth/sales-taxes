package SalesTaxes.products;

public class Medicine extends Product {

    private String manufacturer;
    private String name;
    private String activeIngredient;

    public Medicine(String description, double shelfPrice, boolean imported,
                    String manufacturer, String name, String activeIngredient) {
        super(description, shelfPrice, imported);
        this.manufacturer = manufacturer;
        this.name = name;
        this.activeIngredient = activeIngredient;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActiveIngredient() {
        return activeIngredient;
    }

    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }
}
