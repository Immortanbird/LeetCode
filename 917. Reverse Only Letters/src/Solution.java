/*
* Given a string s, reverse the string according to the following rules:
*   All the characters that are not English letters remain in the same position.
*   All the English letters (lowercase or uppercase) should be reversed.
* Return s after reversing it.
* */

import java.util.Arrays;

class Solution {
    private boolean isLetter(String s, int index) {
        return (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') || (s.charAt(index) >= 'a' && s.charAt(index) <= 'z');
    }

    public String reverseOnlyLetters(String s) {
        char[] res = s.toCharArray();
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            while (left < right && !isLetter(s, left))
                left++;

            while (left < right && !isLetter(s, right))
                right--;

            if (isLetter(s, left) && isLetter(s, right)) {
                res[left] = s.charAt(right);
                res[right] = s.charAt(left);
            }
        }

        return new String(res);
    }
}