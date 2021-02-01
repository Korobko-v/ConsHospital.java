package net.thumbtack.school.matrix;


import java.util.*;

public class MatrixNonSimilarRows {
    int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {

        this.matrix = matrix;
    }

    public List<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> map = new HashMap<>();
        for (int i = this.matrix.length-1; i >= 0; i--) {
            Set<Integer> set = new HashSet<>();
            for (int a : matrix[i]) {
                set.add(a);
            }
            map.putIfAbsent(set, matrix[i]);
        }
        return new ArrayList<>(map.values());
    }
}
