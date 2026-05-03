class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        Set<Integer> column = new HashSet<>();
        Set<Integer> leftDiag = new HashSet<>();
        Set<Integer> rightDiag = new HashSet<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        nQueen(0, n, board, result, column, leftDiag, rightDiag);
        return result;

    }

    void nQueen(int row, int n, char[][] board, List<List<String>> result, Set<Integer> column, Set<Integer> leftDiag,
            Set<Integer> rightDiag) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (column.contains(col) ||
                    leftDiag.contains(row - col) ||
                    rightDiag.contains(row + col)) {
                continue;
            }
            board[row][col] = 'Q';
            leftDiag.add(row - col);
            rightDiag.add(row + col);
            column.add(col);
            nQueen(row + 1, n, board, result, column, leftDiag, rightDiag);
            board[row][col] = '.';
            leftDiag.remove(row - col);
            rightDiag.remove(row + col);
            column.remove(col);
        }

    }
}