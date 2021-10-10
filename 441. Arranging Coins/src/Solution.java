/*
* You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
* Given the integer n, return the number of complete rows of the staircase you will build.
* */

public class Solution {
    public int arrangeCoins(int n) {
        int res = 1;

        while (n > 0)
            n -= res ++;

        return n == 0 ? res - 1 : res - 2;
    }
}
