/*
* Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
*
* The algorithm for myAtoi(string s) is as follows:
*
* Read in and ignore any leading whitespace.
* Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
* Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
* Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
* If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
* Return the integer as the final result.
*
* Note:
*   Only the space character ' ' is considered a whitespace character.
*   Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
* */

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("9223372036854775808"));
    }

    public boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public int myAtoi(String s) {
        int start = 0;

        while (start < s.length() && s.charAt(start) == ' ')
            start ++;

        if (start == s.length())
            return 0;

        boolean minus = false;

        if ((s.charAt(start) == '-' || s.charAt(start) == '+') && start + 1 < s.length() && isNum(s.charAt(start + 1))) {
            minus = s.charAt(start) == '-';
            start ++;
        }
        else if (!isNum(s.charAt(start)))
            return 0;

        long res = 0;

        for (int i=start; i<s.length() && isNum(s.charAt(i)); i++) {
            res = res * 10 + s.charAt(i) - '0';
            if (res > (long) Integer.MAX_VALUE)
                break;
        }

        if (minus)
            return -res < (long)Integer.MIN_VALUE ? Integer.MIN_VALUE : -(int)res;
        else
            return res > (long)Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }
}