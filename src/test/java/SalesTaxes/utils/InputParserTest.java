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
package SalesTaxes.utils;

import static org.junit.Assert.*;

import SalesTaxes.products.Product;
import SalesTaxes.shopping.PurchasedProduct;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InputParserTest {

    private InputParser parsedSentence;

    @Before
    public void createInputParser() {
        parsedSentence = new InputParser(InputParser.DEFAULT_REGEX);
    }

    @Test
    public void testParseSentence() throws WrongInputFormatException {
        String sentence = "3 book at 19.99";
        parsedSentence.parse(sentence);
        assertEquals(3, parsedSentence.getQuantity());
        assertEquals("book", parsedSentence.getDescription());
        assertEquals(19.99, parsedSentence.getPrice(), 0);
        assertEquals(false, parsedSentence.isImported());
    }

    @Test
    public void testParseSentenceImported() throws WrongInputFormatException {
        String sentence = "3 imported book at 19.99";
        parsedSentence.parse(sentence);
        assertEquals(3, parsedSentence.getQuantity());
        assertEquals("imported book", parsedSentence.getDescription());
        assertEquals(19.99, parsedSentence.getPrice(), 0);
        assertEquals(true, parsedSentence.isImported());
    }

    @Test(expected = WrongInputFormatException.class)
    public void testParseSentenceWrongFormat() throws WrongInputFormatException {
        String sentence = "3 at 19.99";
        parsedSentence.parse(sentence);

        assertEquals(3, parsedSentence.getQuantity());
        assertEquals("book", parsedSentence.getDescription());
        assertEquals(19.99, parsedSentence.getPrice(), 0);
        assertEquals(false, parsedSentence.isImported());
    }

}
