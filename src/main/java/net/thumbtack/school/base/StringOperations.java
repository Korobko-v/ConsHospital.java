package net.thumbtack.school.base;

import java.text.DecimalFormat;
import java.util.Arrays;

public class StringOperations {
    public static int getSummaryLength(String[] strings) {
        int sum = 0;
        for (String s: strings) {
            sum += s.length();
        }
        return sum;
    }

    public static String getFirstAndLastLetterString(String string) {
        String s = string.charAt(0) + "" + string.charAt(string.length()-1) + "";
        return s;
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        if (string1.charAt(index) == string2.charAt(index)) {
            return true;
        }
        return false;
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        if (string1.indexOf(character) == string2.indexOf(character)) {
            return true;
        }
        return false;
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        if (string1.lastIndexOf(character) == string2.lastIndexOf(character)) {
            return true;
        }
        return false;
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        if (string1.indexOf(str) == string2.indexOf(str)) {
            return true;
        }
        return false;
    }
    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        if (string1.lastIndexOf(str) == string2.lastIndexOf(str)) {
            return true;
        }
        return false;
    }

    public static boolean isEqual(String string1, String string2) {
        if (string1.equals(string2)) {
            return true;
        }
        return false;
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        if (string1.equalsIgnoreCase(string2)) {
            return true;
        }
        return false;
    }

    public static boolean isLess(String string1, String string2) {
        if (string1.compareTo(string2) < 0) {
            return true;
        }
        return false;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        if (string1.compareToIgnoreCase(string2) < 0) {
            return true;
        }
        return false;
    }
    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }
    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        if (string1.startsWith(prefix) && string2.startsWith(prefix)) {
            return true;
        }
        return false;
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        if (string1.endsWith(suffix) && string2.endsWith(suffix)) {
            return true;
        }
        return false;
    }

    public static String getCommonPrefix(String string1, String string2) {
        int len = Math.min(string1.length(), string2.length());
        String prefix = "";
        for (int i = 0; i < len; i ++) {
            if (string1.charAt(i) == string2.charAt(i)) {
                prefix += string1.charAt(i);
            }
            else {
                break;
            }
        }
        return prefix;
    }

    public static String reverse(String string) {
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        return sb.toString();
    }

    public static boolean isPalindrome(String string) {
        StringBuilder sb = new StringBuilder(string);
        if (sb.toString().equals(sb.reverse().toString())) {
            return true;
        }
        return false;
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        StringBuilder sb = new StringBuilder(string);
        if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
            return true;
        }
        return false;
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            if (max < strings[i].length() && isPalindromeIgnoreCase(strings[i]) == true) {
                max = strings[i].length();
            }
        }
        for (String s : strings) {
            if (s.length() == max && isPalindromeIgnoreCase(s) == true) {
                return s;
            }
        }
        return null;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        try {
            if (string1.substring(index, index + length).equals(string2.substring(index, index + length))) {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        if (string1.replaceAll(replaceInStr1 + "", replaceByInStr1 + "").equals(string2.replaceAll(replaceInStr2 + "", replaceByInStr2 + ""))) {
            return true;
        }
        return false;
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        if (string1.replaceAll(replaceInStr1, replaceByInStr1).equals(string2.replaceAll(replaceInStr2, replaceByInStr2))) {
            return true;
        }
        return false;
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {

        StringBuilder sb = new StringBuilder(string.replaceAll("\\s" , ""));
        if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
            return true;
        }
        return false;
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        if (string1.trim().equals(string2.trim())) {
            return true;
        }
        return false;
    }

    public static String makeCsvStringFromInts(int[] array) {
        if (array.length == 0) {
            return "";
        }
        if (array.length == 1) {
            return array[0] + "";
        }
        String line = "";
        for (int i = 0; i < array.length - 1; i++) {
            line += array[i] + ",";
        }
        line += array[array.length-1];
        return line;
    }
    public static String makeCsvStringFromDoubles(double[] array) {
        if (array.length == 0) {
            return "";
        }


        String line = "";
        if (array.length == 1) {
            return String.valueOf(String.format("%.2f", array[0]));
        }

        for (int j = 0; j < array.length - 1; j++) {
            line += String.valueOf(String.format("%.2f", array[j])) + ",";
        }
        line += String.format("%.2f",array[array.length-1]);
        return line;
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        if (array.length == 0) {
            return sb;
        }

        if (array.length == 1) {
            return sb.append(array[0] + "");
        }

        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i] + ",");
        }
        sb.append(array[array.length-1]);
        return sb;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        if (array.length == 0) {
            return new StringBuilder("");
        }

        String line = "";
        if (array.length == 1) {
            return new StringBuilder(String.format("%.2f", array[0]));
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < array.length - 1; j++) {
            sb.append(String.format("%.2f",array[j]) + ",") ;
        }
        sb.append(String.format("%.2f",array[array.length-1]));
        return sb;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sb = new StringBuilder(string);
        Arrays.sort(positions);
        int count = 0;
                for (int i : positions) {
            sb.deleteCharAt(i - count);
            count++;
        }
        return sb;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder(string);
        Arrays.sort(positions);
        int count = 0;
        for (int i = 0; i < positions.length; i++) {
            sb.insert(positions[i] + count , characters[i]);
            count++;
        }
        return sb;
    }
}
