package net.thumbtack.school.introduction;

import java.util.Arrays;

public class FirstSteps {
    public int sum (int x, int y) {
        return x + y;
    }
    public int mul (int x, int y) {
        return x * y;
    }
    public int div (int x, int y) {
        return x / y;
    }
    public int mod (int x, int y) {
        return x % y;
    }
    public boolean isEqual (int x, int y) {
        return x == y ? true : false;
    }
    public boolean isGreater (int x, int y) {
        return x > y ? true : false;
    }
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        if (x > xRight) {
            return false;
        }
        if (x < xLeft) {
            return false;
        }
        if (y < yTop) {
            return false;
        }
        if (y > yBottom) {
            return false;
        }
        return true;
    }
    public int sum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
    public int mul(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int mul = 1;
        for (int i : array) {
            mul *= i;
        }
        return mul;
    }
    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            min = Math.min(i, min);
        }
        return min;
    }
    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(i, max);
        }
        return max;
    }
    public double average(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        double sum = 0.0;
        for (int i : array) {
            sum += i;
        }
        return sum / array.length;
    }
    public boolean isSortedDescendant(int[] array) {
        boolean isSorted = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i-1]) {
                return false;
            }
        }
        return isSorted;
    }
    public void cube(int[]array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(array[i] , 3);
        }
    }
    public boolean find(int[]array, int value) {
        boolean find = false;
        for (int i : array) {
            if (i == value) {
                find = true;
            }
        }
        return find;
    }
    public void reverse(int[]array) {
        for (int i = 0; i < array.length / 2; i++) {
            int t = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = t;
        }
    }
    public boolean isPalindrome(int[]array) {
        boolean isP = true;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != array[array.length-1-i]) {
                isP = false;
            }
        }
        return isP;
    }
    public int sum(int[][] matrix) {
        int x = matrix.length;
        int sum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        if (matrix.length == 0) {
            return Integer.MIN_VALUE;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(matrix[i][j], max);
            }
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        if (matrix.length == 0) {
            return 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    max = Math.max(matrix[i][i], max);
                }
            }
        }
        return max;
    }
    public boolean isSortedDescendant(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
                    return (isSortedDescendant(matrix[i]));
                }
        return true;
    }
}
