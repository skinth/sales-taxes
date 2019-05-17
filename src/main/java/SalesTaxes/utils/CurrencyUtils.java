/*
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

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class CurrencyUtils {

    public static final BigDecimal roundUpToNearest(BigDecimal value, double factor) {
        //round up value to the nearest factor
        //new_value = ceil(value/factor) * factor
        BigDecimal scale = new BigDecimal(factor);
        BigDecimal quotient = value.divide(scale, 0, RoundingMode.CEILING);
        BigDecimal product = quotient.multiply(scale);
        return product.setScale(2, RoundingMode.FLOOR);
    }

    public static final BigDecimal truncateTo(BigDecimal value, int position) {
        return value.setScale(position, RoundingMode.HALF_DOWN);
    }
}
