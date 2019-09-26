package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            res.add(Stream.generate(() -> 1).limit(i + 1).collect(Collectors.toList()));
        }
        if (numRows < 3) {
            return res;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> lastRow = res.get(i - 1);
            List<Integer> curRow = res.get(i);
            for (int j = 1; j < i; j++) {
                curRow.set(j, lastRow.get(j) + lastRow.get(j - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(5));
    }
}
