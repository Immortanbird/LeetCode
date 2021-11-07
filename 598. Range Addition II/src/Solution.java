/*
* You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
*
* Count and return the number of maximum integers in the matrix after performing all the operations.
* */

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0)
            return m * n;

        int max_l = ops[0][0];
        int max_r = ops[0][1];

        for(int[] row : ops) {
            if (row[0] < max_l)
                max_l = row[0];
            if (row[1] < max_r)
                max_r = row[1];
        }

        return max_l * max_r;
    }
}
