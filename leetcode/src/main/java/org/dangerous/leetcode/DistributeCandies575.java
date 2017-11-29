package org.dangerous.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/distribute-candies/description/
 * Created by limeng on 17-11-29.
 */
public class DistributeCandies575 {
    /**
     * 糖果要平分，妹妹最多拿到数组一半种类的糖果，如果糖果种类少于一半，所有种类的糖果都要分给妹妹，直接返回全部糖果种类个数
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        int length = candies.length;
        Set<Integer> kinds = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            kinds.add(candies[i]);
        }
        return kinds.size() > length / 2 ? length / 2 : kinds.size();
    }

    public static void main(String[] args) {
        DistributeCandies575 distributeCandies575 = new DistributeCandies575();
        System.out.println(distributeCandies575.distributeCandies(new int[]{1, 1, 2, 3}));
    }
}
