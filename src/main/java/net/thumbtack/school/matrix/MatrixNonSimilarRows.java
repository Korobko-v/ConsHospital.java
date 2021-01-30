package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {

        this.matrix = matrix;
    }

    public List<int[]> getNonSimilarRows() {
        List<TreeSet<Integer>> list = new ArrayList<>();
        List<int[]> rows = new ArrayList<>();
        for (int i = this.matrix.length-1; i >= 0; i--) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int a : matrix[i]) {
                set.add(a);
            }
            if (!list.contains(set)) {
                list.add(set);
                rows.add(matrix[i]);
            }
        }
        return rows;
    }
}
