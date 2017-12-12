package org.dangerous.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 * Created by limeng on 17-12-11.
 */
public class SortCharactersByFrequency {
    int index = 0;

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(o -> {
                    int count = o.getValue().intValue();
                    while (count > 0) {
                        result[index++] = o.getKey();
                        count--;
                    }
                }
        );
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("cccaabbbbb"));
    }
}
