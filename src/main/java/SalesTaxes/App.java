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

import SalesTaxes.utils.InputParser;
import SalesTaxes.utils.WrongInputFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {

        System.out.println("App!");

        String sentence = "3 imported book at 19.99";
        InputParser parsedSentence = new InputParser("^(\\d+)\\s([a-z\\s]+)\\sat{1,1}\\s(\\d+\\.\\d*)$");
        parsedSentence = parsedSentence.parse(sentence);
        try {
            System.out.println(parsedSentence.isImported());
        }catch(WrongInputFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
