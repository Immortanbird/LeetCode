/*
* Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
* In one step, you can delete exactly one character in either string.
* */

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i=0; i < len2 + 1; i++)
            dp[0][i] = i;

        for (int i=0; i < len1 + 1; i++)
            dp[i][0] = i;

        for (int i=1;  i < len1 + 1; i++) {
            for (int j=1;  j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
            }
        }

        return dp[len1][len2];
    }
}