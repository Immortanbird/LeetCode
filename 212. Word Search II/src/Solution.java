/*
* Given an m x n board of characters and a list of strings words, return all words on the board.
* Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
* */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean checkBounds(int rows, int cols, int x, int y) {
        return x > -1 && x < rows && y > -1 && y < cols;
    }

    public void DFS(char[][] board, Trie tar, Set<String> res, int x, int y) {
        int index = board[x][y] - 'a';

        if (tar.next[index] == null)
            return;

        tar = tar.next[index];

        if (tar.isEnd)
            res.add(tar.word);

        for (int i=0; i<4; i++) {
            int[] temp = {x + direction[i][0], y + direction[i][1]};
            char c = board[x][y];
            board[x][y] = '*';
            if (checkBounds(board.length, board[0].length, temp[0], temp[1]) && board[temp[0]][temp[1]] !='*') {
                DFS(board, tar, res, temp[0], temp[1]);
            }
            board[x][y] = c;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;

        Trie head = new Trie();

        for (String s : words)
            head.insert(s);

        Set<String> res = new HashSet<>();

        for (int i=0; i<rows; i++)
            for (int j=0; j<cols; j++)
                DFS(board, head, res, i, j);

        return new ArrayList<>(res);
    }
}
