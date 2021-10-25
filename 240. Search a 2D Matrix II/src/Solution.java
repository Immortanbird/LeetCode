/*
* Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
*   Integers in each row are sorted in ascending from left to right.
*   Integers in each column are sorted in ascending from top to bottom.
* */

class Solution {
    public boolean searchRows(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (row[mid] == target)
                return true;
            if (row[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return row[left] == target;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix)
            if (searchRows(row, target))
                return true;

        return false;
    }
}