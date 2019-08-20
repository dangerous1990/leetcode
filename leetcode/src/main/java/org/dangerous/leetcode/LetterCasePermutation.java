package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {
    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        char[][] matrix = new char[S.length()][2];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
                matrix[i][0] = S.charAt(i);
                matrix[i][1] = (char) (matrix[i][0] - 32);
            } else if (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') {
                matrix[i][0] = S.charAt(i);
                matrix[i][1] = (char) (matrix[i][0] + 32);
            } else {
                matrix[i][0] = S.charAt(i);
                matrix[i][1] = ' ';
            }
        }
        backtrace(0, matrix, new StringBuilder());
        return result;
    }

    public void backtrace(int index, char[][] matrix, StringBuilder sb) {
        if (sb.length() == matrix.length) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < matrix[index].length; i++) {
            if (matrix[index][i] == ' ') {
                continue;
            }
            sb.append(matrix[index][i]);
            backtrace(index + 1, matrix, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }
}
