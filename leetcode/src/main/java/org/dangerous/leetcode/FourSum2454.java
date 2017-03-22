package org.dangerous.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/4sum-ii
 * Created by Administrator on 2017/3/22.
 */
public class FourSum2454 {

    /**
     * 使用hashMap分2组进行存储  key: -(A[i]+B[i]) value:出现的次数
     * -(A[i]+B[i]) = C[i] + D[i]
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        if (n == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = A[i] + B[j];
                map.put(-sum, map.getOrDefault(-sum, 0) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = C[i] + D[j];
                res += map.getOrDefault(sum, 0);
            }
        }

        return res;
    }


}
