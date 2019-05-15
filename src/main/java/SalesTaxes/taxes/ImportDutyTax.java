package SalesTaxes.taxes;

import SalesTaxes.products.Product;

public class ImportDutyTax extends SalesTax {

    public ImportDutyTax() {
        this.rate = SalesTax.DUTY_IMPORT_RATE;
    }

    public ImportDutyTax(int rate) {
        this.rate = rate;
    }

    @Override
    public boolean hasToApply(Product p) {
        return p.isImported();
    }

}
