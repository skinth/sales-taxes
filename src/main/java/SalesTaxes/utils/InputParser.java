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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    //^(\d+)\s([a-z\s]+)\sat{1,1}\s(\d+\.\d*)$
    private String regex;
    private Matcher matcher;

    public InputParser(String regex) {
        this.regex = regex;
    }

    public InputParser parse(String sentence) {
        Pattern pattern = Pattern.compile(this.regex);
        this.matcher = pattern.matcher(sentence);
        return this;
    }

    private String getMatch(int pos) throws WrongInputFormatException {
        //group[0] = entire pattern
        //group[1] = first match
        //...

        if(this.matcher.find())
            return this.matcher.group(pos);

        throw new WrongInputFormatException("Wrong format sentence!");
    }

    public int getQuantity() throws WrongInputFormatException{
        return Integer.parseInt(this.getMatch(1));
    }

    public String getDescription() throws WrongInputFormatException{
        return this.getMatch(2);
    }

    public double getPrice() throws WrongInputFormatException{
        return Double.parseDouble(this.getMatch(3));
    }

    public boolean isImported() throws WrongInputFormatException{
        return this.getDescription().contains("imported");
    }

}
