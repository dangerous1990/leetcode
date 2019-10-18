package org.dangerous;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        for (; i < v1.length && i < v2.length; i++) {
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[i]);
            if (a < b) {
                return -1;
            }
            if (a > b) {
                return 1;
            }
        }
        if (v1.length == v2.length) {
            return 0;
        }
        if (v1.length < v2.length) {
            for (; i < v2.length; i++) {
                int a = Integer.parseInt(v2[i]);
                if (a > 0) {
                    return -1;
                }
            }
            return 0;
        }
        if (v1.length > v2.length) {
            for (; i < v1.length; i++) {
                int a = Integer.parseInt(v1[i]);
                if (a > 0) {
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("0.1", "1.1"));
        System.out.println(new CompareVersionNumbers().compareVersion("01", "1"));
        System.out.println(new CompareVersionNumbers().compareVersion("1.0", "1"));
    }
}
