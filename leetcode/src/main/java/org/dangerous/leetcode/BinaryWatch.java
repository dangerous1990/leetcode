package org.dangerous.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-watch/
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        // top bottom
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= 4; i++) {
            if (num - i >= 0) {
                map.put(i, num - i);
            }
        }
        List<String> result = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> top = new ArrayList<>();
            List<Integer> bottom = new ArrayList<>();
            backtrace(entry.getKey(), 0, 0, 4, top, 0);
            backtrace(entry.getValue(), 0, 0, 6, bottom, 0);
            for (int i = 0; i < top.size(); i++) {
                for (int j = 0; j < bottom.size(); j++) {
                    String str = bottom.get(j) < 10 ? "0" + bottom.get(j) : bottom.get(j).toString();
                    result.add(top.get(i) + ":" + str);
                }
            }
        }
        return result;
    }

    public void backtrace(int size, int index, int prevIndex, int bitCount, List<Integer> l, int x) {
        if (size == index) {
            if (bitCount == 4 && x < 12) {
                l.add(x);
            } else if (bitCount == 6 && x < 60) {
                l.add(x);
            }
            return;
        }
        for (int i = prevIndex; i < bitCount; i++) {
            int b = 1 << i;
            x = x | b;
            backtrace(size, index + 1, i + 1, bitCount, l, x);
            x = x & (b ^ 0xff);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BinaryWatch().readBinaryWatch(1));
    }
}
