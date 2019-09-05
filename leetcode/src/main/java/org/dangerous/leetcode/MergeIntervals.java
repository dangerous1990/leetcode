package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> r = new ArrayList();
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int s = intervals[0][0];
        int e = intervals[0][1];


        for (int[] i : intervals) {
            if (i[0] <= e) {
                e = Math.max(i[1], e);
            } else {
                r.add(new int[]{s, e});
                s = i[0];
                e = i[1];
            }
        }

        r.add(new int[]{s, e});
        return r.toArray(new int[r.size()][]);
    }
}
