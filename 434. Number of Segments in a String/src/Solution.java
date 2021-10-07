/*
* You are given a string s, return the number of segments in the string.
* A segment is defined to be a contiguous sequence of non-space characters.
* */

public class Solution {
    public int countSegments(String s) {
        int res = 0;
        boolean former = false;
        s += ' ';

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != ' ')
                former = true;
            else if (former) {
                res ++;
                former = false;
            }
        }

        return res;
    }
}
