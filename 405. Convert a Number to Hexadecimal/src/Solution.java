/*
* Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.
* All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.
*
* Note: You are not allowed to use any built-in library method to directly solve this problem.
* */

class Solution {
    public String toHex(int num) {
        StringBuilder builder = new StringBuilder();

        while (builder.length() < 8) {
            builder.append(Integer.toHexString(num & 0xf));
            num >>= 4;
            if (num == 0)
                break;
        }

        return builder.reverse().toString();
    }
}