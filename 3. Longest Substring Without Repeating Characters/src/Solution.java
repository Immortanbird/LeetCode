/*
* Given a string s, find the length of the longest substring without repeating characters.
* */
/*滑动窗口*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 1;
        int res = 0;
        Set<Character> hash = new HashSet<>();

        for (int i=0; i<s.length(); i++) {
            hash.add(s.charAt(i));

            if (right == i)
                right ++;

            while (right < s.length()) {
                if (hash.contains(s.charAt(right)))
                    break;
                else
                    hash.add(s.charAt(right++));
            }

            res = Math.max(res, right - i);
            hash.remove(s.charAt(i));
        }

        return res;
    }
}
