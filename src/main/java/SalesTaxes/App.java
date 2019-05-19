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
package SalesTaxes;

import SalesTaxes.products.Book;
import SalesTaxes.products.Food;
import SalesTaxes.products.Medicine;
import SalesTaxes.products.Product;
import SalesTaxes.shopping.CashRegister;
import SalesTaxes.shopping.Shopping;
import SalesTaxes.shopping.ShoppingBuilder;
import SalesTaxes.taxes.DefaultTax;
import SalesTaxes.taxes.ImportDutyTax;
import SalesTaxes.taxes.SalesTax;
import SalesTaxes.utils.InputParser;
import SalesTaxes.utils.WrongInputFormatException;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        System.out.println("SalesTaxes");

        CashRegister cr = new CashRegister(new SalesTax[] {
                new DefaultTax(SalesTax.DEFAULT_RATE, new ArrayList<>() {{
                    add(Book.class);
                    add(Medicine.class);
                    add(Food.class);
                }}),
                new ImportDutyTax()
        });

        try {
            InputParser parser = new InputParser(InputParser.DEFAULT_REGEX);
            //parse t-shirt
            parser = parser.parse("1 t-shirt at 14.99");
            ShoppingBuilder shoppingBuilder = ShoppingBuilder.getMe()
                    .purchase(new Product(parser.getDescription(), parser.getPrice(), parser.isImported()), parser.getQuantity());
            //parse books
            parser = parser.parse("2 book at 13.23");
            shoppingBuilder = shoppingBuilder.purchase(new Book(parser.getDescription(), parser.getPrice(), parser.isImported()), parser.getQuantity());
            Shopping shopping = shoppingBuilder.build();
            cr.printReceipt(shopping).forEach(it -> System.out.println(it));
        }catch (WrongInputFormatException ex) {
            System.out.println("Wrong input sentence format!");
        }
    }
}
