/*
* You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.
*
* We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
*
* Return the reformatted license key.
* */

class Solution {
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder builder = new StringBuilder();

        int index = 0;

        for (int i=s.length() - 1; i>=0; i--) {
            if (s.charAt(i) == '-')
                continue;

            builder.append(s.charAt(i));
            index ++;

            if (index % k == 0)
                builder.append('-');
        }

        if (!builder.isEmpty() && builder.charAt(builder.length() - 1) == '-')
            builder.deleteCharAt(builder.length() - 1);

        return builder.reverse().toString().toUpperCase();
    }
}