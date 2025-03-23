class Solution {
    private void solve(int col, List<String> board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                // Place the queen
                char[] newRow = board.get(row).toCharArray();
                newRow[col] = 'Q';
                board.set(row, new String(newRow));

                solve(col + 1, board, ans, n); // Recur for next column

                // Backtrack: Remove the queen
                newRow[col] = '.';
                board.set(row, new String(newRow));
            }
        }
    }

    private boolean isSafe(int row, int col, List<String> board, int n) {
        // Check same row on the left
        for (int i = 0; i < col; i++) {
            if (board.get(row).charAt(i) == 'Q') return false;
        }

        // Check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        // Check lower diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        // Initialize board with empty rows
        String emptyRow = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(emptyRow);
        }

        solve(0, board, ans, n);
        return ans;
    }
}