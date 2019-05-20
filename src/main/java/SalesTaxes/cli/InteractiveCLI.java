package SalesTaxes.cli;

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
import java.util.Scanner;

public class InteractiveCLI {

    private final String[] COMMANDS = {"shopping","license","exit"};
    private Scanner readFromKeyboard;
    private CashRegister cashRegister;
    private Shopping shopping;

    public InteractiveCLI() {
        this.readFromKeyboard = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Sales Taxes  Copyright (C) 2019  Stefano Salvagni\n" +
                "This program comes with ABSOLUTELY NO WARRANTY; for details type `license`.\n" +
                "This is free software, and you are welcome to redistribute it\n" +
                "under certain conditions; type `license` for details.");

        SalesTax taxCollectors[] = {new DefaultTax(SalesTax.DEFAULT_RATE, new ArrayList<Class>() {{
            add(Book.class);
            add(Food.class);
            add(Medicine.class);
        }}), new ImportDutyTax()};
        this.cashRegister = new CashRegister(taxCollectors);
        this.shopping = ShoppingBuilder.getMe().build();

        String action = "";
        while((action = showMainMenu()).compareToIgnoreCase("exit") != 0) {
            if(action.compareToIgnoreCase("license") == 0)
                printLicense();
            else
                doShopping();
        }

        System.out.println("Thanks to use this program!");
    }

    private String showMainMenu() {
        String choose = "";
        do {

            System.out.println("\nCOMMANDS: shopping | license | exit");
            System.out.print("Digit a command: ");
            choose = this.readFromKeyboard.nextLine();

        }while(!isValidCommand(choose, this.COMMANDS));

        return choose;
    }

    private void doShopping() {
        String sentence = "";
        do {
            System.out.println("\nCOMMANDS: Sentence like \"3 book at 12.39\", list, end");
            System.out.print("What do you want? ");
            sentence = this.readFromKeyboard.nextLine();
            if (sentence.compareToIgnoreCase("end") == 0) {
                System.out.println("\nReceipt");
                this.cashRegister.printReceipt(this.shopping).forEach(it -> System.out.println(it));
                this.shopping.removeAll();
            }else if(sentence.compareToIgnoreCase("list") == 0){
                System.out.println("\nCurrent Shopping List");
                this.shopping.getPurchasedProducts().forEach(it -> System.out.println(it));
            } else {
                InputParser inputParser = new InputParser(InputParser.DEFAULT_REGEX);
                inputParser.parse(sentence);
                try {
                    Product productType = tellMeProductType(inputParser.getDescription(),
                            inputParser.getPrice(), inputParser.isImported());
                    this.shopping.putIn(productType, inputParser.getQuantity());
                } catch (WrongInputFormatException ex) {
                    System.out.println("The sentence is in wrong format!");
                }
            }
        }while(sentence.compareToIgnoreCase("end") != 0);
    }

    private Product tellMeProductType(String description, double price, boolean imported) {
        String prodType = "";
        do {
            System.out.println("\nPOSSIBLE VALUES: book | medicine | food | other");
            System.out.print("Type of product? ");
            prodType = this.readFromKeyboard.nextLine();

        }while(!isValidCommand(prodType, new String[]{"book", "medicine", "food", "other"}));

        if (prodType.compareToIgnoreCase("book") == 0) {
            return new Book(description, price);
        } else if(prodType.compareToIgnoreCase("food") == 0) {
            return new Food(description, price);
        } else if(prodType.compareToIgnoreCase("medicine") == 0) {
            return new Medicine(description, price);
        } else {
            return new Product(description, price);
        }
    }

    private void printLicense() {

    }

    private boolean isValidCommand(String s, String valids[]) {
        int i = 0;
        while (i < valids.length && s.compareToIgnoreCase(valids[i]) != 0)
            i++;
        return i < valids.length;
    }

}
