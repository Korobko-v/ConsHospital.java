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
        	// REVU не обязательно TreeSet, сойдет и просто HashSet
            TreeSet<Integer> set = new TreeSet<>();
            for (int a : matrix[i]) {
                set.add(a);
            }
            // REVU а вот тут Вы делаете работу по проверке, которую за Вас мог бы выполнить некий класс
            // Если List<TreeSet<Integer>> заменить на что-то иное - Что-то<Set<Integer>, который сам это умеет делать
            if (!list.contains(set)) {
                list.add(set);
                rows.add(matrix[i]);
            }
        }
        return rows;
    }
}
