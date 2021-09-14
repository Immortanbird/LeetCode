/*
* Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
* 1.Each row must contain the digits 1-9 without repetition.
* 2.Each column must contain the digits 1-9 without repetition.
* 3.Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*
* Note:
*   A Sudoku board (partially filled) could be valid but is not necessarily solvable.
*   Only the filled cells need to be validated according to the mentioned rules.
* */
/*强行空间换时间，笑死*/
/*md数学不好 草*/

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(s.isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[][] hashrow = new boolean[9][9];
        boolean[][] hashcol = new boolean[9][9];
        boolean[][] hashsqr = new boolean[9][9];

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.')
                    continue;

                int temp = board[i][j] - '0' - 1;
                if (hashrow[i][temp])
                    return false;
                else
                    hashrow[i][temp] = true;

                if (hashcol[j][temp])
                    return false;
                else
                    hashcol[j][temp] = true;

                var booleans = hashsqr[i / 3 * 3 + j / 3];
                if (booleans[temp])
                    return false;
                else
                    booleans[temp] = true;
            }
        }

        return true;
    }
}