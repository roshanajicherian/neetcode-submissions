class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(i, j, 0, board, word))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int i, int j, int k, char[][] board, String word) {
        if (k == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(k))
            return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = backtrack(i + 1, j, k + 1, board, word)
            || backtrack(i - 1, j, k + 1, board, word) || backtrack(i, j + 1, k + 1, board, word)
            || backtrack(i, j - 1, k + 1, board, word);
        board[i][j] = temp;
        return found;
    }
}
