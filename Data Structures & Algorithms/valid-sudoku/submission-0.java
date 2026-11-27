class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];

                if (num == '.') {
                    continue;
                }

                String row = "row-" + r + "-" + num;
                String col = "col-" + c + "-" + num;
                String box = "box-" + r / 3 + "-" + c / 3 + "-" + num;

                if (!seen.add(row) ||
                    !seen.add(col) ||
                    !seen.add(box)) {
                    return false;
                }
            }
        }

        return true;
    }
}