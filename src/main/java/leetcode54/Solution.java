package leetcode54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int row = 0;
    int col = 0;
    int count = 0;
    int rowL = 0;
    int colL = 0;
    int rowH;
    int colH;

    public List<Integer> spiralOrder(int[][] matrix) {
        rowH = matrix.length - 1;
        colH = matrix[0].length - 1;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            l.add(matrix[row][col]);
            move();
        }

        return l;
    }

    private void move() {
        switch (count % 4) {
            case 0:
                if (col < colH) {
                    col++;
                } else {
                    rowL++;
                    count++;
                    row++;

                }
                break;
            case 1:
                if (row < rowH) {
                    row++;
                } else {
                    colH--;
                    count++;
                    col--;

                }
                break;
            case 2:
                if (col > colL) {
                    col--;
                } else {
                    rowH--;
                    count++;
                    row--;

                }
                break;
            case 3:
                if (row > rowL) {
                    row--;
                } else {
                    colL++;
                    count++;
                    col++;
                }
                break;
        }
    }
}