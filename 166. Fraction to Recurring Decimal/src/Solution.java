/*
* Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
* If the fractional part is repeating, enclose the repeating part in parentheses.
* If multiple answers are possible, return any of them.
* It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
* */
/*被溢出干爆了
* Math.abs(int x), when x equals Integer.MIN_VALUE, the return value will still be Integer.MIN_VALUE.
* */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        long x = numerator;
        long y = denominator;

        if (x % y == 0)
            return Long.toString(x / y);

        StringBuilder builder = new StringBuilder();
        Map<Long, Integer> remainder = new HashMap<>();

        if (x * y < 0)
            builder.append('-');

        x = Math.abs(x);
        y = Math.abs(y);

        builder.append(x / y).append('.');
        x = x % y * 10;

        while (x != 0) {
            if (remainder.containsKey(x)) {
                int index = remainder.get(x) - 1;
                builder.insert(index, '(');
                builder.append(')');
                break;
            }

            builder.append(x / y);
            remainder.put(x, builder.length());
            x = x % y * 10;
        }

        return builder.toString();
    }
}