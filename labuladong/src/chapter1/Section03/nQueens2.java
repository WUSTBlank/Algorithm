package chapter1.Section03;

/**
 * @author Sharon
 * @date 2021-01-28 https://leetcode-cn.com/problems/n-queens/
 */
public class nQueens2 {

    public int totalnQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        char[][] checkerboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkerboard[i][j] = '.';
            }
        }
        boolean[][] mark = new boolean[4][2 * n + 1];
        int count = 0;
        return totalnQueens(n, 0, mark, checkerboard, count);
    }

    private int totalnQueens(int n, int level, boolean[][] mark, char[][] checkerboard, int count) {
        if (n == level) {
            return count + 1;
        }
        for (int i = 0; i < n; i++) {
            if (checkMark(n, level, i, mark)) {
                processMark(n, level, i, mark, true);
                checkerboard[level][i] = 'Q';
                count = totalnQueens(n, level + 1, mark, checkerboard, count);
                checkerboard[level][i] = '.';
                processMark(n, level, i, mark, false);
            }
        }
        return count;
    }

    private boolean checkMark(int n, int row, int col, boolean[][] mark) {
        int rowMark = 0, colMark = 1;
        int diagonal = 2, antiDiagonal = 3;
        if (mark[rowMark][row] || mark[colMark][col]) {
            return false;
        }
        if (mark[diagonal][row + col] || mark[antiDiagonal][row - col + n]) {
            return false;
        }
        return true;
    }

    private void processMark(int n, int row, int col, boolean[][] mark, boolean update) {
        int rowMark = 0, colMark = 1;
        int diagonal = 2, antiDiagonal = 3;
        mark[rowMark][row] = update;
        mark[colMark][col] = update;
        mark[diagonal][row + col] = update;
        mark[antiDiagonal][row - col + n] = update;
    }

    public static void main(String[] args) {
        nQueens2 test = new nQueens2();
        System.out.println(test.totalnQueens(1));
    }

}
