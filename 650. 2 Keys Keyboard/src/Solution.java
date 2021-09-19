/*
* There is only one character 'A' on the screen of a notepad. You can perform two operations on this notepad for each step:
*     Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
*     Paste: You can paste the characters which are copied last time.
* Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
* */

class Solution {
    public int minSteps(int n) {
        if (n == 1)
            return 0;

        int temp = n;

        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                temp = minSteps(n / i) + i;
                break;
            }
        }

        return temp;
    }
}