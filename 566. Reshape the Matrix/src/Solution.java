/*
* In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

* You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

* The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

* If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
* */

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int len = mat.length;
        int width = mat[0].length;

        if (len * width != r * c)
            return mat;

        int[][] res = new int[r][c];
        int row = 0;
        int column = 0;

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                res[i][j] = mat[row][column];

                if (column == width - 1) {
                    column = 0;
                    row++;
                }
                else
                    column++;
            }
        }

        return res;
    }
}

/*
* class Solution {
*     public int[][] matrixReshape(int[][] nums, int r, int c) {
*         int m = nums.length;
*         int n = nums[0].length;
*         if (m * n != r * c) {
*             return nums;
*         }
*
*         int[][] ans = new int[r][c];
*         for (int x = 0; x < m * n; ++x) {
*             ans[x / c][x % c] = nums[x / n][x % n];
*         }
*         return ans;
*     }
* }
* */
