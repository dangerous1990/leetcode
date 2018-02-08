package org.dangerous.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jewels-and-stones/description/
 * Created by limeng on 18-2-8.
 */
public class JewelsAndStones {
    /**
     * 已J建立hash，遍历S在hash中查找 20ms
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int slength = S.length();
        if (slength < 1) {
            return 0;
        }
        int jlength = J.length();
        if (jlength < 1) {
            return 0;
        }
        Set<Character> set = new HashSet<>(52);
        for (int i = 0; i < jlength; i++) {
            set.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0, j = slength - 1; i <= j; i++, j--) {
            if (i == j && set.contains(S.charAt(i))) {
                count++;
                break;
            }
            if (set.contains(S.charAt(i))) {
                count++;
            }
            if (set.contains(S.charAt(j))) {
                count++;
            }
        }
        return count;
    }


    /**
     * 优化版本使用数组代替hash
     *
     * @param J
     * @param S
     * @return
     */
    public int optimizeNumJewelsInStones(String J, String S) {
        int slength = S.length();
        int jlength = J.length();
        if (slength == 0 || jlength == 0) {
            return 0;
        }
        int[] set = new int[128];
        for (int i = 0; i < jlength; i++) {
            set[J.charAt(i)] = 1;
        }
        int count = 0;
        for (int i = 0, j = slength - 1; i < j; i++, j--) {
            count += set[S.charAt(i)];
            count += set[S.charAt(j)];
        }
        return slength % 2 != 0 ? count + set[S.charAt(slength / 2)] : count;
    }

    public static void main(String[] args) {
        String j = "ebd";
        String s = "bbb";
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        jewelsAndStones.optimizeNumJewelsInStones(j, s);

    }
}
