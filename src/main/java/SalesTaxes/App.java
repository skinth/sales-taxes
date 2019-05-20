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

import java.util.*;

public class App {

    private CashRegister cashRegister;

    public App() {
        //create cash register and tax collectors
         this.cashRegister = new CashRegister(new SalesTax[]{
                new DefaultTax(SalesTax.DEFAULT_RATE, new ArrayList<>() {{
                    add(Book.class);
                    add(Medicine.class);
                    add(Food.class);
                }}),
                new ImportDutyTax()
        });
    }

    public Shopping doShopping(Map<Product.ProductType, String[]> sentences) {
        Shopping shopping = new Shopping();
        try {
            //DEFAULT_REGEX matches sentence in this format:
            //digit word1 [word2...wordn] at digit1[digit2...digitn].digit1[digit2...digitn]
            InputParser parser = new InputParser(InputParser.DEFAULT_REGEX);
            ShoppingBuilder shoppingBuilder= ShoppingBuilder.getMe();
            for(Product.ProductType key : sentences.keySet()) {
                for (int i = 0; i < sentences.get(key).length; i++)
                    shoppingBuilder.purchase(parser.parseProduct(key, sentences.get(key)[i]), parser.getQuantity());
            }
            shopping = shoppingBuilder.build();
            this.cashRegister.printReceipt(shopping).forEach(it -> System.out.println(it));
        } catch (WrongInputFormatException ex) {
            System.out.println("Wrong input sentence format!");
        }
        return shopping;
    }

    public CashRegister getCashRegister() {
        return this.cashRegister;
    }

    public static void main(String[] args) {
        System.out.println("Sales Taxes  Copyright (C) 2019  Stefano Salvagni\n" +
                "This program comes with ABSOLUTELY NO WARRANTY; for details type consult LICENSE file.\n" +
                "This is free software, and you are welcome to redistribute it\n" +
                "under certain conditions; read LICENSE file for details.\n");

        App app = new App();

        Map<Product.ProductType, String[]> inputOne = new LinkedHashMap<>() {{
            put(Product.ProductType.Book, new String[] {"2 book at 12.49"});
            put(Product.ProductType.Other, new String[] {"1 music CD at 14.99"});
            put(Product.ProductType.Food, new String[] {"1 chocolate bar at 0.85"});
        }};

        Map<Product.ProductType, String[]> inputTwo = new LinkedHashMap<>() {{
            put(Product.ProductType.Food, new String[] {"1 imported box of chocolates at 10.00"});
            put(Product.ProductType.Other, new String[] {"1 imported bottle of perfume at 47.50"});
        }};

        Map<Product.ProductType, String[]> inputThree = new LinkedHashMap<>() {{
            put(Product.ProductType.Other, new String[] {"1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99"});
            put(Product.ProductType.Medicine,  new String[] {"1 packet of headache pills at 9.75"});
            put(Product.ProductType.Food,  new String[] {"3 box of imported chocolates at 11.25"});
        }};

        System.out.println("Input:");
        inputOne.values().forEach(sentences -> Arrays.stream(sentences).forEach(it -> System.out.println(it)));
        System.out.print("\n");

        System.out.println("Input:");
        inputTwo.values().forEach(sentences -> Arrays.stream(sentences).forEach(it -> System.out.println(it)));
        System.out.print("\n");

        System.out.println("Input:");
        inputThree.values().forEach(sentences -> Arrays.stream(sentences).forEach(it -> System.out.println(it)));
        System.out.print("\n");

        app.doShopping(inputOne);
        System.out.print("\n");

        app.doShopping(inputTwo);
        System.out.print("\n");

        app.doShopping(inputThree);

        /*ss = new LinkedHashMap<>() {{
            put(Product.ProductType.Other, new String[] {"1 t-shirt at 14.99"}); //taxed at 10% (1.50)
            put(Product.ProductType.Book,  new String[] {"2 imported book at 13.23"}); //taxed at 5%  (0.70)
        }};
        app.doShopping(ss);*/
    }
}
