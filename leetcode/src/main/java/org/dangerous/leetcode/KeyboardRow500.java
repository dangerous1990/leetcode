package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/keyboard-row
 * Created by Administrator on 2017/3/22.
 */
public class KeyboardRow500 {
    /**
     * 判断每个字符串的字母是否在一行
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        List<Character> row1 = Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        List<Character> row2 = Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        List<Character> row3 = Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm');
        String[] string = new String[]{};
        for (String str : words) {
            char[] arrays = str.toLowerCase().toCharArray();
            boolean isInOne = true;
            boolean isInTwo = true;
            boolean isInThree = true;
            for (int i = 0; i < arrays.length; i++) {
                isInOne &= row1.contains(arrays[i]);
                isInTwo &= row2.contains(arrays[i]);
                isInThree &= row3.contains(arrays[i]);
            }
            if (isInOne) {
                result.add(str);
            }
            if (isInTwo) {
                result.add(str);
            }
            if (isInThree) {
                result.add(str);
            }
        }
        return result.toArray(new String[]{});
    }
}
