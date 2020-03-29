package com.daniel;


import java.util.ArrayList;
import java.util.List;

/**
 * N queens
 *
 * @author Daniel Xia
 * @since 2019/7/2 10:52
 */
public class Solution51 {

    private List<List<String>> resList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return resList;
        }

        int[] record = new int[n];
        process(record, 0, n);
        return resList;
    }

    private void process(int[] record, int row, int n) {
        if (n == row) {
            collectAnswers(record, n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(record, row, col)) {
                record[row] = col;
                process(record, row + 1, n);
            }
        }
    }

    private boolean isValid(int[] record, int row, int col) {
        for (int k = 0; k < row; k++) {
            if (record[k] == col || Math.abs(row - k) == Math.abs(record[k] - col)) {
                return false;
            }
        }
        return true;
    }

    private void collectAnswers(int[] record, int n) {
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] subAnswers = new char[n];
            for (int j = 0; j < n; j++) {
                subAnswers[j] = '.';
            }
            subAnswers[record[i]] = 'Q';
            answers.add(new String(subAnswers));
        }
        resList.add(answers);
    }

}