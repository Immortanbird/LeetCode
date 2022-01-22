/*
* Alice and Bob continue their games with stones. There is a row of n stones, and each stone has an associated value. You are given an integer array stones, where stones[i] is the value of the ith stone.
*
* Alice and Bob take turns, with Alice starting first. On each turn, the player may remove any stone from stones. The player who removes a stone loses if the sum of the values of all removed stones is divisible by 3. Bob will win automatically if there are no remaining stones (even if it is Alice's turn).
*
* Assuming both players play optimally, return true if Alice wins and false if Bob wins.
*/
/*博弈题，没啥意思*/
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int div0 = 0;
        int div1 = 0;
        int div2 = 0;
        for (int i : stones) {
            if (i%3 == 0)
                div0++;
            if (i%3 == 1)
                div1++;
            if (i%3 == 2)
                div2++;
        }

        if (div0 % 2 == 0) {
            return div1 >= 1 && div2 >= 1;
        }

        return Math.abs(div1 - div2) > 2;
    }
}