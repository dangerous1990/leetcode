package org.dangerous.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/task-scheduler/description/
 * Created by limeng on 17-12-6.
 */
public class TaskScheduler {
    /**
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int mx = 0, mxCnt = 0;
        int[] counts = new int[36];
        for (char task : tasks) {
            ++counts[task - 'A'];
            if (mx == counts[task - 'A']) {
                ++mxCnt;
            } else if (mx < counts[task - 'A']) {
                mx = counts[task - 'A'];
                mxCnt = 1;
            }
        }
        //
        int partCnt = mx - 1;
        //part中的空位个数就是n - (mxCnt - 1)
        int partLen = n - (mxCnt - 1);
        int emptySlots = partCnt * partLen;
        int taskLeft = tasks.length - mx * mxCnt;
        int idles = Math.max(0, emptySlots - taskLeft);
        return tasks.length + idles;
    }
}
