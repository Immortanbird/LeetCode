/*
* Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
* */

class Solution {
    public static int addDigits(int num) {
        if (num < 10)
            return num;

        String s = String.valueOf(num);

        while (s.length() > 1) {
            int res = s.charAt(0) + s.charAt(1) - 2 * '0';
            s = res + (s.length() > 2 ? s.substring(2) : "");
        }

        return Integer.parseInt(s);
    }
}