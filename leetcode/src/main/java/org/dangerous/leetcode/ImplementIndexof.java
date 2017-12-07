package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/implement-strstr/description/
 * Created by limeng on 17-12-7.
 */
public class ImplementIndexof {
    /**
     * 遍历被查找的字符，查找第一个字符相等的位置，比较每个是否相等，相同位置字符不相等继续查找
     * 483ms -> 8 ms
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (haystack.length() == needle.length() && haystack.equals(needle)) {
            return 0;
        }
        if (needle.length() <= 0) {
            return 0;
        }
        char[] strs = haystack.toCharArray();
        char[] search = needle.toCharArray();
        //最大位置
        int max = strs.length - needle.length();
        for (int i = 0; i <= max; i++) {
            if (strs[i] == search[0]) {
                for (int j = i, k = 0; k < search.length && j < strs.length; j++, k++) {
                    if (strs[j] != search[k]) {
                        break;
                    }
                    if (k == search.length - 1) {
                        return i;
                    }
                }

            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new ImplementIndexof().strStr("mississippi", "issi"));
    }

}
