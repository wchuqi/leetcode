package leetcode.深度搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/n-queens/solution/n-huang-hou-java-by-sui-ji-guo-cheng-sui-q0ot/
public class Q51 {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] t : board) {
            Arrays.fill(t, '.');
        }
        backtrace(board, 0);
        return res;
    }
    void backtrace(char[][] board, int row) {
        if (row == board.length) {
            res.add(charArrayToList(board));
            return;
        }
        int n = board[row].length;
        for (int col=0;col<n;col++) {
            if (!valid(board,row, col)) {
                continue;
            }
            board[row][col]='Q';
            backtrace(board,row+1);
            board[row][col]='.';
        }
    }
    boolean valid(char[][] board, int row, int col) {
        int n = board.length;
        for (int i=0;i<n;i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i=row-1,j=col+1;i>=0 && j<n;i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i=row-1,j=col-1;i >=0 && j>=0;i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    List<String> charArrayToList(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] t : board) {
            res.add(String.copyValueOf(t));
        }
        return res;
    }
}
