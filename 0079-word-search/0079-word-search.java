import java.util.*;

class Solution {
    private boolean ans = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    wordCheck(board, word, i, j, 1, visited);
                    
                }
            }
        }

        return ans;
    }

    public void wordCheck(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }

        if (index == word.length()) {
            ans = true;
            return;
        }

        // up
        if (i > 0 && !ans && word.charAt(index) == board[i - 1][j]) {
            visited[i][j] = true;
            wordCheck(board, word, i - 1, j, index + 1, visited);
            visited[i][j] = false;
        }
        // down
        if (i < board.length - 1 && !ans && word.charAt(index) == board[i + 1][j]) {
            visited[i][j] = true;
            wordCheck(board, word, i + 1, j, index + 1, visited);
            visited[i][j] = false;
        }
        // left
        if (j > 0 && !ans && word.charAt(index) == board[i][j - 1]) {
            visited[i][j] = true;
            wordCheck(board, word, i, j - 1, index + 1, visited);
            visited[i][j] = false;
        }
        // right
        if (j < board[0].length - 1 && !ans && word.charAt(index) == board[i][j + 1]) {
            visited[i][j] = true;
            wordCheck(board, word, i, j + 1, index + 1, visited);
            visited[i][j] = false;
        }

    }
}