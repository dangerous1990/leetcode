package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        if (rowIndex == 1) {
            return Arrays.asList(1, 1);
        }
        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        row[1] = 1;
        for (int i = 2; i <= rowIndex; i++) {
            row[i] = 1;
            int prev = row[0];
            for (int j = 1; j < i; j++) {
                int temp = row[j];
                row[j] = prev + row[j];
                prev = temp;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(row[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangleII().getRow(5));
    }
}
