/*
* Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
* Given a balanced string s, split it in the maximum amount of balanced strings.
* Return the maximum amount of split balanced strings.
* */

public class Solution {
    public int balancedStringSplit(String s) {
        int left = 0;
        int sum = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'R')
                left--;
            else
                left++;
            if(left == 0)
                sum++;
        }

        return sum;
    }
}
