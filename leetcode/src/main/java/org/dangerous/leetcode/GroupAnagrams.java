package org.dangerous.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String sortStr = String.valueOf(s);
            if (map.get(sortStr) == null) {
                map.put(sortStr, count++);
                res.add(new ArrayList<>(Arrays.asList(strs[i])));
            } else {
                res.get(map.get(sortStr)).add(strs[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
