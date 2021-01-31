package chapter1.Section03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sharon
 * @date 2021-01-28 https://leetcode-cn.com/problems/n-queens/
 */
public class nQueens {

    public List<List<String>> solvenQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        char[][] checkerboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkerboard[i][j] = '.';
            }
        }
        boolean[][] mark = new boolean[4][2 * n + 1];
        solvenQueens(n, 0, mark, checkerboard, result);
        return result;
    }

    private void solvenQueens(int n, int level, boolean[][] mark, char[][] checkerboard, List<List<String>> result) {
        if (n == level) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sbf = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sbf.append(checkerboard[i][j]);
                }
                list.add(sbf.toString());
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (checkMark(n, level, i, mark)) {
                processMark(n, level, i, mark, true);
                checkerboard[level][i] = 'Q';
                solvenQueens(n, level + 1, mark, checkerboard, result);
                checkerboard[level][i] = '.';
                processMark(n, level, i, mark, false);
            }
        }
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
        nQueens test = new nQueens();
        System.out.println(test.solvenQueens(5).toString());
    }

}
